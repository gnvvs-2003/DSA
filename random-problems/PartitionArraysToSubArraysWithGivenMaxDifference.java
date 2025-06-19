import java.util.Arrays;

public class PartitionArraysToSubArraysWithGivenMaxDifference {
    public static int minSubArrays(int[]array,int k){
        int n = array.length;
        // step-1 : sort the array
        Arrays.sort(array);
        // now find the subarrays with max diff =k
        int count = 0;
        int index = 0;
        while(index<n){
            int start = array[index];
            count++;
            index++;
            while (index<n && array[index]-start<=k){
                index++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[]array = {2,2,4,5};
        int k = 0;
        System.out.println(minSubArrays(array, k));
    }
}