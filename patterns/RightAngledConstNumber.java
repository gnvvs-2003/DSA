/*

Input Format: N = 4
Result:
1
2 2
3 3 3
4 4 4 4

*/

import java.util.Scanner;

public class RightAngledConstNumber{
    public static void printPattern(int rows){
        // nested loops
        for(int i=0;i<=rows;i++){
            // value increases as row number increases but only const value for an entire row
            for(int j=0;j<i;j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[]a){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows");
        int numOfRows = scanner.nextInt();
        scanner.close();
        printPattern(numOfRows);
    }
}