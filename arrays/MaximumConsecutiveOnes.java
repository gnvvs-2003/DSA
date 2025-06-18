public class MaximumConsecutiveOnes {
    public static int max(int x, int y) {
        return (x > y) ? x : y;
    }
    public static int maxConsecutiveOnes(int[] array) {
        int n = array.length;
        int[] zeros = new int[n];
        int zeroCount = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] == 0) {
                zeros[zeroCount++] = i;
            }
        }
        if (zeroCount < 2) {
            return 0;
        }
        int largestDifference = 0;
        for (int i = 0; i < zeroCount - 1; i++) {
            int diff = zeros[i + 1] - zeros[i] - 1;
            largestDifference = max(largestDifference, diff);
        }
        return largestDifference;
    }
    public static void main(String[] args) {
        int[] array1 = {1, 1, 0, 1, 1, 1, 0, 1, 1};
        int[] array2 = {1, 1, 1, 1}; // no zeros
        int[] array3 = {0, 1, 1, 0, 1, 1, 1, 0, 1}; // multiple groups
        System.out.println(maxConsecutiveOnes(array1)); // Output: 3
        System.out.println(maxConsecutiveOnes(array2)); // Output: 0
        System.out.println(maxConsecutiveOnes(array3)); // Output: 3
    }
}