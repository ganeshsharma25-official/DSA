package ArrayMedium;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MajorityElement {

    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {

        Map<Integer, Integer> elementMap = new HashMap<>();

        int maxCount = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (elementMap.containsKey(nums[i])) {
                elementMap.put(nums[i], elementMap.get(nums[i]) + 1);
            } else {
                elementMap.put(nums[i], 1);
            }
        }

        int majorityKey = Integer.MIN_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for (Entry<Integer, Integer> i : elementMap.entrySet()) {
            int currentValue = i.getValue();
            if (currentValue > maxValue) {
                maxValue = currentValue;
                majorityKey = i.getKey();
            }
        }

        return majorityKey;
    }

}
