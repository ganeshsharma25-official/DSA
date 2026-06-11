public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 4, 5, 6 };
        System.out.println(missingNumber(arr));
    }

    public static int missingNumber(int[] nums) {
        int sum = 0;
        int arrSum = (nums.length * (nums.length + 1)) / 2;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        return arrSum - sum;
    }

}
