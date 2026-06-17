package ArrayMedium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j] == target) && i != j) {
                    return new int[] { i, j };
                }
            }
        }
        return nums;
    }

    // better solution using hashmap;
    public static int[] twoSumII(int[] nums, int target) {

        Map<Integer, Integer> numsMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (numsMap.containsKey(result)) {
                return new int[] { numsMap.get(result), i };
            }
            numsMap.put(nums[i], i);
        }

        return nums;
    }

    // solution with two pointers approach

    public static int[] twoSumIII(int[] nums, int target) {

        int n = nums.length;
        int[] result = new int[2];

        int[][] numsIndex = new int[n][2];

        for (int i = 0; i < n; i++) {

            numsIndex[i][0] = nums[i];
            numsIndex[i][1] = i;
        }

        // sort the 2d array

        Arrays.sort(numsIndex, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        // use two pointers on sorted array

        int left = 0;
        int right = n - 1;

        while (left < right) {

            if (numsIndex[left][0] + numsIndex[right][0] == target) {

                result[0] = numsIndex[left][1];
                result[1] = numsIndex[right][1];
                Arrays.sort(result);
                return result;

            }

            if (numsIndex[left][0] + numsIndex[right][0] < target) {
                left++;
            }
            if (numsIndex[left][0] + numsIndex[right][0] > target) {
                right--;
            }

        }

        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] arr = { -39, 21, -34, -24, -6, 14, 47, 19, -26, -3, 36, -41, -29, 23, -20, -34, 8, 14, -16, 14, 17, -43,
                -10, -44, -20, -48, 11, 37, 39, -39, -19, 14, 16, -18, -10, 49, -14, 37, -40, 16, -7, 36, 13, -36, -40,
                19, -19, -44, 7, 16, 46, -19, -40, -17, 41, -23, -9, -23, 41, -6, 46, -32, 41, 28, 36, -42, -44, 41, 40,
                19, 8, -32, 33, 44, -23, -24, -15, 31, -36, -1, -16, -36, -14, -36, -24, 35, -12, 46 };
        System.out.println(Arrays.toString(twoSumIII(arr, -14)));
    }

}
