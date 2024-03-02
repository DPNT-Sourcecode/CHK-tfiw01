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
                List<String> nResult = decompose(Integer.valueOf(s.substring(0, 1)), 3, s.substring(1, 2));
                itemsToAdd.addAll(nResult);
                itemsToRemove.add(s);
            }

            if (s.contains("B")) {
                List<String> nResult = decompose(Integer.valueOf(s.substring(0, 1)), 2, s.substring(1, 2));
                itemsToAdd.addAll(nResult);
                itemsToRemove.add(s);
            }
        }

        compressedValues.removeAll(itemsToRemove);
        compressedValues.addAll(itemsToAdd);

        int total = 0;

        for (String s : compressedValues) {
            if (priceList.containsKey(s)) {
                total = total + priceList.getOrDefault(s, 0);
            }
        }

        return total;
    }

    public List<String> decompose(Integer countM, Integer modM, String s) {
        List<String> list = new ArrayList<>();
        int sum = 0;
        int mod = modM;
        int count = countM;
        while (true) {
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
            while (i < items.length - 1 && items[i] == items[i+1] && (items[i] == 'A' || items[i] == 'B')) {
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

