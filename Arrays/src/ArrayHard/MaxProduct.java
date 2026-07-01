package ArrayHard;

public class MaxProduct {

    /*
     * Given an integer array nums. Find the subarray with the largest product, and
     * return the product of the elements present in that subarray.
     * 
     * 
     * 
     * A subarray is a contiguous non-empty sequence of elements within an array.
     * 
     * 
     * Example 1
     * 
     * Input: nums = [4, 5, 3, 7, 1, 2]
     * 
     * Output: 840
     * 
     * Explanation:
     * 
     * The largest product is given by the whole array itself
     * 
     * Example 2
     * 
     * Input: nums = [-5, 0, -2]
     * 
     * Output: 0
     * 
     * Explanation:
     * 
     * The largest product is achieved with the following subarrays [0], [-5, 0],
     * [0, -2], [-5, 0, -2].
     */

    public int maxProduct(int[] nums) {

        int prefix = 1;
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            prefix = prefix * nums[i];

            if (prefix > maxProduct) {
                maxProduct = prefix;
            }

            if (prefix == 0) {
                prefix = 1;
            }

        }
        prefix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            prefix = prefix * nums[i];

            if (prefix > maxProduct) {
                maxProduct = prefix;
            }

            if (prefix == 0) {
                prefix = 1;
            }
        }

        return maxProduct;
    }

    // better solution

    public int maxProductII(int[] nums) {

        int result = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;

        int n = nums.length;
        for (int i = 0; i < n; i++) {

            if (prefix == 0)
                prefix = 1;

            if (suffix == 0)
                suffix = 1;

            prefix = prefix * nums[i];

            suffix = suffix * nums[n - 1 - i];

            result = Math.max(result, Math.max(prefix, suffix));

        }

        return result;
    }

}
