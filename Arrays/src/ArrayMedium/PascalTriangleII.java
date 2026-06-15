package ArrayMedium;

import java.util.Arrays;

public class PascalTriangleII {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(pascalTriangleIIOpti(4)));
    }

    public static int[] pascalTriangleII(int r) {

        int[] resultArr = new int[r];

        for (int i = 0; i < r; i++) {
            resultArr[i] = pascalTriangle(r, i + 1);
        }
        return resultArr;
    }

    public static int pascalTriangle(int r, int c) {

        int n = r - 1;
        int x = c - 1;
        int result = 1;
        for (int i = 0; i < x; i++) {

            result = result * (n - i);
            result = result / (i + 1);

        }
        return result;
    }

    public static int[] pascalTriangleIIOpti(int r) {

        int[] resultArr = new int[r];

        int result = 1;

        resultArr[0] = result;

        for (int i = 1; i < r; i++) {

            result = (result * (r - i)) / i;
            resultArr[i] = result;

        }
        return resultArr;

    }

}
