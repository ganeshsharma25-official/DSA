package ArrayMedium;

import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> numsList = new ArrayList<>();
        Set<List<Integer>> numsSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                for (int j2 = j + 1; j2 < nums.length; j2++) {
                    if (nums[i] + nums[j] + nums[j2] == 0) {

                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[j2]);
                        list.sort(new Comparator<Integer>() {
                            public int compare(Integer a, Integer b) {
                                return Integer.compare(a, b);
                            }
                        });
                        numsSet.add(list);
                    }
                }
            }
        }

        numsList.addAll(numsSet);

        return numsList;
    }

    // two pointer approach

    public static List<List<Integer>> threeSumII(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int prevLeft;
            int prevRight;

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {

                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);

                    resultList.add(temp);

                    prevLeft = nums[left];
                    prevRight = nums[right];

                    while (left < nums.length && nums[left] == prevLeft) {
                        left++;
                    }

                    while (right > 0 && nums[right] == prevRight) {
                        right--;
                    }

                } else if (nums[i] + nums[left] + nums[right] < 0) {

                    prevLeft = nums[left];
                    while (left < nums.length && nums[left] == prevLeft) {
                        left++;
                    }

                } else if (nums[i] + nums[left] + nums[right] > 0) {

                    prevRight = nums[right];
                    while (right > 0 && nums[right] == prevRight) {
                        right--;
                    }

                }

            }

        }

        return resultList;

    }

    public static void main(String[] args) {
        int[] nums = { 0, 0, 0 };

        System.out.println(threeSumII(nums).toString());
    }

}
