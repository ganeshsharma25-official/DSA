package ArrayHard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.crypto.dsig.keyinfo.KeyValue;

/*
Given an integer array nums of size n. Return all elements which appear more than n/3 times in the array. The output can be returned in any order.
Example 1
Input: nums = [1, 2, 1, 1, 3, 2]
Output: [1]
Explanation:
Here, n / 3 = 6 / 3 = 2.
Therefore the elements appearing 3 or more times is : [1]

Example 2
Input: nums = [1, 2, 1, 1, 3, 2, 2]
Output: [1, 2]
Explanation:
Here, n / 3 = 7 / 3 = 2.
Therefore the elements appearing 3 or more times is : [1, 2]
*/
public class MajorityElementII {

    public List<Integer> majorityElementTwo(int[] nums) {

        List<Integer> result = new ArrayList<>();

        Map<Integer, Integer> numsMap = new HashMap<>();

        // get n/3 count

        int majElemCount = (int) Math.floor(nums.length / 3) + 1;

        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], numsMap.getOrDefault(nums[i], 0) + 1);

            if (numsMap.get(nums[i]) > majElemCount) {
                result.add(nums[i]);

            }
            if (result.size() == 2) {
                return result;
            }

        }
        return result;

    }

    // optimal solution
    // we will use same logic used for majority element

    public List<Integer> majorityElementTwoII(int[] nums) {

        List<Integer> result = new ArrayList<>();

        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < nums.length; i++) {

            if (count1 == 0 && nums[i] != ele2) {
                ele1 = nums[i];
                count1++;
            } else if (count2 == 0 && nums[i] != ele1) {
                ele2 = nums[i];
                count2++;
            } else if (nums[i] == ele1) {
                count1++;
            } else if (nums[i] == ele2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == ele1) {
                count1++;
            }

            if (nums[i] == ele2) {
                count2++;
            }
        }

        int minCount = nums.length / 3;

        if (count1 > minCount) {
            result.add(ele1);
        }

        if (count2 > minCount && ele2 != ele1) {
            result.add(ele2);
        }

        return result;

    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 1, 3, 2 };
        int[] nums2 = { 5, 5 };
        MajorityElementII obj = new MajorityElementII();

        System.out.println(obj.majorityElementTwoII(nums2).toString());
    }
}
