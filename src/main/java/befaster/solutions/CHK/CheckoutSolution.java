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
        priceList.put("1A", 50);
        priceList.put("1B", 30);
        priceList.put("1C", 20);
        priceList.put("1D", 15);
        priceList.put("3A", 130);
        priceList.put("2B", 45);

        char[] items = skus.toCharArray();
        Arrays.sort(items);

        for (char item : items) {
            if (!priceList.containsKey(String.valueOf(item))) {
                return -1;
            }
        }




        return -1;
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

    public List<String> compress(String s) {
        char[] chars = s.toCharArray();
        String bundle = "";
        List<String> result = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            while (i < chars.length - 1 && chars[i] == chars[i+1] && (chars[i] == 'A' || chars[i] == 'B')) {
                bundle = bundle.concat(String.valueOf(chars[i]));
                i++;
            }

            bundle = bundle.concat(String.valueOf(chars[i]));
            result.add(getStringValue(bundle));
            bundle = "";
        }

        return result;
    }
}
