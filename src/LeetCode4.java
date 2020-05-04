

/**
 * @author Guangyao Gou
 * @date 2020/17/10 12:17:00
 * @ClassName LeetCode4.java
 * @Description 类描述
 */

public class LeetCode4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l = nums1.length + nums2.length;
        int s = 0;
        int a = 0;
        int[] nums = new int[l];
        for (int i = 0; i < nums1.length; i++) {
            if (nums2 == null) {
                nums[s] = nums1[i];
                s = s + 1;
            }
            else {
                for (int j = a; j < nums2.length; j++) {
                    if (nums2[j] < nums1[i]) {
                        nums[s] = nums2[j];
                        s = s + 1;
                        a = a + 1;
                    } else {
                        nums[s] = nums1[i];
                        s = s + 1;
                        break;
                    }
                }
            }

        }
        if (a < nums2.length) {
            for (; a < nums2.length; a++) {
                nums[s] = nums2[a];
                s = s + 1;
            }
        }
        if( s<nums1.length) {
            for (; s < nums1.length; s++) {
                nums[s] = nums1[s];
            }
        }

        if (l % 2 == 0)
            return (double) (nums[l / 2] + nums[l / 2 - 1]) / 2;

        else
            return (double) nums[l / 2];

    }

    public static void main(String[] args) {
        int[] nums1 = new int[] { 2 };
        int[] nums2 = new int[] {};
        double m = findMedianSortedArrays(nums1, nums2);
        System.out.println(m);

        int l = nums1.length + nums2.length;
        int s = 0;
        int a = 0;
        int[] nums = new int[l];
        for (int i = 0; i < nums1.length; i++) {        
            for (int j = a; j < nums2.length; j++) {
                if (nums2[j] < nums1[i]) {
                    nums[s] = nums2[j];
                    s = s + 1;
                    a = a + 1;
                } else {
                    nums[s] = nums1[i];
                    s = s + 1;
                    break;
                }
            }
        }
        
        if (a < nums2.length) {
            for (; a < nums2.length; a++) {
                nums[s] = nums2[a];
                s = s + 1;
            }
        } 
        if( s<nums1.length) {
            for (; s < nums1.length; s++) {
                nums[s] = nums1[s];
            }
        }
        
        for (int i = 0; i < l; i++) {
            System.out.println(nums[i]);
        }
    }

}
