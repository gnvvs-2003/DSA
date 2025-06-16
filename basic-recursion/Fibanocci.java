public class Fibanocci {
    
    // Recursive method
    public static int fibonacciNumber(int number) {
        // 1st = 0, 2nd = 1, 3rd = 1, 4th = 2, 5th = 3, ...
        if (number <= 1) {
            return number;
        }
        return fibonacciNumber(number - 1) + fibonacciNumber(number - 2);
    }

    // Optimized iterative method
    public static int fibonacciNumberOptimized(int number) {
        if (number <= 1) {
            return number;
        }

        int prev = 0;
        int curr = 1;

        for (int i = 2; i <= number; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }

        return curr;
    }

    public static void main(String[] args) {
        int number = 4;
        System.out.println("Recursive: " + fibonacciNumber(number-1));          // Output: 3
        System.out.println("Optimized: " + fibonacciNumberOptimized(number-1)); // Output: 3
    }
}
