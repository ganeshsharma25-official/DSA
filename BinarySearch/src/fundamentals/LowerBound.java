package fundamentals;

public class LowerBound {

    // public static int lowerBound(int[] nums, int x) {

    // int low = 0;
    // int high = nums.length - 1;

    // while (low <= high) {
    // int mid = (low + high) / 2;

    // if (nums[mid] == x) {
    // while (mid < nums.length && mid >= 0 && nums[mid] == x) {
    // mid--;
    // }
    // return mid + 1;
    // } else if (x > nums[mid]) {
    // low = mid + 1;
    // } else {
    // high = mid - 1;
    // }

    // if (low >= high) {
    // if (low < nums.length && nums[low] > x) {
    // return low;
    // }
    // }
    // }

    // return nums.length;
    // }

    public static int lowerBound(int[] nums, int x) {

        int low = 0;
        int high = nums.length - 1;
        int ans = nums.length;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (nums[mid] >= x) {

                ans = mid;

                high = mid - 1;

            } else {
                low = mid + 1;
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        // int[] nums = { -58210, 52968, 57654, 84387 };
        int[] nums = { 3, 5, 8, 15, 19 };
        // int result = lowerBound(nums, 89401);
        int result = lowerBound(nums, 9);
        System.out.println("Result --> " + result);
    }

}
