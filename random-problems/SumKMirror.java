public class SumKMirror {

    // Check if an integer is a palindrome in decimal
    public static boolean isPalindrome(int num) {
        int original = num;
        int reversed = 0;
        while (num > 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return original == reversed;
    }

    // Convert integer to a given base and return as string
    public static String convertToBase(int number, int base) {
        if (number == 0) return "0";

        StringBuilder result = new StringBuilder();

        while (number > 0) {
            int digit = number % base;
            char c = (char) ((digit < 10) ? ('0' + digit) : ('A' + (digit - 10)));
            result.append(c);
            number /= base;
        }

        return result.reverse().toString();
    }

    // Find the sum of first n numbers that are palindromes in both decimal and given base
    public static int numbersSum(int n, int base) {
        int sum = 0;
        int count = 0;
        int i = 1;

        while (count < n) {
            if (isPalindrome(i) && isPalindromeInBase(i, base)) {
                sum += i;
                count++;
            }
            i++;
        }

        return sum;
    }

    // Check if a number is a palindrome in a given base
    public static boolean isPalindromeInBase(int number, int base) {
        String baseStr = convertToBase(number, base);
        int left = 0, right = baseStr.length() - 1;
        while (left < right) {
            if (baseStr.charAt(left) != baseStr.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        int base = 2;
        int n = 5;
        System.out.println("Sum of first " + n + " numbers that are palindromes in both base 10 and base " + base + ":");
        System.out.println(numbersSum(n, base));
    }
}
