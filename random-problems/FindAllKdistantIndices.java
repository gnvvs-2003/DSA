import java.util.List;
import java.util.ArrayList;

public class FindAllKdistantIndices {
    public static void main(String[] args) {
        int[] array = {3, 4, 9, 1, 3, 9, 5};
        int k = 1;
        int key = 9;
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (Math.abs(i - j) <= k && array[j] == key) {
                    output.add(i);
                    break; // i satisfies condition, no need to check more j's
                }
            }
        }
        System.out.println(output); 
    }
}
