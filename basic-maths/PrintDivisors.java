/*
Input:N = 36
Output:[1, 2, 3, 4, 6, 9, 12, 18, 36]
*/

import java.util.ArrayList;

public class PrintDivisors{
    public static void main(String[]a){
        ArrayList<Integer> divisors = new ArrayList<Integer>();
        int currentDivisor = 1;
        int n = 36;
        while (currentDivisor<n){
            if(n%currentDivisor==0){
                divisors.add(currentDivisor);
            }
            currentDivisor++;
        }
        System.out.println(divisors);
    }
}