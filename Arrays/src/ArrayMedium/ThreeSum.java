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

    public static void main(String[] args) {
        int[] nums = { -2, -1, 0, 1, 2 };

        System.out.println(threeSum(nums).toString());
    }

}
