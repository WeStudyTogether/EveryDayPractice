package dataStructures;

import java.util.Arrays;

/**
 * @author Guangyao Gou
 * @date 2020/45/04 20:45:55
 * @ClassName RadixSort.java
 * @Description 类描述
 */

public class RadixSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int arr[] = { 53, 3, 542, 748, 14, 214 };
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int arr[]) {
        int[][] bucket = new int[10][arr.length];

        // 各个桶每次放入的数据个数
        int[] bucketElementCount = new int[10];

        // 得到数组中最大数的位数
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxlength = (max + "").length();
        for (int i = 1; i < maxlength; i++) {
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = (int) (arr[j] / Math.pow(10, i)% 10);
                bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[j];
                bucketElementCount[digitOfElement]++;
            }

            int index = 0;
            for (int k = 0; k < bucket.length; k++) {
                if (bucketElementCount[k] != 0) {
                    for (int l = 0; l < bucketElementCount[k]; l++) {
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
                bucketElementCount[k] = 0;
            }
        }

    }
}
