public class SecondLargestElement {

    public int secondLargestElement(int[] nums) {

        int largestElement = Integer.MIN_VALUE;
        int secondLargestElement = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > largestElement) {
                secondLargestElement = largestElement;
                largestElement = nums[i];
            } else if (nums[i] > secondLargestElement && nums[i] != largestElement) {
                secondLargestElement = nums[i];
            }

        }

        return secondLargestElement == Integer.MIN_VALUE ? -1 : secondLargestElement;
    }

}
