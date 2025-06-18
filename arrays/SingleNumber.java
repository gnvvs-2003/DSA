import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public static int singleNumber(int[]array){
        int key = -1;
        Map<Integer,Integer> freq = new HashMap<>();
        for (int i : array) {
            if(freq.containsKey(i)){
                freq.put(i, freq.get(i)+1);
            }
            else{
                freq.put(i, 1);
            }
        }
        for(Map.Entry<Integer,Integer> entry:freq.entrySet()){
            if(entry.getValue()==1){
                key = entry.getKey();
            }
        }
        return key;
    }
    public static void main(String[] args) {
        int[]array = {1,2,1,2,3,1,2,1,2};
        System.out.println(singleNumber(array));
    }    
}