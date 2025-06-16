/*

Input Format: N = 6
Result:   
     *
     **
     *** 
     ****
     *****
     ******  
     *****
     ****
     ***    
     **
     *

*/
import java.util.Scanner;

public class HalfDiamond{
    public static void printPattern(int rows){
        // nested loops
        for(int i=0;i<rows;i++){
            for(int j=0;j<i+1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<rows-i-1;j++){
                System.out.print("*");
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