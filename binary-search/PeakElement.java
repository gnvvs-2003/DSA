public class PeakElement {
    /*
     * @gnvvs-2003 : using brute force Timecomplexity = O(n)
     */
    public static int peak1(int[] array) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[i + 1] && array[i] > array[i - 1]) {
                index = i;
                break;
            }
        }
        return index;
    }

    /*
     * @gnvvs-2003 : using binary search time complexity = O(logn)
     */

    public static int peakOptimized(int[] array) {
        int n = array.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            boolean leftSide = (mid == 0) || (array[mid] >= array[mid - 1]);
            boolean rightSide = (mid == n - 1) || (array[mid] >= array[mid + 1]);

            if (leftSide && rightSide) {
                return mid; // Peak found
            } else if (mid > 0 && array[mid] < array[mid - 1]) {
                high = mid - 1; // Move to left half
            } else {
                low = mid + 1; // Move to right half
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 1, 3, 5, 6, 4 };
        int peakElementUsingBruteForce = peak1(array);
        System.out.println("The peak element was found at index : " + peakElementUsingBruteForce
                + " and the method used is linear search or brute force");
        int peakElementUsingOptimized = peakOptimized(array);
        System.out.println("The peak element was found at index : " + peakElementUsingOptimized
                + " and the method used is binary search and optimized");
    }
}