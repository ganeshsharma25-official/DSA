package ArrayMedium;

public class KadanesAlgorithm {

    public static void main(String[] args) {

        int[] nums = { 2, 3, 5, -2, 7, -4 };
        System.out.println(maxSubArrayII(nums));
        printMaxSubArray(nums);
    }

    public static int maxSubArray(int[] nums) {

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            int max = nums[i];

            if (max > result) {
                result = max;
            }

            for (int j = i + 1; j < nums.length; j++) {
                max = max + nums[j];

                if (max > result) {
                    result = max;
                }
            }

        }
        return result;
    }

    // kardane's Algorithm
    public static int maxSubArrayII(int[] nums) {
        int max = Integer.MIN_VALUE;

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];

            if (sum > max)
                max = sum;

            if (sum < 0)
                sum = 0;
        }

        return max;
    }

    public static void printMaxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int sum = 0;
        int startIdx = -1;
        int endIdx = -1;

        for (int i = 0; i < nums.length; i++) {
            if (sum == 0)
                startIdx = i;

            sum += nums[i];

            if (sum > max) {
                max = sum;
                endIdx = i;
            }

            if (sum < 0)
                sum = 0;
        }

        for (int i = startIdx; i <= endIdx; i++) {
            System.out.print(" " + nums[i]);
        }
    }

}
