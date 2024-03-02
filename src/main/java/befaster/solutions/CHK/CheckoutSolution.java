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

    public List<Integer> decompose(Integer count, Integer mod) {
        List<Integer> list = new ArrayList<>();
        while (true) {
            int x = mod % count;
            if (x == 0) {
                break;
            }
            list.add(x);
            mod -= 3;
        }

        int lastValue = count - 

        list.add()
    }
}



