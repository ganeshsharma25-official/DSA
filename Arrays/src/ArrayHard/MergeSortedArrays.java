package ArrayHard;

import java.util.Arrays;

/*
Given two integer arrays nums1 and nums2. Both arrays are sorted in non-decreasing order.



Merge both the arrays into a single array sorted in non-decreasing order.



The final sorted array should be stored inside the array nums1 and it should be done in-place.


nums1 has a length of m + n, where the first m elements denote the elements of nums1 and rest are 0s.


nums2 has a length of n.

Example 1

Input: nums1 = [-5, -2, 4, 5], nums2 = [-3, 1, 8]

Output: [-5, -3, -2, 1, 4, 5, 8]

Explanation:

The merged array is: [-5, -3, -2, 1, 4, 5, 8], where [-5, -2, 4, 5] are from nums1 and [-3, 1, 8] are from nums2

Example 2

Input: nums1 = [0, 2, 7, 8], nums2 = [-7, -3, -1]

Output: [-7, -3, -1, 0, 2, 7, 8]

Explanation:

The merged array is: [-7, -3, -1, 0, 2, 7, 8], where [0, 2, 7, 8] are from nums1 and [-7, -3, -1] are from nums2

Example 3

Input: nums1 = [1, 3, 5], nums2 = [2, 4, 6, 7]

Output:

[1, 2, 3, 4, 5, 6, 7]
*/

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
