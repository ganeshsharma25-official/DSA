package medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarray {

    public static void main(String[] args) {

        int[] nums = { 1, 5, 2, 3, 1 };
        System.out.println(longestSubarray(nums, 6));
    }

    public static int longestSubarray(int[] nums, int k) {

        int maxLength = 0;
        int prefixSum = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            prefixSum = prefixSum + nums[i];
            if (prefixSum == k) {
                maxLength = i + 1;
            }
            int check = prefixSum - k;
            if (hashMap.containsKey(check)) {
                int count = i - hashMap.get(check);
                maxLength = Math.max(maxLength, count);
            }

            if (!hashMap.containsKey(prefixSum)) {
                hashMap.put(prefixSum, i);
            }
        }
        return maxLength;
    }

    public int floorSqrt(int n) {
        return (int) Math.floor(Math.sqrt(n));
    }
}
