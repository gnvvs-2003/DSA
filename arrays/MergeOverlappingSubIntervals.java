import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class MergeOverlappingSubIntervals {
    // sort according to first interval
    public static List<List<Integer>> merge(int[][]array){
        Arrays.sort(array, (a, b) -> Integer.compare(a[0], b[0]));
        List<List<Integer>> merged = new ArrayList<>();
        for(int[] interval:array){
            if (merged.isEmpty() || interval[0]>merged.get(merged.size()-1).get(1)) {
                merged.add(new ArrayList<>(Arrays.asList(interval[0],interval[1])));
            }
            // if overlap exists
            else{
                int lastEnd = merged.get(merged.size()-1).get(1);
                merged.get(merged.size()-1).set(1,Math.max(lastEnd,interval[1]));
            }
        }
        return merged;
    }
    // using arrays
    public static int[][] merge2(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[][] result = new int[intervals.length][2];
        int index = 0;
        for (int[] interval : intervals) {
            if (index == 0 || interval[0] > result[index - 1][1]) {
                result[index][0] = interval[0];
                result[index][1] = interval[1];
                index++;
            } else {
                result[index - 1][1] = Math.max(result[index - 1][1], interval[1]);
            }
        }
        return Arrays.copyOf(result, index);
    }

    public static void main(String[] args) {
        int[][] arr = {
            {1, 3},     // index = 0
            {8, 10},    // index = 1
            {2, 6},     // index = 2
            {15, 18}    // index = 3
        };
        List<List<Integer>> result = merge(arr);

        System.out.println("The merged intervals are:");
        for (List<Integer> interval : result) {
            System.out.println(interval);
        }

        int[][] merged = merge2(arr);

        for (int[] interval : merged) {
            System.out.println(Arrays.toString(interval));
        }
    }
}