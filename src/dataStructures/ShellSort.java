package dataStructures;

import java.util.Arrays;

/**
 * @author Guangyao Gou
 * @date 2020/47/03 20:47:22
 * @ClassName ShellSort.java
 * @Description 类描述
 */

public class ShellSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

//    public static void shellSort(int[] arr) {
//        int temp;
//        for (int x = arr.length / 2; x >= 1; x /= 2) {
//            for (int i = x; i < arr.length; i++) {
//                for (int j = i - x; j >= 0; j -= x) {
//                    if(arr[j] >arr[j+x]) {
//                        temp = arr[j+x];
//                        arr[j+x] =arr[j];
//                        arr[j] = temp;
//                    }
//                }
//            }
//        }
    
    public static void shellSort(int[] arr) {
        for (int x = arr.length / 2; x >= 1; x /= 2) {
            for (int i = x; i < arr.length; i++) {
                int insertIndex = i - x;
                int inserVal = arr[i];
                while(insertIndex >= 0 && arr[insertIndex] > inserVal) {
                    arr[insertIndex + x] = arr[insertIndex];
                    insertIndex -= x;
                }
                if( insertIndex+x != i) {
                    arr[insertIndex + x] = inserVal;
                }
            }
        }

    }
}
