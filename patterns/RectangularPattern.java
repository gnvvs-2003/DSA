/*

The Rectangular pattern

Input: N = 6

Output:
* * * * * *
* * * * * *
* * * * * *
* * * * * *
* * * * * *
* * * * * *

*/

import java.util.Scanner;
public class RectangularPattern{
    public static void printRectangularPattern(int rows){
        // nested loops 
        for(int i=0;i<rows;i++){
            // no of rows  = no of cols
            for(int j=0;j<rows;j++){
                // System.out.print("*"); // IMPORTANT : not println("*")
                // adding some gaps
                System.out.print("* "); // IMPORTANT : not println("*")
            }
            // take a new line
            System.out.println();
        }
    }
    public static void main(String[]a){
        // scanner class
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows");
        int numOfRows = scanner.nextInt();
        scanner.close();
        printRectangularPattern(numOfRows);
    }
}