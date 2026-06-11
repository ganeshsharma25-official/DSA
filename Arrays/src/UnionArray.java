import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UnionArray {

    public static void main(String[] args) {

        int[] res = sortedArrayOpti(new int[] { 3, 4, 6, 7, 9, 9 }, new int[] { 1, 5, 7, 8, 8 });
        System.out.println(Arrays.toString(res));

    }

    private static int[] sortedArray(int[] arr1, int[] arr2) {

        Set<Integer> resultSet = new HashSet<>();

        for (int i = 0; i < arr1.length; i++) {
            resultSet.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            resultSet.add(arr2[i]);
        }

        Integer[] result = resultSet.toArray(new Integer[0]);

        Arrays.sort(result);

        int[] res = new int[result.length];

        for (int i = 0; i < res.length; i++) {
            res[i] = result[i];
        }
        return res;
    }

    // optimized solution
    public static int[] sortedArrayOpti(int[] nums1, int[] nums2) {

        int num1Length = nums1.length;
        int num2Length = nums2.length;
        int i = 0;
        int j = 0;
        int[] resultArray = new int[num1Length + num2Length];
        int resultArrayCounter = -1;

        while (i < num1Length && j < num2Length) {

            if (resultArrayCounter == -1) {
                if ((nums1[i] < nums2[j])) {
                    resultArray[resultArrayCounter + 1] = nums1[i];
                    i++;
                    resultArrayCounter++;
                    continue;
                }

                if (nums2[j] < nums1[i]) {
                    resultArray[resultArrayCounter + 1] = nums2[j];
                    j++;
                    resultArrayCounter++;
                    continue;
                }
            }

            if ((nums1[i] < nums2[j]) && nums1[i] != resultArray[resultArrayCounter]) {
                resultArray[resultArrayCounter + 1] = nums1[i];
                i++;
                resultArrayCounter++;
                continue;
            }

            if (nums2[j] < nums1[i] && nums2[j] != resultArray[resultArrayCounter]) {
                resultArray[resultArrayCounter + 1] = nums2[j];
                j++;
                resultArrayCounter++;
                continue;
            }

            if (nums1[i] == nums2[j] && resultArray[resultArrayCounter] != nums1[i]) {

                resultArray[resultArrayCounter + 1] = nums1[i];
                i++;
                j++;
                resultArrayCounter++;
                continue;

            }

            i++;
            j++;

        }

        return resultArray;
    }

}
