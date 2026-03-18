public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    // Highest Occurring Element in an Array

    public int mostFrequentElement(int[] nums) {
        int maxElement = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxElement) {
                maxElement = nums[i];
            }
        }

        int[] hashArr = hashArr(nums, maxElement);
        int frequency = 0;
        int element = -1;
        for (int i = 0; i < hashArr.length; i++) {
            if (hashArr[i] > frequency) {
                element = i;
                frequency = hashArr[i];
            }

            if (hashArr[i] == frequency && i < element) {
                element = i;
                frequency = hashArr[i];
            }
        }
        return element;
    }

    public int[] hashArr(int[] nums, int maxElement) {
        int[] resultArr = new int[maxElement + 1];

        for (int i = 0; i < nums.length; i++) {
            resultArr[nums[i]]++;
        }
        return resultArr;
    }

}
