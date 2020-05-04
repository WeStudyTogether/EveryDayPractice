
/**
 * @author Guangyao Gou
 * @date 2020/19/08 16:19:07
 * @ClassName LeetCode1.java
 * @Description 类描述
 */

public class LeetCode1 {
    public static int[] twoSum(int[] nums, int target) {
        int i, j;
        int[] a = new int[2];
        for(i = 0; i<nums.length; i++) {
            for(j = i+1; j<nums.length; j++) {
                if (nums[i]+nums[j]==target) {
                   a[0]=i;
                   a[1]=j;
                }
            }
        }
        return a;
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] {2, 7, 11, 15};
        int target = 22;
        int[] a = new int[2];
        a = twoSum(nums,target);
        
        for(int i = 0; i < a.length; i++)
        {
            System.out.println(a[i]);
        }
        
//        int[] arrays = new int[5];  //定义并开辟了一个长度为5的数组
//        // 可以将上面代码分成两句来写
////       int[] array = null;  // 声明一个长度int[]类型的变量，变量会占用一块内存空间，它没有分配初始值。
////       array = new int[5];  //创建一个长度为5的数组，将数组的地址赋给变量arrays。       
//       for(int i = 0; i < arrays.length; i++)
//        {
//            System.out.println("arrays[" + i + "] = " + arrays[i]);
//        }
//        arrays[0] = 3; //数组的第一个元素
//        arrays[1] = 2; //数组的第二个元素
//        arrays[2] = 4; //数组的第一个元素
//        arrays[3] = 1;
//        arrays[4] = 0;    
//        // 数组遍历
//        for(int x : arrays)
//        {
//            System.out.println(arrays[x]);
//        }
//        
//        int[] arr = null;
//        int[] temp = null;  // 声明对象
//        arr = new int[3];   // 开辟一个长度为3的数组       
//        temp = arr; // 发生引用传递，不能出现[]
//        temp[0] = 55;  // 修改数据
//        System.out.println(arr[0]);
    }
}
