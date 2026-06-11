package ArrayEasy;

import java.util.Arrays;

public class RotateArrayByK {

    public static void main(String[] args) {

        int[] nums = { 3, 4, 1, 5, 3, -5 };
        System.out.println(Arrays.toString(nums));
        // System.out.println(Arrays.toString(rotateArray(nums, 8)));
        System.out.println(Arrays.toString(rotateArrayOptimal(nums, 8)));

    }

    public void rotateArrayByOne(int[] nums) {
        int temp = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums.length - 1 == i) {
                nums[i] = temp;
                break;
            }

            nums[i] = nums[i + 1];
        }
    }
    // time complexity = O(N).

    // left rotate array by k places

    public static int[] rotateArray(int[] nums, int k) {

        int d = k % nums.length;

        int[] temp = new int[d];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = nums[i];
        }

        for (int i = d; i < nums.length; i++) {
            nums[i - d] = nums[i];
        }

        for (int i = (nums.length - d); i < nums.length; i++) {
            nums[i] = temp[d - (nums.length - i)];
        }

        return nums;

    }

    public static int[] reverse(int[] nums, int startIndex, int stopIndex) {

        for (int i = startIndex; i <= stopIndex; i++) {
            if (i < stopIndex) {
                int temp = nums[i];
                nums[i] = nums[stopIndex - i];
                nums[stopIndex - i] = temp;
            }
        }

        return nums;
    }

    public static int[] rotateArrayOptimal(int[] nums, int k) {

        int d = k % nums.length;

        int[] result = reverse(nums, 0, d - 1);
        result = reverse(nums, d, nums.length - 1);
        result = reverse(nums, 0, nums.length - 1);

        return result;

    }
}
