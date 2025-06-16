/*

Input Format: N = 6
Result:     
***********
 *********
  *******
   ***** 
    ***    
     * 
*/

import java.util.Scanner;

public class InvertedStarPyramid{
    public static void printPattern(int rows){
        // nested loops
        for(int i=0;i<rows;i++){
            // spaces
            for(int j=0;j<i;j++){
                System.out.print(" ");
            }
            // stars : 
            /*
                rows = 6
                row-1 : i = 0 spaces = 0 + stars = 11(2*6-1) + spaces = 0 
                row-1 : i = 1 spaces = 1 + stars = 9(2*5-1) + spaces = 1 
             
             */
            for(int j=0;j<2*(rows-i)-1;j++){
                System.out.print("*");
            }
            // spaces
            for(int j=0;j<i;j++){
                System.out.print(" ");
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