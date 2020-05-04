import java.util.Scanner;

/**
 * @author Guangyao Gou
 * @date 2020/33/12 21:33:39
 * @ClassName lxc0113.java
 * @Description 类描述
 */

public class lxc0113 {
    private static int MyAlgorithm(String s) {
        int sum = 1;
        char[] chars = new char[s.length()];
        chars = s.toCharArray();
        int left = 0, right = 0;
//        int leftbit = 0, rightbit = 0;
        int leftvalue = 0, rightvalue = 0;
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == '-') {
                for (int j = i; j >= 0; j--) {
                    if (chars[j] == '*') {
                        left = j + 1;
                    }
                }
//                leftbit = i - left;
                for (int m = left; m < i; m++) {
                    leftvalue = leftvalue * 10 + (int) chars[m];
                }

                for (int k = i; k < s.length(); k++) {
                    if (chars[k] == '*') {
                        right = k - 1;
                    }
                }
//                rightbit = right - i;
                for (int n = i+1; n <= right; n++) {
                    leftvalue = leftvalue * 10 + (int) chars[n];
                }
                sum = sum*(leftvalue-rightvalue);
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String s= sc.nextLine();
        sc.close();
        int result = MyAlgorithm(s);
        System.out.println(result);
    }
}
