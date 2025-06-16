
/*
Example 1:
Input:N = 153
Output:True
Explanation: 13+53+33 = 1 + 125 + 27 = 153

Example 2:
Input:N = 371                
Output: True
Explanation: 33+53+13 = 27 + 343 + 1 = 371
*/
import java.util.*;

public class Armstrong {
    public static void main(String[] a) {
        int num = 31;
        int originalNum = num;
        int sum = 0;
        int numOfDigits = (int) (Math.log10(num) + 1);
        if (num < 0) {
            System.out.println(false);
        } else {
            if (num == 0) {
                System.out.println(true);
            } else {
                while (numOfDigits > 0) {
                    int digit = num % 10;
                    num = num / 10;
                    sum += Math.pow(digit, 3);
                    numOfDigits--;
                }
                if (originalNum == sum) {
                    System.out.println(true);
                } else {
                    System.out.println(false);
                }
            }
        }

    }
}