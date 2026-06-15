package ArrayMedium;

import java.util.Arrays;

public class RotateMatrix {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        // System.out.println(Arrays.toString(reverseArray(arr)));
        rotateMatrix(new int[][] { { 0, 1, 1, 2 },
                { 2, 0, 3, 1 },
                { 4, 5, 0, 5 },
                { 5, 6, 7, 0 } }); // 1,2. 2,1

    }

    public static void rotateMatrix(int[][] matrix) {
        // transpose matrix

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 1 + i; j < matrix.length; j++) {

                if ((i == 1 && j == 2) || (i == 2 && j == 1)) {

                    System.out.println("Hi there");

                }
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        System.out.println("Transpose Matrix");
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();

        }
        System.out.println();

        // reverse each row of the matrix
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix.length / 2; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;

            }

        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();

        }

    }

    // private static void swap(int i, int j) {
    // int temp = i;
    // i = j;
    // j = temp;
    // }

    public static int[] reverseArray(int[] arr) {

        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        // System.out.println(Arrays.toString(arr));
        return arr;
    }

}
