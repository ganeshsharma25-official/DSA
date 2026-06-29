import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public int[] mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int low, int high) {
        if (low == high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    public void merge(int[] nums, int low, int mid, int high) {

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

    }

    public static void main(String[] args) {
        MergeSort obj = new MergeSort();
        int[] nums = { 3, 2, 4, 1, 3 };
        obj.mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
