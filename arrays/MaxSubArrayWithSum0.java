import java.util.Map;
import java.util.HashMap;

public class MaxSubArrayWithSum0 {
    public static int maxLen(int[]array){
        int _maxLen = 0;
        int n = array.length;
        for(int i=0;i<n;i++){
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum+=array[j];
                if (sum==0) {
                    _maxLen = Math.max(_maxLen, j-i+1);
                }
            }
        }
        return _maxLen;
    }
    public static int maxLenOptimal(int[]array){
        int _maxLen = 0;
        int n = array.length;
        int prevSum = 0;
        /*
         * @gnvvs-2003 : HashMap<prevSum,index>
         */
        Map<Integer,Integer> prevSumMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            prevSum+=array[i];
            if (prevSum==0) {
                _maxLen = i+1;
            }
            else{
                /*
                 * @gnvvs-2003 : sum(elements at index x)-sum(elements at index y) = 0 => sum(elements at index y) should be in hash map while we calculate sum(elements at index x)
                 */
                if (prevSumMap.containsKey(prevSum)) {
                    int prevSumIndex = prevSumMap.get(prevSum);
                    _maxLen = Math.max(_maxLen, i-prevSumIndex);
                }
                else{
                    prevSumMap.put(prevSum,i);
                }
            }
        }
        return _maxLen;
    }
    public static void main(String[] args) {
        int [] array = {9,-3,3,-1,6,-5};
        System.out.println(maxLen(array));   
        System.out.println(maxLenOptimal(array));   
    }
}