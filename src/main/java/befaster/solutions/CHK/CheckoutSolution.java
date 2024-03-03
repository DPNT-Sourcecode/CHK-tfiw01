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

        if (isGroupPricingPresentIn(orderList)) {
            specialOffers.updateOrderListForSpecialOffersItemGrouping(orderList);
        }

        for (String s : orderList) {
            if (PriceListDataWareHouse.priceList.containsKey(s)) {
                total = total + PriceListDataWareHouse.priceList.getOrDefault(s, 0);
            }
        }

        if (orderList.contains("2F") && !orderList.contains("1F")) {
            int count2F = 0;
            for(String s : orderList) {
                if (s.equals("2F")) {
                    count2F++;
                }
            }

            total = total - ((count2F - 1) * PriceListDataWareHouse.priceList.getOrDefault("1F", 0));
        }

        if (orderList.contains("2F") && orderList.contains("1F")) {
            int count1F = 0;
            int count2F = 0;
            for(String s : orderList) {
                if (s.contains("1F")) {
                    count1F++;
                }
                if (s.contains("2F")) {
                    count2F++;
                }
            }
            total = total - (Math.min(count1F, count2F) * PriceListDataWareHouse.priceList.getOrDefault("1F", 0));
        }

        if (orderList.contains("3U") && !orderList.contains("1U")) {
            int count3U = 0;
            for(String s : orderList) {
                if (s.equals("3U")) {
                    count3U++;
                }
            }

            total = total - ((count3U - 1) * PriceListDataWareHouse.priceList.getOrDefault("1U", 0));
        }

        if (orderList.contains("3U") && orderList.contains("1U")) {
            int count1U = 0;
            int count3U = 0;
            for(String s : orderList) {
                if (s.contains("1U")) {
                    count1U++;
                }
                if (s.contains("3U")) {
                    count3U++;
                }
            }
            total = total - (Math.min(count1U, count3U) * PriceListDataWareHouse.priceList.getOrDefault("1U", 0));
        }

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

