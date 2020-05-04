package dataStructures;

import java.util.Arrays;

/**
 * @author Guangyao Gou
 * @date 2020/51/04 13:51:29
 * @ClassName QuickSort.java
 * @Description 类描述
 */

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70};// 1, 3, 4, 1, 3, 1, 4, 2, 6, 1
        quicksort(arr, 0, arr.length - 1);//-9, 78, 0, 23, -567, 70
        System.out.println(Arrays.toString(arr));
    }

    public static void quicksort(int arr[], int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(l + r) / 2];
        int temp;

        while (l < r) {
            while (arr[l] < pivot) {// 在左边找到大于等于pivot的数
                l++;
            }
            while (arr[r] > pivot) {// 在右边找到小于等于pivot的数
                r--;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 避免因为有了与pivot相同的数，而造成死循环
            if (arr[l] == pivot) {
                l++;
            }
            if (arr[r] == pivot) {
                r--;
            }
        }
        
        // 开始左右递归
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            quicksort(arr, left, r);
        }
        if (right > l) {
            quicksort(arr, l, right);
        }

    }
}
