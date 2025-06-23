import java.util.Map;
import java.util.HashMap;

public class CountSubarraysWithXOR {
    public static int countXOR(int[]array,int k){
        int count = 0;
        int xor = 0;
        Map<Integer,Integer> xorMapping = new HashMap<>();
        xorMapping.put(0, 1);
        for (int i : array) {
            xor^=i;
            int required = xor^k;
            if (xorMapping.containsKey(required)) {
                count+=xorMapping.get(required);
            }
            if(xorMapping.containsKey(xor)){
                xorMapping.put(xor, xorMapping.get(xor)+1);
            }
            else{
                xorMapping.put(xor,1);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[]array = {4,2,2,6,4};
        int k = 6;
        System.out.println(countXOR(array, k));
    }
}