import java.util.Scanner;

/**
 * @author Guangyao Gou
 * @date 2020/50/12 17:50:05
 * @ClassName lxc0112.java
 * @Description 类描述
 */

public class lxc0112 {
    private static int SkValue(int[] array, int K) {
        int Sk = 0;
        int maxSk = 0;
        int l = array.length;
        boolean isPrime = true;
        for (int i = 0; i < l + 1 - K; i++) {
            Sk = 0;
            for (int j = i; j < i + K; j++) {
                for (int val = 2; val < array[j]; val++) {
                    if (array[j] % val == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (!isPrime) {
                    isPrime = true;
                    break;
                }

                else
                    Sk = Sk + array[j];
            }
            maxSk = Math.max(maxSk, Sk);
        }
        return maxSk;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int K = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        sc.close();
        int MaxSk = SkValue(array, K);
        System.out.println(MaxSk);
    }
}
