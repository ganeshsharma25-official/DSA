package fundamentals;

public class CountOccurances {

    public int countOccurrences(int[] arr, int target) {
        // Your code goes here

        if (arr[0] == arr[arr.length - 1] && arr[0] == target) {
            return arr.length;
        }

        int lowerBound = findLowerBound(arr, target);
        int upperBound = findUpperbound(arr, target);
        System.out.println("Lower BOund-->" + lowerBound + " Upper bound--> " +
                upperBound);

        if (arr[arr.length - 1] == target) {
            return arr.length - lowerBound;
        }

        return upperBound - lowerBound;
    }

    public int findLowerBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {

            int mid = (low + high) / 2;

            if (arr[mid] >= target) {
                ans = Math.min(mid, ans);
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return (ans == Integer.MAX_VALUE) ? 0 : ans;
    }

    public int findUpperbound(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        int result = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > target) {
                result = Math.min(mid, result);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (result == Integer.MAX_VALUE) ? 0 : result;
    }

    public static void main(String[] args) {
        CountOccurances countOccurances = new CountOccurances();
        int[] arr = { 1, 2 };
        int target = 2;
        int occurrences = countOccurances.countOccurrences(arr, target);
        System.out.println("Occurrences of " + target + ": " + occurrences);
    }

}
