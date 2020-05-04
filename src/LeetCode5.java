
/**
 * @author Guangyao Gou
 * @date 2020/44/10 22:44:01
 * @ClassName LeetCode5.java
 * @Description 类描述
 */

public class LeetCode5 {
    public static String longestPalindrome(String s) {
        String m;
        char[] chars = s.toCharArray();
        int max = 0;

        int leftIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = leftIndex; j < i; j++) {
                if (chars[i] == chars[j]) {
                    max = Math.max(max, i - leftIndex + 1);
                    leftIndex = j + 1;
                    break;
                }
            }
        }

        int leftIndex1 = 0;
        char[] a = new char[max];
        for (int i = 0; i < s.length(); i++) {
            for (int j = leftIndex1; j < i; j++) {
                if (chars[i] == chars[j]) {
                    if (max == i - leftIndex1 + 1) {
                        for (i = 0; i < max; i++) {
                            a[i] = chars[leftIndex1 + i];
                        }
                    }
                    leftIndex1 = j + 1;
                    break;
                }
            }
        }
        m = new String(a);
        return m;
//        if (s ==null || s.length() == 0) {
//            return "";
//        }
        
    }

    public static void main(String[] args) {
        String s = longestPalindrome("abcbdefc");
        System.out.println(s);
        String A = "abcbdefc";
        System.out.println(A);

    }
}
