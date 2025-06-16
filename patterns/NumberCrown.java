/*


Input Format: N = 3
Result: 
1    1
12  21
123321

*/
import java.util.Scanner;

public class NumberCrown{
    public static void printPattern(int rows){
        // nested loops
        // numbers
        for(int i=0;i<rows;i++){
            // value increases as row number increases
            for(int j=0;j<=i;j++){
                System.out.print(j+1);
            }
            for(int j=0;j<2*(rows-i-1);j++){
                System.out.print(" ");
            }
            for(int j=i;j>=0;j--){
                System.out.print(j+1);
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