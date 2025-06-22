import java.util.ArrayList;
import java.util.List;
public class PascalTriangle{
    public static List<Integer> generateRow(int rowNumber){
        long ans = 1;
        List<Integer> pascalTriangleRow = new ArrayList<>();
        pascalTriangleRow.add((int)ans);
        for(int colNumber = 1;colNumber<rowNumber;colNumber++){
            ans = ans*(rowNumber-colNumber);
            ans = ans/colNumber;
            pascalTriangleRow.add((int)ans);
        }
        return pascalTriangleRow;
    }
    public static List<List<Integer>> generatePascal(int n){
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        for(int row = 1;row<=n;row++){
            pascalTriangle.add(generateRow(row));
        }
        return pascalTriangle;
    }
    public static void main(String[] args) {
        int numberOfRows = 4;
        for (List<Integer> it : generatePascal(numberOfRows)) {
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }

    }
}