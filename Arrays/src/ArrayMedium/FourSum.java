package ArrayMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        left++;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                    } else if (nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        right--;
                        while (right > left && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else {
                        List<Integer> tempList = new ArrayList<>();
                        tempList.add(nums[i]);
                        tempList.add(nums[j]);
                        tempList.add(nums[left]);
                        tempList.add(nums[right]);

                        resultList.add(tempList);
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }

                        while (right > left && nums[right] == nums[right - 1]) {
                            right--;
                        }
                    }
                }

            }

        }
        return resultList;

    }

    public static void main(String[] args) {
        int[] nums = { 87, 97, -20, 30, -3, -35, 99, -96, 73, -51, -3, 43, -18, 61, 38, 37, -25, 51, -76, 5, 83, 44, 49,
                5, -61, 82, -11, -60, 29, 19, -93, -44, 75, 95, -91, 49, 54, 22, -4, 70, 78, 83, 60, 44, 71, -73, -99,
                74, -58, 31, -33, -71, 17, -24, -54, -37, -51, -54, 47, -57, 34, 67, 23, -45, 50, 26, 64, 100, 82, 77,
                78, -99, 21, -34, 94, -52, 14, 100, 56, -91, 55, 16, -33, 39, -94, 29, -42, -27, 100 }; // target 1

        int[] nums2 = { 1, -2, 3, 5, 7, 9 }; // targer 7

        System.out.println(fourSum(nums2, 24).toString());
    }

}
