package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.List;

public class SpecialOffers {

    public SpecialOffers() {}

    public List<String> applySpecialOffer(Integer countM, Integer lowerBoundOffer, Integer upperBoundOffer, String s) {
        List<String> list = new ArrayList<>();
        int sum = 0;
        int mod = 0;
        int count = countM;
        if (upperBoundOffer == 0) {
            mod = lowerBoundOffer;
        } else {
            mod = Math.min(Math.max(countM, lowerBoundOffer), upperBoundOffer);
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
        int countForB = 0;
        int countForM = 0;
        int countForQ = 0;
        List<String> itemsToRemove = new ArrayList<>();
        List<String> itemsToAdd = new ArrayList<>();

        for (String s : orderList) {
            for (SpecialOffer specialOfferDatum : DataWarehouse.specialOfferData) {
                if (s.contains(String.valueOf(specialOfferDatum.getItem()))) {
                    List<String> nResult =
                        applySpecialOffer(HelperUtils.getItemQuantity(s), specialOfferDatum.getLowerBoundOffer(),
                            specialOfferDatum.getUpperBoundOffer(), HelperUtils.getItemName(s));
                    itemsToAdd.addAll(nResult);
                    itemsToRemove.add(s);
                    break;
                }
            }
        }

        orderList.removeAll(itemsToRemove);
        orderList.addAll(itemsToAdd);

        itemsToAdd.clear();
        itemsToRemove.clear();

        for (String s : orderList) {
            for (SpecialDeal specialDealDatum : DataWarehouse.specialDealData) {
                if (s.contains(String.valueOf(specialDealDatum.getFreeItem()))) {
                    itemsToRemove.add(s);
                    itemsToAdd.addAll(applySpecialOffer(HelperUtils.getItemQuantity(s),
                        specialDealDatum.getLowerBoundOffer(), specialDealDatum.getUpperBoundOffer(),
                        HelperUtils.getItemName(s)));
                    break;
                }
            }
        }

        orderList.removeAll(itemsToRemove);
        orderList.addAll(itemsToAdd);

        itemsToAdd.clear();
        itemsToRemove.clear();

        for (String s : orderList) {
            for (SpecialDeal specialDealDatum : DataWarehouse.specialDealData) {
                if (s.contains(String.valueOf(specialDealDatum.getEligibilityQuota()))) {
                    itemsToRemove.add(specialDealDatum.getFreeItemAlias());
                    break;
                }
            }
        }

        itemsToRemove.forEach(orderList::remove);

        for (String s : orderList) {
            for (SpecialDeal specialDealDatum : DataWarehouse.specialDealData) {
                if (s.contains(String.valueOf(specialDealDatum.getFreeItem()))) {
                    itemsToRemove.add(s);
                    specialDealDatum.incrementCummulativeValue();
                    break;
                }
            }
//            if (s.contains("B")) {
//                itemsToRemove.add(s);
//                countForB++;
//            }
//
//            if (s.contains("M")) {
//                itemsToRemove.add(s);
//                countForM++;
//            }
//
//            if (s.contains("Q")) {
//                itemsToRemove.add(s);
//                countForQ++;
//            }
        }

        for (SpecialDeal specialDealDatum : DataWarehouse.specialDealData) {
            if (specialDealDatum.getCummulativeValue() > 0) {
                itemsToAdd.addAll(applySpecialOffer(specialDealDatum.getCummulativeValue(),
                    specialDealDatum.getCummulativeLowerBoundOffer(), specialDealDatum.getCummulativeUpperBoundOffer(),
                    String.valueOf(specialDealDatum.getFreeItem())));
            }
        }

//        if (countForB > 0) {
//            itemsToAdd.addAll(applySpecialOffer(countForB, 2, 0, "B"));
//        }
//
//        if (countForM > 0) {
//            itemsToAdd.addAll(applySpecialOffer(countForM, 1, 0, "M"));
//        }
//
//        if (countForQ > 0) {
//            itemsToAdd.addAll(applySpecialOffer(countForQ, 3, 0, "Q"));
//        }

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

            total = total - ((count2F - 1) * DataWarehouse.priceList.getOrDefault("1F", 0));
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
            total = total - (Math.min(count1F, count2F) * DataWarehouse.priceList.getOrDefault("1F", 0));
        }

        if (orderList.contains("3U") && !orderList.contains("1U")) {
            int count3U = 0;
            for(String s : orderList) {
                if (s.equals("3U")) {
                    count3U++;
                }
            }

            total = total - ((count3U - 1) * DataWarehouse.priceList.getOrDefault("1U", 0));
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

            total = total - (Math.min(count1U, count3U) * DataWarehouse.priceList.getOrDefault("1U", 0));
        }

        return total;
    }
}





