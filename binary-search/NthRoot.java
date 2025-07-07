public class NthRoot {
    public static int midValuate(int mid, int n, int value) {
        long ans = 1;
        for (int i = 0; i < n; i++) {
            ans *= mid;
            if (ans > value) {
                return 2; // too big
            }
        }
        if (ans == value) {
            return 1; // exact match
        }
        return 0; // too small
    }

    public static int nthRoot(int n, int value) {
        int low = 1;
        int high = value;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midValue = midValuate(mid, n, value);

            if (midValue == 1) {
                return mid; // exact root found
            } else if (midValue == 2) {
                high = mid - 1; // mid^n > value
            } else {
                low = mid + 1; // mid^n < value
            }
        }

        return -1; // not a perfect n-th root
    }

    public static void main(String[] args) {
        int value = 27;
        int n = 3;
        int root = nthRoot(n, value);
        if (root != -1) {
            System.out.println(n + "th root of " + value + " is: " + root);
        } else {
            System.out.println(value + " is not a perfect " + n + "th power.");
        }
    }
}
