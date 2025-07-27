public class AtoiFinal {
    public int myAtoiFinal(String s) {
        if (s == null || s.isEmpty()) return 0;

        int i = 0;
        int n = s.length();
        // Step 1: Skip leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        if (i == n) return 0;

        // Step 2: Handle sign
        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Step 3: Parse digits and build the number
        long result = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');

            // Step 4: Check for overflow
            if (sign == 1 && result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && -result < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }

        return (int) result * sign;
    }

    // Testing
    public static void main(String[] args) {
        AtoiFinal sol = new AtoiFinal();

        System.out.println(sol.myAtoiFinal("   -42"));             // -42
        System.out.println(sol.myAtoiFinal("4193 with words"));    // 4193
        System.out.println(sol.myAtoiFinal("words and 987"));      // 0
        System.out.println(sol.myAtoiFinal("-91283472332"));       // -2147483648 (clamped)
        System.out.println(sol.myAtoiFinal("21474836460"));        // 2147483647 (clamped)
        System.out.println(sol.myAtoiFinal("+000081"));            // 81
        System.out.println(sol.myAtoiFinal("+-12"));               // 0 (invalid)
    }
}
