package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.List;

public class DataWarehouse {
    public static final HashMap<String, Integer> priceList;
    public static final List<Character> specialOfferItems;
    public static final List<SpecialOffer> specialOfferData;
    public static final List<SpecialDeal> specialDealData;

    static {
        priceList = new HashMap<>();
        priceList.put("A", 50);
        priceList.put("B", 30);
        priceList.put("C", 20);
        priceList.put("D", 15);
        priceList.put("E", 40);
        priceList.put("F", 10);
        priceList.put("G", 20);
        priceList.put("H", 10);
        priceList.put("I", 35);
        priceList.put("J", 60);
        priceList.put("K", 70);
        priceList.put("L", 90);
        priceList.put("M", 15);
        priceList.put("N", 40);
        priceList.put("O", 10);
        priceList.put("P", 50);
        priceList.put("Q", 30);
        priceList.put("R", 50);
        priceList.put("S", 20);
        priceList.put("T", 20);
        priceList.put("U", 40);
        priceList.put("V", 50);
        priceList.put("W", 20);
        priceList.put("X", 17);
        priceList.put("Y", 20);
        priceList.put("Z", 21);
        priceList.put("1A", 50);
        priceList.put("1B", 30);
        priceList.put("1C", 20);
        priceList.put("1D", 15);
        priceList.put("1E", 40);
        priceList.put("1F", 10);
        priceList.put("1G", 20);
        priceList.put("1H", 10);
        priceList.put("1I", 35);
        priceList.put("1J", 60);
        priceList.put("1K", 70);
        priceList.put("1L", 90);
        priceList.put("1M", 15);
        priceList.put("1N", 40);
        priceList.put("1O", 10);
        priceList.put("1P", 50);
        priceList.put("1Q", 30);
        priceList.put("1R", 50);
        priceList.put("1S", 20);
        priceList.put("1T", 20);
        priceList.put("1U", 40);
        priceList.put("1V", 50);
        priceList.put("1W", 20);
        priceList.put("1X", 17);
        priceList.put("1Y", 20);
        priceList.put("1Z", 21);
        priceList.put("3A", 130);
        priceList.put("5A", 200);
        priceList.put("2B", 45);
        priceList.put("2E", 80);
        priceList.put("2F", 20);
        priceList.put("2H", 20);
        priceList.put("3H", 30);
        priceList.put("4H", 40);
        priceList.put("5H", 45);
        priceList.put("6H", 60);
        priceList.put("7H", 70);
        priceList.put("8H", 80);
        priceList.put("9H", 90);
        priceList.put("10H", 80);
        priceList.put("2K", 120);
        priceList.put("3N", 120);
        priceList.put("2P", 100);
        priceList.put("3P", 150);
        priceList.put("4P", 200);
        priceList.put("5P", 200);
        priceList.put("3Q", 80);
        priceList.put("3R", 150);
        priceList.put("3U", 120);
        priceList.put("2V", 90);
        priceList.put("3V", 130);
        priceList.put("1Group", 45);

        specialOfferData = List.of(
            SpecialOffer.Builder.builder()
                .item('A')
                .lowerBoundOffer(3)
                .upperBoundOffer(5)
                .build(),
            SpecialOffer.Builder.builder()
                .item('B')
                .lowerBoundOffer(2)
                .upperBoundOffer(0)
                .build(),
            SpecialOffer.Builder.builder()
                .item('E')
                .lowerBoundOffer(2)
                .upperBoundOffer(0)
                .build(),
            SpecialOffer.Builder.builder()
                .item('F')
                .lowerBoundOffer(2)
                .upperBoundOffer(0)
                .build(),
            SpecialOffer.Builder.builder()
                .item('H')
                .lowerBoundOffer(5)
                .upperBoundOffer(10)
                .build(),
            SpecialOffer.Builder.builder()
                .item('K')
                .lowerBoundOffer(2)
                .upperBoundOffer(0)
                .build(),
            SpecialOffer.Builder.builder()
                .item('N')
                .lowerBoundOffer(3)
                .upperBoundOffer(0)
                .build(),
            SpecialOffer.Builder.builder()
                .item('P')
                .lowerBoundOffer(5)
                .upperBoundOffer(0)
                .build(),
            SpecialOffer.Builder.builder()
                .item('Q')
                .lowerBoundOffer(3)
                .upperBoundOffer(0)
                .build(),
            SpecialOffer.Builder.builder()
                .item('R')
                .lowerBoundOffer(3)
                .upperBoundOffer(0)
                .build(),
            SpecialOffer.Builder.builder()
                .item('U')
                .lowerBoundOffer(3)
                .upperBoundOffer(0)
                .build(),
            SpecialOffer.Builder.builder()
                .item('V')
                .lowerBoundOffer(2)
                .upperBoundOffer(3)
                .build()
        );

        specialDealData = List.of(
            SpecialDeal.Builder.builder()
                .freeItem('B')
                .freeItemAlias("1B")
                .lowerBoundOffer(1)
                .upperBoundOffer(0)
                .eligibilityQuota("2E")
                .build(),
            SpecialDeal.Builder.builder()
                .freeItem('M')
                .freeItemAlias("1M")
                .lowerBoundOffer(1)
                .upperBoundOffer(0)
                .eligibilityQuota("3N")
                .build(),
            SpecialDeal.Builder.builder()
                .freeItem('Q')
                .freeItemAlias("1Q")
                .lowerBoundOffer(1)
                .upperBoundOffer(0)
                .eligibilityQuota("3R")
                .build()
        );

        specialOfferItems = specialOfferData.stream().map(SpecialOffer::getItem).toList();
    }

}
