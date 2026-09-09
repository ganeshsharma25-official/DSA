package medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarray {

    /*
     * 
     * Given an array nums of size n and an integer k, find the length of the
     * longest sub-array that sums to k. If no such sub-array exists, return 0.
     * 
     * 
     * Example 1
     * 
     * Input: nums = [10, 5, 2, 7, 1, 9], k=15
     * 
     * Output: 4
     * 
     * Explanation:
     * 
     * The longest sub-array with a sum equal to 15 is [5, 2, 7, 1], which has a
     * length of 4. This sub-array starts at index 1 and ends at index 4, and the
     * sum of its elements (5 + 2 + 7 + 1) equals 15. Therefore, the length of this
     * sub-array is 4.
     * 
     * Example 2
     * 
     * Input: nums = [-3, 2, 1], k=6
     * 
     * Output: 0
     * 
     * Explanation:
     * 
     * There is no sub-array in the array that sums to 6. Therefore, the output is
     * 0.
     * 
     */

    public static void main(String[] args) {
        int[] arr = { -753, -169, -35, -252, -235, -959, 533, -426, 311, 110, -359 };
        System.out.println(longestSubArray(arr, -2296));
    }

    public static int longestSubArray(int[] nums, int k) {

        int prefixSum = 0;
        int maxLength = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (prefixSum == k) {
                maxLength = i + 1;
            }
            prefixSum = prefixSum + nums[i];
            hashMap.put(prefixSum, i);
            int target = prefixSum - k;
            if (hashMap.containsKey(target)) {
                int length = i - hashMap.get(target);
                if (length > maxLength) {
                    maxLength = length;
                }
            }
        }
        return maxLength;
    }

}
