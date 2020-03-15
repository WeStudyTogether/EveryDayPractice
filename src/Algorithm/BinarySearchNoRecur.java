package Algorithm;

/**
* @author Guangyao Gou
* @date 2020/38/14 15:38:05
* @ClassName BinarySearchNoRecur.java
* @Description 类描述
*/

public class BinarySearchNoRecur {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = {1,3,8,10,11,67,100};
        int index = binarySearch(arr, 80);
        System.out.println(index);
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while(left<=right) {
            int mid = (left +right)/2;
            if(arr[mid] == target) {
                return mid;
            }else if (arr[mid] > target) {
                right = mid - 1;
            }else{
               left = mid + 1;
            }
        }
        return -1;
    }
}
