import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = { 43, 3, 54, 6, 5, 23 };
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] bubbleSort(int[] nums) {

        for (int i = nums.length; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {

                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }

            }
        }
        return nums;
    }

}
