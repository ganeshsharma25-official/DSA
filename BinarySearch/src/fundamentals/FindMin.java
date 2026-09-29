package fundamentals;

public class FindMin {

    public int findMin(int[] arr) {

        int low = 0;
        int high = arr.length - 1;

        int min = Integer.MAX_VALUE;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (arr[mid] >= arr[low]) {

                min = Math.min(arr[low], min);

                low = mid + 1;
            } else {
                min = Math.min(arr[mid], min);
                high = mid - 1;
            }

        }

        return min;
    }

    public static int singleNonDuplicate(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = ((low + high) / 2);
            System.out.println("MID INDEX-->" + mid + " NUMS[MID]-->" + nums[mid]);
            if (mid < nums.length - 1 && nums[mid] == nums[mid + 1]) {
                high = mid - 1;
            } else if (mid > 0 && nums[mid] == nums[mid - 1]) {
                low = mid + 1;
            } else {
                return nums[mid];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6 };
        int result = singleNonDuplicate(arr);

        System.out.println("Result-->" + result);

    }

}
