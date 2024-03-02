package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        HashMap<String, Integer> priceList = new HashMap<>();
        priceList.put("A", 50);
        priceList.put("B", 30);
        priceList.put("C", 20);
        priceList.put("D", 15);
        priceList.put("E", 40);
        priceList.put("1A", 50);
        priceList.put("1B", 30);
        priceList.put("1C", 20);
        priceList.put("1D", 15);
        priceList.put("1E", 40);
        priceList.put("3A", 130);
        priceList.put("5A", 200);
        priceList.put("2B", 45);
        priceList.put("2E", 80);
        priceList.put("1BFree", 0);

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
        }

        compressedValues.removeAll(itemsToRemove);
        compressedValues.addAll(itemsToAdd);

        itemsToAdd.clear();

        for (String s: compressedValues) {
            if (s.equals("2E")) {
                itemsToAdd.add("1BFree");
            }
        }

        int total = 0;

        for (String s : compressedValues) {
            if (priceList.containsKey(s)) {
                total = total + priceList.getOrDefault(s, 0);
            }
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
            while (i < items.length - 1 && items[i] == items[i+1] && (items[i] == 'A' || items[i] == 'B' || items[i] == 'E')) {
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




