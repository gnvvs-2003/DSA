import java.util.HashMap;
import java.util.Map;

public class FreqOfEachElement {
    // Static method with proper return type and generics
    public static void display(HashMap<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 1, 2, 5, 3, 4, 6};
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        display(freq);
    }
}
