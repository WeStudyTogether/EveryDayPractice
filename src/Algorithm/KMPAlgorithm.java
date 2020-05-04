package Algorithm;

/**
 * @author Guangyao Gou
 * @date 2020/24/16 19:24:15
 * @ClassName KMPAlgorithm.java
 * @Description 类描述
 */

public class KMPAlgorithm {

    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";// 源字符串
        String str2 = "ABCDABD";// 字串
        int next[]  = kmpNext(str2);
        int index = kmpSearch(str1, str2, next);
        System.out.println(index);
    }

    public static int[] kmpNext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++) {
            while (dest.charAt(i) != dest.charAt(j) && j > 0) {
                j = next[j - 1];

            }
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static int kmpSearch(String str1, String str2, int[] next) {
        for (int i = 0, j = 0; i < str1.length(); i++) {

            while (str1.charAt(i) != str2.charAt(j) && j > 0) {
                j = next[j - 1];
                
            }
            if(str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            
            if(j == str2.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }
}
