package onAnswers;

public class SmallestDivisor {
    public int smallestDivisor(int[] nums, int limit) {

        if (nums.length > limit) {
            return -1;
        }

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

            int mid = low + (high - low) / 2;
            int[] divideArr = divideArray(nums, mid);

            int sum = arraySum(divideArr);

            if (sum <= limit) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return result;
    }

    public int[] divideArray(int[] nums, int k) {
        int[] resultArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            double ans = (double) nums[i] / (double) k;
            int ceil = (int) Math.ceil(ans);
            resultArr[i] = ceil;
        }
        return resultArr;
    }

    public int arraySum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };

        SmallestDivisor obj = new SmallestDivisor();

        int result = obj.smallestDivisor(nums, 8);

        System.out.println("Result-->" + result);

    }

}
