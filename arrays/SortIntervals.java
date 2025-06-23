import java.util.Arrays;

public class SortIntervals {
    public static void sortedIntervals(int[][]array){
        Arrays.sort(array,(a,b)->Integer.compare(a[0], b[0]));
        for (int[] is : array) {
            System.out.print("{");
            for (int is2 : is) {
                System.out.print(is2+",");
            }
            System.out.print("}   ");
        }
    }
    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {8, 10}, {15, 18},{2, 6}};
        sortedIntervals(arr);
    }
}