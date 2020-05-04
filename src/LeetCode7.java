import java.util.Arrays;

/**
* @author Guangyao Gou
* @date 2020/38/06 17:38:09
* @ClassName LeetCode7.java
* @Description 类描述
*/

public class LeetCode7 {
public static int reverse(int x) {
        String s = String.valueOf(x);
        String[] a = new String[s.length()];
        String temp;
        for(int i = 0; i < s.length(); i++) {
            a[i] = String.valueOf(s.charAt(i));
        }
        if(a[0] == "-") {
            for(int i = 1; i <= s.length()/2; i++) {
                temp = a[i];
                a[i] = a[s.length()-i];
                a[s.length()-i] = temp;
            }
            if(a[1] == "0") {
                String[] b = new String[s.length()-1];
                b[0] = a[0];
                for(int i = 1; i < s.length()-1; i++) {
                    b[i] = a[i+1];
                }
                s = b.toString();
                return Integer.parseInt(s);
            }
            else {
                s = a.toString();
                return Integer.parseInt(s);
            }
        }
        
        else {
            for(int i = 0; i < s.length()/2; i++) {
                temp = a[i];
                a[i] = a[s.length()-1-i];
                a[s.length()-1-i] = temp;
            }
            if(a[0] == "0") {
                String[] b = new String[s.length()-1];
                for(int i = 0; i < s.length()-1; i++) {
                    b[i] = a[i+1];
                }
                s = b.toString();
                return Integer.parseInt(s);
            }
            else {
                s = Arrays.toString(a);
                return Integer.parseInt(s);
            }
        }  

    }

public static void main(String[] args) {
    int x = 123;
    int a = reverse(x);

    System.out.println(a);
}
}
