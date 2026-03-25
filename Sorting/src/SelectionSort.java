public class SelectionSort {

    public static void main(String[] args) {

    }

    public static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minNum = nums[i];
            int index = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < minNum) {
                    minNum = nums[j];
                    index = j;
                }
            }
            // swap
            int temp = nums[i];
            nums[i] = minNum;
            nums[index] = temp;

        }
    }

}
