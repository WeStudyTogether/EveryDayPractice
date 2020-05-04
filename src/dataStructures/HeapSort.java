package dataStructures;

import java.util.Arrays;

/**
 * @author Guangyao Gou
 * @date 2020/19/10 12:19:20
 * @ClassName HeapSort.java
 * @Description 类描述
 */

public class HeapSort {
    public static void main(String[] args) {
        int arr[] = { 4, 6, 8, 5, 9 };
        heapSort(arr);
    }

    public static void heapSort(int arr[]) {
        int temp;
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
               adjustHeap(arr, i, arr.length);
        }
        
        for(int j = arr.length - 1; j > 0 ; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void adjustHeap(int arr[], int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = i * 2 + 1) {
            if (arr[k] < arr[k + 1] && k + 1 < length) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }
}
