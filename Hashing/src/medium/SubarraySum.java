package medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(subarraySum(nums, 3));
    }

    public static int subarraySum(int[] nums, int k) {

        int count = 0;
        int preFix = 0;

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            preFix = preFix + nums[i];

            int remove = preFix - k;

            count = count + map.getOrDefault(remove, 0);

            map.put(preFix, map.getOrDefault(preFix, 0) + 1);

        }

        return count;
    }

}
