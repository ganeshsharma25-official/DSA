package ArrayMedium;

import java.util.ArrayList;
import java.util.List;

public class Leaders {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 5, 3, 1, 2 };
        System.out.println(leaders(arr).toString());
    }

    public static List<Integer> leaders(int[] nums) {

        List<Integer> leaders = new ArrayList<>();
        int lastElement = Integer.MIN_VALUE;

        if (nums.length != 0) {
            leaders.add(nums[nums.length - 1]);
            lastElement = nums[nums.length - 1];
        } else {
            return null;
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > lastElement) {
                leaders.add(nums[i]);
                lastElement = nums[i];
            }
        }
        Integer[] arr = leaders.toArray(Integer[]::new);
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }

        return List.of(arr);
    }

}
