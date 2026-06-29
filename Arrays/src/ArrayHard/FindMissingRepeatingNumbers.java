package ArrayHard;

import java.util.Arrays;

/*

Given an integer array nums of size n containing values from [1, n] and each value appears exactly once in the array, except for A, which appears twice and B which is missing.

Return the values A and B, as an array of size 2, where A appears in the 0-th index and B in the 1st index.

Note: You are not allowed to modify the original array.
Example 1
Input: nums = [3, 5, 4, 1, 1]
Output: [1, 2]
Explanation:
1 appears two times in the array and 2 is missing from nums

Example 2
Input: nums = [1, 2, 3, 6, 7, 5, 7]
Output: [7, 4]
Explanation:
7 appears two times in the array and 4 is missing from nums.

*/

public class FindMissingRepeatingNumbers {

    public int[] findMissingRepeatingNumbers(int[] nums) {

        int[] result = new int[2];

        int sum = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            sum = sum + nums[i];
            if(i != 0 && nums[i] == nums[i - 1]){
                result[0] = nums[i];
            }
        }
        int n = nums.length;
        int missingNo = (n * (n + 1)) / 2 - (sum - result[0]);
        result[1] = missingNo;
        return result;

    }

}
