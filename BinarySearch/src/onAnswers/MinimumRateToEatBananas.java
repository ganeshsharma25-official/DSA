package onAnswers;

public class MinimumRateToEatBananas {

    /*
     * A monkey is given n piles of bananas, where the 'ith' pile has nums[i]
     * bananas. An integer h represents the total time in hours to eat all the
     * bananas.
     * 
     * Each hour, the monkey chooses a non-empty pile of bananas and eats k bananas.
     * If the pile contains fewer than k bananas, the monkey eats all the bananas in
     * that pile and does not consume any more bananas in that hour.
     * 
     * Determine the minimum number of bananas the monkey must eat per hour to
     * finish all the bananas within h hours.
     * 
     * Example 1:
     * Input: n = 4, nums = [7, 15, 6, 3], h = 8
     * 
     * Output: 5
     * 
     * Explanation: If Koko eats 5 bananas/hr, he will take 2, 3, 2, and 1 hour to
     * eat the piles accordingly. So, he will take 8 hours to complete all the
     * piles.
     * 
     * Example 2:
     * Input: n = 5, nums = [25, 12, 8, 14, 19], h = 5
     * 
     * Output: 25
     * 
     * Explanation: If Koko eats 25 bananas/hr, he will take 1, 1, 1, 1, and 1 hour
     * to eat the piles accordingly. So, he will take 5 hours to complete all the
     * piles.
     */

    public int minimumRateToEatBananas(int[] nums, int h) {

        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxi) {
                maxi = nums[i];
            }
        }
        int low = 1;
        int high = maxi;

        int result = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int[] divideArr = divideArray(nums, mid);

            long sum = arraySum(divideArr);

            if (sum <= h) {
                result = mid;
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }

        return result;

    }

    public int[] divideArray(int[] nums, int k) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = (int) Math.ceil((double) nums[i] / (double) k);
        }

        return result;
    }

    public long arraySum(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        MinimumRateToEatBananas obj = new MinimumRateToEatBananas();

        int[] nums = { 805306368, 805306368, 805306368 };

        int result = obj.minimumRateToEatBananas(nums, 1000000000);

        System.out.println("Result-->" + result);
    }

}
