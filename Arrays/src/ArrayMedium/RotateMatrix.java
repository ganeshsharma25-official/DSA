package ArrayMedium;

public class RotateMatrix {

    public static void main(String[] args) {

    }

    public static void rotateMatrix(int[][] matrix) {
        // transpose matrix

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 1; j < matrix.length; j++) {
                swap(matrix[i][j], matrix[j][i]);
            }
        }

        // reverse each row of the matrix

    }

    private static void swap(int i, int j) {
        int temp = i;
        i = j;
        j = temp;
    }

}
