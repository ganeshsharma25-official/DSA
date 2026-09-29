package fundamentals;

public class SearchInARotatedSortedArrayII {

    /*
     * Given an integer array nums, sorted in ascending order (may contain duplicate
     * values) and a target value k. Now the array is rotated at some pivot point
     * unknown to you. Return True if k is present and otherwise, return False.
     * 
     * Example 1:
     * Input : nums = [7, 8, 1, 2, 3, 3, 3, 4, 5, 6], k = 3
     * 
     * Output: True
     * 
     * Explanation: The element 3 is present in the array. So, the answer is True.
     * 
     * Example 2:
     * Input : nums = [7, 8, 1, 2, 3, 3, 3, 4, 5, 6], k = 10
     * 
     * Output: False
     * 
     * Explanation:The element 10 is not present in the array. So, the answer is
     * False.
     * 
     * 
     * 
     * Intuition
     * For looking for a value k in a rotated sorted array that has duplicates, use
     * binary search for most optimal results. The tricky part is handling
     * duplicates, especially when they are at both ends of the array. Start by
     * finding the sorted half of the array and checking if k is there. If
     * duplicates make it hard to find the sorted half, just skip them by moving our
     * pointers. This way, keep narrowing down the search space efficiently.
     * 
     * Approach
     * Initialize two pointers: low at the start and high at the end of the array.
     * Inside a loop, calculate the midpoint (mid). If nums[mid] is k, return True.
     * Check if nums[low], nums[mid], and nums[high] are equal. If so, increment low
     * and decrement high to skip duplicates.
     * Identify the sorted half: If nums[low] <= nums[mid], the left half is sorted.
     * Otherwise, the right half is sorted.
     * Adjust the pointers based on the k's location: If the left half is sorted and
     * k is within this range, adjust high to mid - 1. Otherwise, adjust low to mid
     * + 1. If the right half is sorted and k is within this range, adjust low to
     * mid + 1. Otherwise, adjust high to mid - 1.
     * Continue this process until low exceeds high. If no target is found, return
     * False.
     * 
     */

    public boolean searchInARotatedSortedArrayII(int[] nums, int k) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (nums[mid] == k) {
                return true;
            }

            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low = low + 1;

                high = high - 1;

                continue;

            }

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= k && nums[mid] >= k) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            } else {
                if (nums[mid] <= k && nums[high] >= k) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        }

        return false;
    }

}
