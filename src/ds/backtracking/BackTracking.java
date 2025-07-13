package ds.backtracking;

public class BackTracking {
    public static void main(String[] args) {
        String str = "ABC";
        prepareCombinations(str, "", 0);
    }

    public static void prepareCombinations(String str, String perm, int index) {
        if (str.length() == 0) {
            System.out.println(perm);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            prepareCombinations(newStr, perm + currentChar, index + 1);
        }
    }

}
