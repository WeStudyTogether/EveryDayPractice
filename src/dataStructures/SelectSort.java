package dataStructures;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Guangyao Gou
 * @date 2020/59/03 17:59:06
 * @ClassName SelectSort.java
 * @Description 类描述
 */

public class SelectSort {
    public static void main(String[] args) {

        int[] arr =new  int[80000];
        for(int i = 0; i<80000;i++) {
            arr[i] = (int) (Math.random() * 100000);            
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datestr = simpleDateFormat.format(date);
       
        System.out.println(Arrays.toString(arr));
        System.out.println(datestr);
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(datestr);
    }

    public static void selectSort(int[] arr) {
        
        for(int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for(int j = i + 1 ; j< arr.length; j++) {
                if(min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
        
    }
}
