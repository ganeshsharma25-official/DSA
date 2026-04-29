import java.util.Arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = { 0, 0, 3, 3, 5, 6 };
        // System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(removeDuplicatesOpti(nums)));
    }

    public static int[] removeDuplicates(int[] nums) {

        int count = 0;
        int unique = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                count++;
                continue;
            }
            if (nums[i] != nums[i + 1]) {

                if (count > 0) {
                    nums[unique] = nums[i + 1];
                }
                unique++;
            }
        }
        return nums;
    }

    public static int[] removeDuplicatesOpti(int[] nums) {

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[i + 1] = nums[j];
                i++;
            }
        }
        return nums;
    }

}
