package befaster.solutions.CHK;

public class HelperUtils {

    public static Integer getItemQuantity(String s) {
        String result = "";
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c)) {
                result = result.concat(String.valueOf(c));
            }
        }

        return Integer.valueOf(result);
    }

    public static String getItemName(String s) {
        String result = "";
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (Character.isLetter(c)) {
                result = result.concat(String.valueOf(c));
            }
        }

        return result;
    }

    public static String getItemSum(String s) {
        int count = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            count++;
        }

        return count + (String.valueOf(chars[0]));
    }

}



