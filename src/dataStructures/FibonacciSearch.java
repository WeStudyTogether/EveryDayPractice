package dataStructures;

import java.util.Arrays;

/**
 * @author Guangyao Gou
 * @date 2020/05/05 11:05:56
 * @ClassName FibonacciSearch.java
 * @Description 类描述
 */

public class FibonacciSearch {

    public static int maxsize = 20;

    public static void main(String[] args) {

        int[] arr = { 1, 8, 10, 89, 1000, 1234 };
        System.out.println(fibSearch(arr, 8));
    }

    public static int[] fib() {
        int[] f = new int[maxsize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxsize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    public static int fibSearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        int k = 0;
        int mid = 0;

        int f[] = fib();
        while (high > f[k] - 1) {
            k++;
        }

        int[] tmp = Arrays.copyOf(a, f[k]);
        for (int i = high + 1; i < tmp.length; i++) {
            tmp[i] = a[high];
        }

        while (low < high) {
            mid = low + f[k - 1] - 1;
            if (key < tmp[mid]) {
                high = mid - 1;
                k--;
            } else if (key > tmp[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }

        }
        return -1;
    }
}
