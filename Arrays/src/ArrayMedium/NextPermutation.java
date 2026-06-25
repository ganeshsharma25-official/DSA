package ArrayMedium;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = { 35, 45, 87, 49, 72, 63, 60, 74, 90, 42, 47, 50, 69, 12, 45, 10, 30, 61, 6, 55, 9, 96, 89, 43, 5,
                83, 66, 78, 63, 59, 58, 12, 41, 97, 25, 100, 12, 57, 30, 79, 30, 1, 39, 98, 43, 41, 45, 97, 15, 36, 18,
                5, 30, 81, 80, 49, 77, 84, 5, 36, 78, 68, 7, 41, 35, 11, 21, 49, 87, 85, 36, 55, 4, 66, 78, 4, 7, 7 };
        System.out.println(Arrays.toString(nextPermutation(nums)));
    }

    public static int[] nextPermutation(int[] nums) {

        int index = -1;
        int n = nums.length;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return reverseArray(nums, 0, n - 1);
        }

        for (int i = n - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                nums = swap(nums, index, i);
                break;
            }
        }

        // reverse the array from index + 1
        int left = index + 1;
        int right = n - 1;

        nums = reverseArray(nums, left, right);
        return nums;
    }

    public static int[] swap(int[] nums, int left, int right) {

        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        return nums;
    }

    public static int[] reverseArray(int[] nums, int left, int right) {

        while (left < right) {
            nums = swap(nums, left, right);
            left++;
            right--;
        }
        return nums;
    }

}
