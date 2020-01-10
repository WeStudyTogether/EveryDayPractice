
/**
* @author Guangyao Gou
* @date 2020/12/10 11:12:32
* @ClassName LeetCode3.java
* @Description 类描述
*/

public class LeetCode3 {
 public static int lengthOfLongestSubstring(String s) {
     char[] chars = s.toCharArray();
     int max = 0;
     int leftIndex = 0;
        for (int i = 0; i<s.length(); i++) {
            for(int j=leftIndex; j<i; j++) {
                if(chars[i] == chars[j]) {
                    max = Math.max(max, i-leftIndex);
                    leftIndex = j + 1;
                    break;
                }
            }
        }
        
        return Math.max(max, s.length() - leftIndex);
    }
 
 public static void main(String[] args) {
    String s ="pabcwwkew";
    int i = lengthOfLongestSubstring(s);
    System.out.println(i);
}
}
