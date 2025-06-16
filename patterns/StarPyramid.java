/*

Input Format: N = 6
Result:
     *     
    ***    
   *****   
  *******  
 ********* 
***********

*/



import java.util.Scanner;

public class StarPyramid{
    public static void printPattern(int rows){
        // nested loops
        for(int i=0;i<rows;i++){
            // spaces
            for(int j=0;j<rows-i-1;j++){
                System.out.print(" ");
            }
            // noOfStarsInARow : oddNumber(rowNumber) = 2*rowNumber+1
            for(int j=0;j<2*i+1;j++){
                System.out.print("*");
            }
            // spaces
            for(int j=0;j<rows-i-1;j++){
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