package ArrayHard;

import java.util.Arrays;

public class MergeSortedArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0 && i >= 0) {

            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
                k--;
            } else {
                nums1[k] = nums2[j];
                j--;
                k--;
            }
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = { 0, 2, 7, 8, 0, 0, 0 };
        int[] nums2 = { -7, -3, -1 };

        MergeSortedArrays obj = new MergeSortedArrays();
        obj.merge(nums1, 4, nums2, 3);

        System.out.println(Arrays.toString(nums1));
    }

}
