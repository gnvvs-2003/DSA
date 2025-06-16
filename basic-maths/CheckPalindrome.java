public class CheckPalindrome{
    public static int reverse(int x) {
        int reversed = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            // check for overflow/underflow
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7))
                return 0;
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8))
                return 0;

            reversed = reversed * 10 + digit;
        }
        return reversed;
    }
    public static void main(String[] args) {
        int value = 121;
        if(value<0){
            System.out.println(false);
        }
        else{
            System.out.println(value == reverse(value));
        }
    }
}