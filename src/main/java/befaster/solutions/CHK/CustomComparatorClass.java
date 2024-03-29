package befaster.solutions.CHK;

import java.util.Comparator;
import java.util.HashMap;

public class CustomComparatorClass implements Comparator<String> {

    private final HashMap<String, Integer> dataMap;

    public CustomComparatorClass(HashMap<String, Integer> dataMap) {
        this.dataMap = dataMap;
    }

    @Override
    public int compare(String s, String t1) {
        try {
            if (dataMap.get(s) > dataMap.get(t1)) {
                return -1;
            } else if (dataMap.get(s) < dataMap.get(t1)) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            System.out.println(s);
            throw new RuntimeException();
        }

    }
}
