package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckoutSolution {

    public Integer checkout(String skus) {
        char[] items = skus.toCharArray();
        Arrays.sort(items);

        for (char item : items) {
            if (!PriceListDataWareHouse.priceList.containsKey(String.valueOf(item))) {
                return -1;
            }
        }

        List<String> orderList = placeOrder(items);

        SpecialOffers specialOffers = new SpecialOffers();
        specialOffers.applySpecialOffer(orderList);

        int total = 0;

        orderList.sort(new CustomComparatorClass(PriceListDataWareHouse.priceList));

        if (specialOffers.isGroupPricingPresentIn(orderList)) {
            specialOffers.updateOrderListForSpecialOffersItemGrouping(orderList);
        }

        for (String s : orderList) {
            if (PriceListDataWareHouse.priceList.containsKey(s)) {
                total = total + PriceListDataWareHouse.priceList.getOrDefault(s, 0);
            }
        }

        total = specialOffers.applyIdenticalItemDiscounts(total, orderList);

        return total;
    }

    public List<String> placeOrder(char[] items) {
        String bundle = "";
        List<String> result = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            while (i < items.length - 1 && items[i] == items[i+1]
                && (SpecialOffers.specialOfferItems.contains(items[i]))) {
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

