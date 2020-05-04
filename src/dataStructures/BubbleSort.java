package dataStructures;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Guangyao Gou
 * @date 2020/54/03 13:54:17
 * @ClassName BubbleSort.java
 * @Description 类描述
 */

public class BubbleSort {

    public static void main(String[] args) {
        int arr[] = { 3, 9, -1, 10, 20 };
        int temp = 0;
        boolean flag = false;// 判断有没有发生排序，没有就结束循环
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            System.out.println("第" + i + "次排序后的数组");
            System.out.println(Arrays.toString(arr));

            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datestr = simpleDateFormat.format(date);
        System.out.println(datestr);
    }
}
