/*

Input Format: N = 6
Result:
* 
* * 
* * *
* * * *
* * * * *
* * * * * *

*/

import java.util.Scanner;
public class RightAngledTriangle{
    public static void printPattern(int rows){
        // nested loops
        for(int i=0;i<rows;i++){
            // no of stars increases as row number increases
            for(int j=0;j<i;j++){
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