package onAnswers;

public class NthRoot {

    public static int nthRoot(int N, int M) {

        int low = 0;
        int high = M;

        while (low <= high) {

            int mid = (low + high) / 2;
            long check = 1;
            for (int i = 0; i < N; i++) {
                check = check * mid;
            }

            if (check == M) {
                return mid;
            }

            if (check > M) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(nthRoot(7, 128));
    }
}
