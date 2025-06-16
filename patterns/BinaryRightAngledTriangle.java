/*

Input Format: N = 6
Result:   
1
01
101
0101
10101
010101

*/

import java.util.Scanner;

public class BinaryRightAngledTriangle{
    public static void printPattern(int rows){
        // nested loops
        for(int i=0;i<=rows;i++){
            for(int j=0;j<i;j++){
                System.out.print((j+i)%2);
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