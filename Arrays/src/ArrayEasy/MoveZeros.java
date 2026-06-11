package ArrayEasy;

import java.util.Arrays;

public class MoveZeros {

    public static void main(String[] args) {
        int[] arr = { 0, 1, 4, 0, 5, 2 };
        System.out.println(Arrays.toString(arr));
        moveZeros(arr);
        System.out.println("Result-->" + Arrays.toString(arr));

    }

    public static void moveZeroes(int[] nums) {
        int zeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroIndex = i;
                break;
            }
        }

        if (zeroIndex < nums.length - 1 && zeroIndex != -1) {
            for (int i = zeroIndex + 1; i < nums.length; i++) {
                if (nums[i] != 0) {
                    swap(nums, i, zeroIndex);
                    zeroIndex++;
                }
            }
        }

    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void moveZeros(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                swap(nums, i, j);
                j++;
            }
        }
    }

}
