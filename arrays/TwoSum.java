import java.util.Map;
import java.util.HashMap;
public class TwoSum {
    public static int[] indicesMatrix(int[]array,int target){
        int n = array.length;
        // find all the sum of 2 elements and return their sum == target
        for (int i = 0; i < n; i++) {
            int sum = array[i];
            for (int j = i+1; j < n; j++) {
                sum+=array[j];
                if(sum==target){
                    return new int[]{i, j}; // return immediately
                }
            }
        }
        return new int[]{-1, -1}; // return immediately
    }
    // more optimal using HashMap
    public static int[] indicesMatrixOptimal(int[]array,int target){
        int n = array.length;
        Map<Integer,Integer> mapping = new HashMap<>();
        for (int i=0;i<n;i++) {
            int remaining = target-array[i];
            if (mapping.containsKey(remaining)) {
                return new int[]{mapping.get(remaining),i};
            }else{
                mapping.put(array[i], i);
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[]a){
        int[]nums = {3,2,4};
        int target = 6;
        for (int i : indicesMatrix(nums, target)) {
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i : indicesMatrixOptimal(nums, target)) {
            System.out.print(i+" ");
        }

    }
}