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
            // i indicate the current eating rate
            int requiredTimeForCurrentEatingRate = calculateTotalHours(array, index);
            if (requiredTimeForCurrentEatingRate <= hours) {
                return index;
            }
        }
        return maximumEatingRate;
    }

    public static void main(String[] args) {
        int n = 4;
        int[] piles = { 7, 15, 6, 3 };
        int hours = 8;
        System.out.println(minEatingRate(n, piles, hours));
    }
}