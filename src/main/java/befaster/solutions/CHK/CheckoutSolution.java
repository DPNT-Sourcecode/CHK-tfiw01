package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckoutSolution {

    public Integer checkout(String skus) {
        char[] items = skus.toCharArray();
        Arrays.sort(items);

        for (char item : items) {
            if (!DataWarehouse.priceList.containsKey(String.valueOf(item))) {
                return -1;
            }
        }

        List<String> orderList = placeOrder(items);

        SpecialsComputation specialsComputation = new SpecialsComputation();
        specialsComputation.applySpecialOffer(orderList);

        int total = 0;

        orderList.sort(new CustomComparatorClass(DataWarehouse.priceList));

        if (specialsComputation.isGroupPricingPresentIn(orderList)) {
            specialsComputation.updateOrderListForSpecialOffersItemGrouping(orderList);
        }

        for (String s : orderList) {
            if (DataWarehouse.priceList.containsKey(s)) {
                total = total + DataWarehouse.priceList.getOrDefault(s, 0);
            }
        }

        total = specialsComputation.applyIdenticalItemDiscounts(total, orderList);

        return total;
    }

    public List<String> placeOrder(char[] items) {
        String bundle = "";
        List<String> result = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            while (i < items.length - 1 && items[i] == items[i+1]
                && (DataWarehouse.specialOfferItems.contains(items[i]))) {
                bundle = bundle.concat(String.valueOf(items[i]));
                i++;
            }

            bundle = bundle.concat(String.valueOf(items[i]));
            result.add(HelperUtils.getItemSum(bundle));
            bundle = "";
        }

        return result;
    }
}


