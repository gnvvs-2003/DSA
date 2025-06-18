import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithGivenSum {
    // brute-force
    public static int longestSubArrayWithGivenSum(int[]array,int k){
        int n = array.length;
        int maxSize = 0;
        for(int i=0;i<n;i++){
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum+=array[j];
                if (sum==k) {
                    maxSize= Math.max(maxSize, j-i+1);
                }
            }
        }
        return maxSize;
    }
    // more - optimal using hashmap
    public static int longestSubArrayWithGivenSumUsingHashMap(int[]array,int k){
        int n = array.length;
        // map
        Map<Integer,Integer> preSumMap = new HashMap<>();
        int currentSum = 0;
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            currentSum+=array[i];
            if(currentSum==k){
                maxLength = Math.max(maxLength,i+1);
            }
            int remainingSum = currentSum-k;
            if(preSumMap.containsKey(remainingSum)){
                int len = i-preSumMap.get(remainingSum);
                maxLength = Math.max(maxLength,len);
            }
            if(!preSumMap.containsKey(currentSum)){
                preSumMap.put(currentSum, i);
            }
        }
        return maxLength;
    }
    // optimal approach using 2 pointers
    public static int longestSubArrayWithGivenSumOptimal(int[] array, int k) {
        int n = array.length;
        int left = 0, right = 0;
        int sum = 0;
        int maxLength = 0;
        while (right < n) {
            sum += array[right];
            while (left <= right && sum > k) {
                sum -= array[left];
                left++;
            }
            if (sum == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[]array = {1,-1,2,1,1,4,2};
        int k = 3;
        System.out.println(longestSubArrayWithGivenSum(array,k));
        System.out.println(longestSubArrayWithGivenSumUsingHashMap(array,k));
        System.out.println(longestSubArrayWithGivenSumOptimal(array,k));
    }    
}