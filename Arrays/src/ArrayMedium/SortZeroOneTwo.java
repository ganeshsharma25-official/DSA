package ArrayMedium;

import java.util.Arrays;

public class SortZeroOneTwo {

    // naive solution --> time limit exceeded
    public int[] sortZeroOneTwo(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        return nums;
    }

    // better solution

    public int[] sortZeroOneTwoII(int[] nums) {

        int countZero = 0;
        int countOne = 0;
        int countTwo = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                countZero++;
            if (nums[i] == 1)
                countOne++;
            if (nums[i] == 2)
                countTwo++;
        }

        for (int i = 0; i < countZero; i++) {
            nums[i] = 0;
        }

        for (int i = countZero; i < countOne + countZero; i++) {
            nums[i] = 1;
        }

        for (int i = countZero + countOne; i < countOne + countZero + countTwo; i++) {
            nums[i] = 2;
        }
        return nums;
    }

    // optimal solution
    // using three pointers. Algo name --> Dutch National Flag

    public int[] sortZeroOneTwoIII(int[] nums) {

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 2, 2, 2, 0, 1, 0, 1 };
        SortZeroOneTwo object1 = new SortZeroOneTwo();
        // object1.sortZeroOneTwo(nums);
        System.out.println(Arrays.toString(object1.sortZeroOneTwoIII(nums)));
    }

}
