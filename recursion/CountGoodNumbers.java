public class CountGoodNumbers {

    static final int MOD = Integer.MAX_VALUE;

    // Helper to check if a digit is prime
    public static boolean isPrimeDigit(int digit) {
        return digit == 2 || digit == 3 || digit == 5 || digit == 7;
    }

    // Checks if even digits are present at even places (1-based index from right)
    public static boolean evenDigitsAtEvenPlaces(int n) {
        int position = 1;
        while (n > 0) {
            int digit = n % 10;
            if (position % 2 == 0 && digit % 2 != 0) {
                return false;
            }
            n /= 10;
            position++;
        }
        return true;
    }

    // Checks if prime digits are present at odd places (1-based index from right)
    public static boolean primeDigitsAtOddPlaces(int n) {
        int position = 1;
        while (n > 0) {
            int digit = n % 10;
            if (position % 2 != 0 && !isPrimeDigit(digit)) {
                return false;
            }
            n /= 10;
            position++;
        }
        return true;
    }

    public static int goodNumbersCount(int n) {
        int count = 0;
        int start = (int) Math.pow(10, n - 1);
        int end = (int) Math.pow(10, n);

        for (int i = start; i < end; i++) {
            if (evenDigitsAtEvenPlaces(i) && primeDigitsAtOddPlaces(i)) {
                count++;
            }
        }

        return count % MOD;
    }

    public static void main(String[] args) {
        System.out.println(goodNumbersCount(4)); // Example
    }
}
