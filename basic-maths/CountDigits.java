// Input:N = 7789                
// Output: 4

import java.util.Scanner;
import java.util.*;

public class CountDigits{
    public static int numOfDigits(int number){
        // using logarithms log10(number) decimal value = num of digits(number)
        return (int)(Math.log10(number)+1);
    }
    public static void main(String[]a){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter input value");
        int number = scanner.nextInt();
        scanner.close();
        System.out.println("The number of digits in the number "+number+" is : "+numOfDigits(number));
    }
}
