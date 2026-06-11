package ArrayEasy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionArray {

    public static void main(String[] args) {
        int[] num1 = { 1, 2, 2, 3, 5 };
        int[] num2 = { 1, 2, 7 };

        int[] res = intersectionArray(num1, num2);
        System.out.println(Arrays.toString(res));

    }

    public static int[] intersectionArray(int[] nums1, int[] nums2) {

        List<Integer> resList = new ArrayList<>();
        int i = 0;
        int j = 0;

        // for (int i = 0, j = 0; i < nums1.length; i++) {
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                resList.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            }
        }

        int[] resultArr = new int[resList.size()];
        for (int k = 0; k < resList.size(); k++) {
            resultArr[k] = resList.get(k);
        }

        return resultArr;

    }
}
