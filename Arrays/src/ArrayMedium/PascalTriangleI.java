package ArrayMedium;

public class PascalTriangleI {

    public static void main(String[] args) {
        System.out.println(pascalTringleOpti(5, 3));
    }

    public static int pascalTriangleI(int r, int c) {

        if (c < 1 || r < 1) {
            return 0;
        }
        if (r == c) {
            return 1;
        }

        if (r == 3 && c == 2) {
            return 2;
        }

        int result = pascalTriangleI(r - 1, c - 1) + pascalTriangleI(r - 1, c);

        return result;

    }

    public static int pascalTringleOpti(int r, int c) {

        int n = r - 1;
        int k = c - 1;

        int result = 1;
        for (int i = 0; i < k; i++) {
            result = result * (n - i);
            result = result / (i + 1);
        }
        return result;

    }

    public double calculateFactorial(int num) {

        double factorial = 1;

        for (int i = 1; i <= num; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }

}
