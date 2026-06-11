import java.util.HashSet;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = { 0, 0, 3, 3, 5, 6 };

        int removeDuplicates = removeDuplicates(nums);
        System.out.println(removeDuplicates);

    }

    public static int removeDuplicates(int[] nums) {

        int count = 0;
        int nextNum = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nextNum != nums[i]) {
                count++;
                nextNum = nums[i];
            }
        }

        return count;
    }

    // public static int removeDuplicates(int[] nums) {

    // int count = 0;
    // int[] check = new int[nums.length];
    // for (int i = 0; i < nums.length; i++) {
    // boolean exists = false;
    // for (int j = 0; j < check.length; j++) {

    // if (nums[i] == check[j]) {
    // exists = true;
    // }
    // }
    // if (!exists) {
    // check[count] = nums[i];
    // count++;
    // }
    // }
    // return count;
    // }

    public static int removeDuplicatesSet(int[] nums) {

        HashSet<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }
        return numSet.size();
    }

}
