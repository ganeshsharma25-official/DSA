package ArrayMedium;

import java.util.Arrays;

public class RearrangeArray {

    public static void main(String[] args) {

        int[] arr = { 2, 4, 5, -1, -3, -4 };
        int[] result = rearrangeArrayOpti(arr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] rearrangeArray(int[] nums) {

        int[] positive = new int[nums.length / 2];
        int[] negative = new int[nums.length / 2];

        int countPositive = 0;
        int countNegative = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negative[countNegative] = nums[i];
                countNegative++;
            } else {
                positive[countPositive] = nums[i];
                countPositive++;
            }
        }

        countPositive = 0;
        countNegative = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = positive[countPositive];
                countPositive++;
            } else {
                nums[i] = negative[countNegative];
                countNegative++;
            }
        }

        return nums;

    }

    public static int[] rearrangeArrayOpti(int[] nums) {

        int positiveIndex = 0;
        int negativeIndex = 1;

        int[] resultArr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                resultArr[positiveIndex] = nums[i];
                positiveIndex = positiveIndex + 2;
            } else {
                resultArr[negativeIndex] = nums[i];
                negativeIndex = negativeIndex + 2;
            }
        }
        return resultArr;
    }
}
