public class CountGoodNumbers {
    static final int MOD = 1_000_000_007;

    // Helper method to calculate base^exp % MOD without recursion or separate
    // function
    public static long fastPower(long base, int exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }

    public static int countGoodNumbers(int n) {
        int evenPositions = (n + 1) / 2; // digits at even indices (0-based)
        int oddPositions = n / 2; // digits at odd indices

        // For even positions: digits must be even → 0, 2, 4, 6, 8 → 5 choices
        // For odd positions: digits must be prime → 2, 3, 5, 7 → 4 choices

        long result = fastPower(5, evenPositions) * fastPower(4, oddPositions) % MOD;
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(countGoodNumbers(1)); // 5
        System.out.println(countGoodNumbers(4)); // 400
        System.out.println(countGoodNumbers(50)); // 564908303
    }
}
