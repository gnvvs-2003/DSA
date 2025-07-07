public class MinEatingRate {
    public static int findMax(int[] array) {
        int maximum = Integer.MIN_VALUE;
        for (int i : array) {
            maximum = Math.max(maximum, i);
        }
        return maximum;
    }

    public static int calculateTotalHours(int[] array, int eatingRate) {
        int totalHours = 0;
        int n = array.length;
        for (int i = 0; i < n; i++) {
            totalHours += Math.ceil((double) (array[i]) / (double) (eatingRate));
        }
        return totalHours;
    }

    public static int minEatingRate(int n, int[] array, int hours) {
        // max eating rate
        int maximumEatingRate = findMax(array);
        for (int index = 1; index <= maximumEatingRate; index++) {
            // index indicate the current eating rate
            int requiredTimeForCurrentEatingRate = calculateTotalHours(array, index);
            if (requiredTimeForCurrentEatingRate <= hours) {
                return index;
            }
        }
        return maximumEatingRate;
    }

    /*
     * @gnvvs-2003 : using binary search approach since the current eating rate is
     * sorted and linearly searched
     */

    public static int minEatingRateUsingBinarySearch(int n, int[] array, int hours) {
        int low = 1; // minimum eating rate
        int high = findMax(array);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // now mid acts as the current eating rate
            int requiredTimeForCurrentEatingRate = calculateTotalHours(array, mid);
            if (requiredTimeForCurrentEatingRate <= hours) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int n = 4;
        int[] piles = { 7, 15, 6, 3 };
        int hours = 8;
        System.out.println(minEatingRate(n, piles, hours));
        System.out.println(minEatingRateUsingBinarySearch(n, piles, hours));
    }
}