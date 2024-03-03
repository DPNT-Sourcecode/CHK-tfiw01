package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.List;

class SpecialOffers {

    public static final List<Character> specialOfferItems = List.of('A', 'B', 'E', 'F', 'H', 'K', 'N', 'P', 'Q', 'R', 'U', 'V');

    public SpecialOffers() {
    }

    public List<String> applySpecialOffer(Integer countM, Integer lowerBoundOffer, Integer upperBoundOffer, String s) {
        List<String> list = new ArrayList<>();
        int sum = 0;
        int mod = 0;
        int count = countM;
        if (upperBoundOffer == 0) {
            mod = lowerBoundOffer;
        } else {
            if (countM < lowerBoundOffer && countM < upperBoundOffer) {
                mod = lowerBoundOffer;
            }
            if (countM > lowerBoundOffer && countM < upperBoundOffer) {
                mod = lowerBoundOffer;
            }
            if (countM > lowerBoundOffer && countM > upperBoundOffer) {
                mod = upperBoundOffer;
            }
            if (countM < lowerBoundOffer && countM > upperBoundOffer) {
                mod = upperBoundOffer;
            }
            if (countM.equals(lowerBoundOffer)) {
                mod = lowerBoundOffer;
            }
            if (countM.equals(upperBoundOffer)) {
                mod = upperBoundOffer;
            }
        }

        while (count > 0) {
            if (count < mod) {
                mod = lowerBoundOffer;
            }
            int x = mod % count;
            if (x == 0) {
                break;
            }
            sum += x;
            list.add(x + s);
            count -= mod;
        }

        int lastValue = countM - sum;

        if (lastValue > 0) {
            list.add(lastValue + s);
        }

        return list;
    }

    public void applySpecialOffer(List<String> orderList) {
        List<String> itemsToRemove = new ArrayList<>();
        List<String> itemsToAdd = new ArrayList<>();

        for (String s : orderList) {
            if (s.contains("A")) {
                List<String> nResult = applySpecialOffer(HelperUtils.getItemQuantity(s), 3, 5, HelperUtils.getItemName(s));
                itemsToAdd.addAll(nResult);
                itemsToRemove.add(s);
            }

            if (s.contains("B")) {
                List<String> nResult = applySpecialOffer(HelperUtils.getItemQuantity(s), 2, 0, HelperUtils.getItemName(s));
                itemsToAdd.addAll(nResult);
                itemsToRemove.add(s);
            }

            if (s.contains("E")) {
                List<String> nResult = applySpecialOffer(HelperUtils.getItemQuantity(s), 2, 0, HelperUtils.getItemName(s));
                itemsToAdd.addAll(nResult);
                itemsToRemove.add(s);
            }

            if (s.contains("F")) {
                List<String> nResult = applySpecialOffer(HelperUtils.getItemQuantity(s), 2, 0, HelperUtils.getItemName(s));
                itemsToAdd.addAll(nResult);
                itemsToRemove.add(s);
            }

            if (s.contains("H")) {
                List<String> nResult = applySpecialOffer(HelperUtils.getItemQuantity(s), 5, 10, HelperUtils.getItemName(s));
                itemsToAdd.addAll(nResult);
                itemsToRemove.add(s);
            }

            if (s.contains("K")) {
                List<String> nResult = applySpecialOffer(HelperUtils.getItemQuantity(s), 2, 0, HelperUtils.getItemName(s));
                itemsToAdd.addAll(nResult);
                itemsToRemove.add(s);
            }

            if (s.contains("N")) {
                List<String> nResult = applySpecialOffer(HelperUtils.getItemQuantity(s), 3, 0, HelperUtils.getItemName(s));
                itemsToAdd.addAll(nResult);
                itemsToRemove.add(s);
            }

            if (s.contains("P")) {
                List<String> nResult = applySpecialOffer(HelperUtils.getItemQuantity(s), 5, 0, HelperUtils.getItemName(s));
                itemsToAdd.addAll(nResult);
                itemsToRemove.add(s);
            }

            if (s.contains("Q")) {
                List<String> nResult = applySpecialOffer(HelperUtils.getItemQuantity(s), 3, 0, HelperUtils.getItemName(s));
                itemsToAdd.addAll(nResult);
                itemsToRemove.add(s);
            }

            if (s.contains("R")) {
                List<String> nResult = applySpecialOffer(HelperUtils.getItemQuantity(s), 3, 0, HelperUtils.getItemName(s));
                itemsToAdd.addAll(nResult);
                itemsToRemove.add(s);
            }

            if (s.contains("U")) {
                List<String> nResult = applySpecialOffer(HelperUtils.getItemQuantity(s), 3, 0, HelperUtils.getItemName(s));
                itemsToAdd.addAll(nResult);
                itemsToRemove.add(s);
            }

            if (s.contains("V")) {
                List<String> nResult = applySpecialOffer(HelperUtils.getItemQuantity(s), 2, 3, HelperUtils.getItemName(s));
                itemsToAdd.addAll(nResult);
                itemsToRemove.add(s);
            }
        }

        orderList.removeAll(itemsToRemove);
        orderList.addAll(itemsToAdd);

        itemsToAdd.clear();
        itemsToRemove.clear();

        for (String s : orderList) {
            if (s.contains("B")) {
                itemsToRemove.add(s);
                itemsToAdd.addAll(applySpecialOffer(HelperUtils.getItemQuantity(s), 1, 0, HelperUtils.getItemName(s)));
            }

            if (s.contains("M")) {
                itemsToRemove.add(s);
                itemsToAdd.addAll(applySpecialOffer(HelperUtils.getItemQuantity(s), 1, 0, HelperUtils.getItemName(s)));
            }

            if (s.contains("Q")) {
                itemsToRemove.add(s);
                itemsToAdd.addAll(applySpecialOffer(HelperUtils.getItemQuantity(s), 1, 0, HelperUtils.getItemName(s)));
            }
        }

        orderList.removeAll(itemsToRemove);
        orderList.addAll(itemsToAdd);

        itemsToAdd.clear();
        itemsToRemove.clear();

        for (String s : orderList) {
            if (s.equals("2E")) {
                itemsToRemove.add("1B");
            }
            if (s.equals("3N")) {
                itemsToRemove.add("1M");
            }
            if (s.equals("3R")) {
                itemsToRemove.add("1Q");
            }
        }

        itemsToRemove.forEach(orderList::remove);

        int countForB = 0;
        int countForM = 0;
        int countForQ = 0;
        for (String s : orderList) {
            if (s.contains("B")) {
                itemsToRemove.add(s);
                countForB++;
            }

            if (s.contains("M")) {
                itemsToRemove.add(s);
                countForM++;
            }

            if (s.contains("Q")) {
                itemsToRemove.add(s);
                countForQ++;
            }
        }

        if (countForB > 0) {
            itemsToAdd.addAll(applySpecialOffer(countForB, 2, 0, "B"));
        }

        if (countForM > 0) {
            itemsToAdd.addAll(applySpecialOffer(countForM, 1, 0, "M"));
        }

        if (countForQ > 0) {
            itemsToAdd.addAll(applySpecialOffer(countForQ, 3, 0, "Q"));
        }

        orderList.removeAll(itemsToRemove);
        orderList.addAll(itemsToAdd);
    }

    public void updateOrderListForSpecialOffersItemGrouping(List<String> items) {
        int count = 0;
        int endLoopCount = 0;
        List<String> toRemoveList = new ArrayList<>();
        List<String> toAddList = new ArrayList<>();

        List<String> lis = List.of("1S", "1T", "1X", "1Y", "1Z");

        int endLoopItemsListCount = items.stream().filter(lis::contains).toList().size();

        while (endLoopCount < endLoopItemsListCount) {
            if (items.isEmpty()) {
                break;
            }

            for (String eachListItem : items) {
                if (lis.contains(eachListItem) && !eachListItem.equals("1Group")) {
                    if (count == 3) {
                        break;
                    }
                    toRemoveList.add(eachListItem);
                    count++;
                    endLoopCount++;
                }
            }

            if (count == 3) {
                toAddList.add("1Group");
                toRemoveList.forEach(items::remove);
                items.addAll(toAddList);

                toRemoveList.clear();
                toAddList.clear();
                count = 0;
            }
        }
    }

    public boolean isGroupPricingPresentIn(List<String> items) {
        int count = 0;

        List<String> lis = List.of("1S", "1T", "1X", "1Y", "1Z");
        for (String eachListItem : items) {
            if (lis.contains(eachListItem)) {
                if (count == 3) {
                    break;
                }
                count++;
            }
        }

        return count == 3;
    }

    public Integer applyIdenticalItemDiscounts(Integer total, List<String> orderList) {
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
}


