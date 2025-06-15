/*

Input Format: N = 6
Result:
* * * * * *
* * * * * 
* * * * 
* * * 
* * 
* 

*/

import java.util.Scanner;

public class InvertedRightPyramid{
    public static void printPattern(int rows){
        // nested loops
        for(int i=rows;i>0;i--){
            // no of stars decreases as row number increases
            for(int j=i;j>0;j--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void main(String[]a){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows");
        int numberOfRows = scanner.nextInt();
        scanner.close();
        printPattern(numberOfRows);
    }
}