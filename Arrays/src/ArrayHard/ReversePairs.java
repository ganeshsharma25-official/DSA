package ArrayHard;

import java.util.ArrayList;
import java.util.List;

public class ReversePairs {

    /*
     * Given an integer array nums. Return the number of reverse pairs in the array.
     * 
     * An index pair (i, j) is called a reverse pair if:
     * 
     * 0 <= i < j < nums.length
     * 
     * nums[i] > 2 * nums[j]
     * 
     * Example 1
     * 
     * Input: nums = [6, 4, 1, 2, 7]
     * 
     * Output: 3
     * 
     * Explanation:
     * 
     * The reverse pairs are:
     * 
     * (0, 2) : nums[0] = 6, nums[2] = 1, 6 > 2 * 1
     * 
     * (0, 3) : nums[0] = 6, nums[3] = 2, 6 > 2 * 2
     * 
     * (1, 2) : nums[1] = 4, nums[2] = 1, 4 > 2 * 1
     * 
     * Example 2
     * 
     * Input: nums = [5, 4, 4, 3, 3]
     * 
     * Output: 0
     * 
     * Explanation:
     * 
     * No pairs satisfy both the conditons.
     */

    public int reversePairs(int[] nums) {

        return mergeSort(nums, 0, nums.length - 1);

    }

    private int mergeSort(int[] nums, int low, int high) {

        int count = 0;
        if (low == high) {
            return 0;
        }
        int mid = (low + high) / 2;
        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);

        count += merge(nums, low, mid, high);

        return count;

    }

    private int merge(int[] nums, int low, int mid, int high) {
        int count = 0;

        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if ((long) nums[left] > (2L * nums[right])) {
                count += (mid - left + 1);
                right++;
            } else {
                left++;
            }
        }

        left = low;
        right = mid + 1;
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left++;
            } else {
                temp.add(nums[right]);
                right++;
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
        // int[] nums = { 6, 4, 1, 2, 7 };
        int[] nums = { 2147483647, 1073741824 };
        ReversePairs obj = new ReversePairs();
        System.out.println(obj.reversePairs(nums));
    }

}
