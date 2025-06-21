import java.util.HashMap;
import java.util.Map;

public class SubarraySumK {
    public static int countSubArrayWithSumK(int[]array,int target){
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = i; j < array.length; j++) {
                sum+=array[j];
                if (sum==target) {
                    count++;
                }
            }
        }
        return count;
    }
    public static int countSubArrayWithSumKOptimal(int[] array, int target) {
        int count = 0;
        int prefixSum = 0;
        int n = array.length;
        Map<Integer, Integer> mapping = new HashMap<>();
        mapping.put(0, 1);
        for (int i = 0; i < n; i++) {
            prefixSum += array[i];
            int remaining = prefixSum - target;
            if (mapping.containsKey(remaining)) {
                count += mapping.get(remaining);
            } else {
                count += 0;
            }
            if (mapping.containsKey(prefixSum)) {
                mapping.put(prefixSum, mapping.get(prefixSum) + 1);
            } else {
                mapping.put(prefixSum, 1);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[]array = {3, 1, 2, 4};
        int target = 6;
        System.out.println(countSubArrayWithSumK(array,target));
        System.out.println(countSubArrayWithSumKOptimal(array,target));
    }
}