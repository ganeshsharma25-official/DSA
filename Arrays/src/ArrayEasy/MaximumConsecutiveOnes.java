package ArrayEasy;

public class MaximumConsecutiveOnes {

    public static void main(String[] args) {

    }

    public static int findMaxConsecutiveOnes(int[] num) {

        int counter = 0;
        int maxCount = 0;

        for (int i = 0; i < num.length; i++) {
            if (num[i] == 1) {
                counter++;
                if (counter > maxCount) {
                    maxCount = counter;
                }
            }
            if (num[i] == 0) {
                counter = 0;
            }
        }

        return maxCount;
    }

}
