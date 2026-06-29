package ArrayHard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an integer array nums. Return the number of inversions in the array.

Two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.

It indicates how close an array is to being sorted.

A sorted array has an inversion count of 0.

An array sorted in descending order has maximum inversion.

Example 1

Input: nums = [2, 3, 7, 1, 3, 5]

Output: 5

Explanation:

The responsible indexes are:

nums[0], nums[3], values: 2 > 1 & indexes: 0 < 3

nums[1], nums[3], values: 3 > 1 & indexes: 1 < 3

nums[2], nums[3], values: 7 > 1 & indexes: 2 < 3

nums[2], nums[4], values: 7 > 3 & indexes: 2 < 4

nums[2], nums[5], values: 7 > 5 & indexes: 2 < 5

Example 2

Input: nums = [-10, -5, 6, 11, 15, 17]

Output: 0

Explanation:

nums is sorted, hence no inversions present.

*/

public class NumberOfInversions {

    public long numberOfInversions1(int[] nums) {

        long count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j] && i < j) {
                    count++;
                }
            }
        }

        return count;
    }

    // optimal solution
    public long numberOfInversions(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private long mergeSort(int[] nums, int low, int high) {
        long count = 0;

        // if (low == high) {
        // return count;
        // }
        if (low < high) {
            int mid = (low + high) / 2;

            count = count + mergeSort(nums, low, mid);
            count = count + mergeSort(nums, mid + 1, high);

            count = count + merge(nums, low, mid, high);
        }

        return count;
    }

    private long merge(int[] nums, int low, int mid, int high) {
        long count = 0;
        List<Integer> temp = new ArrayList<>();

        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left++;
            } else {
                temp.add(nums[right]);
                right++;
                count = count + (mid - left + 1);
            }
        }

        while (left <= mid) {
            temp.add(nums[left]);
            left++;
        }

        while (right <= high) {
            temp.add(nums[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfInversions obj = new NumberOfInversions();

        int[] nums = { 0, 2, 2, 1 };
        System.out.println(Arrays.toString(nums));
        System.out.println(obj.numberOfInversions(nums));
        System.out.println(Arrays.toString(nums));

    }

}
