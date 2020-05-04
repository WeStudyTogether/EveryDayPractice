package dataStructures;

import java.util.Arrays;

/**
 * @author Guangyao Gou
 * @date 2020/16/03 20:16:04
 * @ClassName InsertSort.java
 * @Description 类描述
 */

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = { 101, 34, 119, 1, -1, 89 };
        insertSort(arr);

    }

    public static void insertSort(int[] arr) {
        for(int i = 1; i<arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i-1;

            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if(insertIndex +1 !=i) {
                arr[insertIndex + 1] = insertVal;
            }

            System.out.println(Arrays.toString(arr));
            System.out.println();
        }
        
    }
}
