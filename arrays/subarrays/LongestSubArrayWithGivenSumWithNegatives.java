import java.util.Map;
import java.util.HashMap;
public class LongestSubArrayWithGivenSumWithNegatives {
        // more - optimal using hashmap cannot use 2 pointer approach for negative values
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
    public static void main(String[] args) {
        int[]array = {-1,1,1};
        int k =1;
        System.out.println(longestSubArrayWithGivenSumUsingHashMap(array,k));
    }
}