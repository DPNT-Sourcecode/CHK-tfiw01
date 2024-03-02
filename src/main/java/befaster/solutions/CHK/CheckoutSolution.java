package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CheckoutSolution {

    private static final HashMap<String, Integer> priceList;
    private static final List<Character> specialOfferItems =
        List.of('A', 'B', 'E', 'F', 'H', 'K', 'N', 'P', 'Q', 'R', 'U', 'V');

    static {
        priceList = new HashMap<>();
        priceList.put("A", 50); priceList.put("B", 30); priceList.put("C", 20); priceList.put("D", 15);
        priceList.put("E", 40); priceList.put("F", 10); priceList.put("G", 20); priceList.put("H", 10);
        priceList.put("I", 35); priceList.put("J", 60); priceList.put("K", 80); priceList.put("L", 90);
        priceList.put("M", 15); priceList.put("N", 40); priceList.put("O", 10); priceList.put("P", 50);
        priceList.put("Q", 30); priceList.put("R", 50); priceList.put("S", 30); priceList.put("T", 20);
        priceList.put("U", 40); priceList.put("V", 50); priceList.put("W", 20); priceList.put("X", 90);
        priceList.put("Y", 10); priceList.put("Z", 50); priceList.put("1A", 50); priceList.put("1B", 30);
        priceList.put("1C", 20); priceList.put("1D", 15); priceList.put("1E", 40); priceList.put("1F", 10);
        priceList.put("1G", 20); priceList.put("1H", 10); priceList.put("1I", 35); priceList.put("1J", 60);
        priceList.put("1K", 80); priceList.put("1L", 90); priceList.put("1M", 15); priceList.put("1N", 40);
        priceList.put("1O", 10); priceList.put("1P", 50); priceList.put("1Q", 30); priceList.put("1R", 50);
        priceList.put("1S", 30); priceList.put("1T", 20); priceList.put("1U", 40); priceList.put("1V", 50);
        priceList.put("1W", 20); priceList.put("1X", 90); priceList.put("1Y", 10); priceList.put("1Z", 50);
        priceList.put("3A", 130); priceList.put("5A", 200); priceList.put("2B", 45); priceList.put("2E", 80);
        priceList.put("2F", 20);
        priceList.put("2H", 20);
        priceList.put("3H", 30);
        priceList.put("4H", 40);
        priceList.put("5H", 45);
        priceList.put("6H", 60);
        priceList.put("7H", 70);
        priceList.put("8H", 80);
        priceList.put("9H", 90);
        priceList.put("10H", 80); priceList.put("2K", 150);
        priceList.put("3N", 80); priceList.put("2P", 100); priceList.put("3P", 150); priceList.put("4P", 200);
        priceList.put("5P", 200); priceList.put("3Q", 80); priceList.put("3R", 150); priceList.put("3U", 120);
        priceList.put("2V", 90); priceList.put("3V", 130);
    }

    public Integer checkout(String skus) {
        char[] items = skus.toCharArray();
        Arrays.sort(items);

        for (char item : items) {
            if (!priceList.containsKey(String.valueOf(item))) {
                return -1;
            }
        }

        List<String> compressedValues = compress(items);
        List<String> itemsToRemove = new ArrayList<>();
        List<String> itemsToAdd = new ArrayList<>();

        for (String s : compressedValues) {
            if (s.contains("A")) {
                List<String> nResult = decompose(getIntPrefix(s), 3, 5, getStringSuffix(s));
                itemsToAdd.addAll(nResult);
                itemsToRemove.add(s);
            }

            if (s.contains("B")) {
                List<String> nResult = decompose(getIntPrefix(s), 2, 0, getStringSuffix(s));
                itemsToAdd.addAll(nResult);
                itemsToRemove.add(s);
            }

            if (s.contains("E")) {
                List<String> nResult = decompose(getIntPrefix(s), 2, 0, getStringSuffix(s));
                itemsToAdd.addAll(nResult);
                itemsToRemove.add(s);
            }

            if (s.contains("F")) {
                List<String> nResult = decompose(getIntPrefix(s), 2, 0, getStringSuffix(s));
                itemsToAdd.addAll(nResult);
                itemsToRemove.add(s);
            }

            if (s.contains("H")) {
                List<String> nResult = decompose(getIntPrefix(s), 5, 10, getStringSuffix(s));
                itemsToAdd.addAll(nResult);
                itemsToRemove.add(s);
            }

            if (s.contains("K")) {
                List<String> nResult = decompose(getIntPrefix(s), 2, 0, getStringSuffix(s));
                itemsToAdd.addAll(nResult);
                itemsToRemove.add(s);
            }

            if (s.contains("N")) {
                List<String> nResult = decompose(getIntPrefix(s), 3, 0, getStringSuffix(s));
                itemsToAdd.addAll(nResult);
                itemsToRemove.add(s);
            }

            if (s.contains("P")) {
                List<String> nResult = decompose(getIntPrefix(s), 5, 0, getStringSuffix(s));
                itemsToAdd.addAll(nResult);
                itemsToRemove.add(s);
            }

            if (s.contains("Q")) {
                List<String> nResult = decompose(getIntPrefix(s), 3, 0, getStringSuffix(s));
                itemsToAdd.addAll(nResult);
                itemsToRemove.add(s);
            }

            if (s.contains("R")) {
                List<String> nResult = decompose(getIntPrefix(s), 3, 0, getStringSuffix(s));
                itemsToAdd.addAll(nResult);
                itemsToRemove.add(s);
            }

            if (s.contains("U")) {
                List<String> nResult = decompose(getIntPrefix(s), 3, 0, getStringSuffix(s));
                itemsToAdd.addAll(nResult);
                itemsToRemove.add(s);
            }

            if (s.contains("V")) {
                List<String> nResult = decompose(getIntPrefix(s), 2, 3, getStringSuffix(s));
                itemsToAdd.addAll(nResult);
                itemsToRemove.add(s);
            }
        }

        compressedValues.removeAll(itemsToRemove);
        compressedValues.addAll(itemsToAdd);

        itemsToAdd.clear();
        itemsToRemove.clear();

        for (String s: compressedValues) {
            if (s.contains("B")) {
                itemsToRemove.add(s);
                itemsToAdd.addAll(decompose(getIntPrefix(s), 1, 0, getStringSuffix(s)));
            }

            if (s.contains("M")) {
                itemsToRemove.add(s);
                itemsToAdd.addAll(decompose(getIntPrefix(s), 1, 0, getStringSuffix(s)));
            }

            if (s.contains("Q")) {
                itemsToRemove.add(s);
                itemsToAdd.addAll(decompose(getIntPrefix(s), 1, 0, getStringSuffix(s)));
            }
        }

        compressedValues.removeAll(itemsToRemove);
        compressedValues.addAll(itemsToAdd);

        itemsToAdd.clear();
        itemsToRemove.clear();

        for (String s: compressedValues) {
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

        itemsToRemove.forEach(compressedValues::remove);

        int countForB = 0;
        int countForM = 0;
        int countForQ = 0;
        for (String s: compressedValues) {
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
            itemsToAdd.addAll(decompose(countForB, 2, 0, "B"));
        }

        if (countForM > 0) {
            itemsToAdd.addAll(decompose(countForM, 1, 0, "M"));
        }

        if (countForQ > 0) {
            itemsToAdd.addAll(decompose(countForQ, 3, 0, "Q"));
        }

        compressedValues.removeAll(itemsToRemove);
        compressedValues.addAll(itemsToAdd);

        int total = 0;

        for (String s : compressedValues) {
            if (priceList.containsKey(s)) {
                total = total + priceList.getOrDefault(s, 0);
            }
        }

        if (compressedValues.contains("2F") && !compressedValues.contains("1F")) {
            int count2F = 0;
            for(String s : compressedValues) {
                if (s.equals("2F")) {
                    count2F++;
                }
            }

            total = total - ((count2F - 1) * priceList.getOrDefault("1F", 0));
        }

        if (compressedValues.contains("2F") && compressedValues.contains("1F")) {
            total = total - 10;
        }

        if (compressedValues.contains("3U") && !compressedValues.contains("1U")) {
            int count2F = 0;
            for(String s : compressedValues) {
                if (s.equals("3U")) {
                    count2F++;
                }
            }

            total = total - ((count2F - 1) * priceList.getOrDefault("1U", 0));
        }

        if (compressedValues.contains("3U") && compressedValues.contains("1U")) {
            total = total - 40;
        }

        return total;
    }

    public Integer getIntPrefix(String s) {
        String result = "";
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c)) {
                result = result.concat(String.valueOf(c));
            }
        }

        return Integer.valueOf(result);
    }

    public String getStringSuffix(String s) {
        String result = "";
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (Character.isLetter(c)) {
                result = result.concat(String.valueOf(c));
            }
        }

        return result;
    }

    public List<String> decompose(Integer countM, Integer minModM, Integer maxModM, String s) {
        List<String> list = new ArrayList<>();
        int sum = 0;
        int mod = 0;
        int count = countM;
        if (maxModM == 0) {
            mod = minModM;
        } else {
            if (countM < minModM && countM < maxModM) {
                mod = minModM;
            }
            if (countM > minModM && countM < maxModM) {
                mod = minModM;
            }
            if (countM > minModM && countM > maxModM) {
                mod = maxModM;
            }
            if (countM < minModM && countM > maxModM) {
                mod = maxModM;
            }
            if (countM.equals(minModM)) {
                mod = minModM;
            }
            if (countM.equals(maxModM)) {
                mod = maxModM;
            }
        }

        while (count > 0) {
            if (count < mod) {
                mod = minModM;
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

    public String getStringValue(String s) {
        int count = 0;
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            count++;
        }

        return count + (String.valueOf(chars[0]));
    }

    public List<String> compress(char[] items) {
        String bundle = "";
        List<String> result = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            while (i < items.length - 1 && items[i] == items[i+1] && (specialOfferItems.contains(items[i]))) {
                bundle = bundle.concat(String.valueOf(items[i]));
                i++;
            }

            bundle = bundle.concat(String.valueOf(items[i]));
            result.add(getStringValue(bundle));
            bundle = "";
        }

        return result;
    }
}


