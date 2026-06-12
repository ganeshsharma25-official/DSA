package ArrayMedium;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    public static void main(String[] args) {

        int[][] mat = {
                { 1, 2, 3, 4 }, { 5, 6, 7, 8 }
        };
        List<Integer> ans = spiralOrder(mat);

        System.out.print("Elements in spiral order are: ");
        for (int i = 0; i < ans.size(); ++i) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();

    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        List<Integer> arrList = new ArrayList<>();
        while (left <= right && top <= bottom) {

            // left to right
            for (int i = left; i <= right; i++) {
                arrList.add(matrix[top][i]);
            }

            top++;
            // top to bottom
            for (int i = top; i <= bottom; i++) {
                arrList.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom) {
                // right to left //bottom
                for (int i = right; i >= left; i--) {
                    arrList.add(matrix[bottom][i]);
                }
            }
            bottom--;
            if (left <= right) {
                // from bottom to top
                for (int i = bottom; i >= top; i--) {
                    arrList.add(matrix[i][left]);
                }
            }
            left++;
        }
        return arrList;
    }

}
