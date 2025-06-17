import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class HighestAndLowestFrequency{
    public static void highAndLowFrequency(int[]array){
        int n = array.length;
        int highestFrequency = 0 ;
        int highestFrequencyElement = -1;
        int lowestFrequency = n;
        int lowestFrequencyElement = -1;
        // frequency hash map
        Map<Integer,Integer> freq = new HashMap<>();
        for (int i=0;i<n;i++){
            if(freq.containsKey(array[i])){
                freq.put(array[i], freq.get(array[i])+1);
            }
            else{
                freq.put(array[i], 1);
            }
        }
        // highest and lowest freq elements
        for(Map.Entry<Integer,Integer> entry : freq.entrySet()){
            // element and frequency
            int element = entry.getKey();
            int frequency = entry.getValue();
            if (frequency<lowestFrequency){
                lowestFrequency = frequency;
                lowestFrequencyElement = element;
            }
            if (frequency>highestFrequency){
                highestFrequency = frequency;
                highestFrequencyElement = element;
            }
        }
        // display the lowest and highest frequency
        System.out.println("The minimum frequency is "+lowestFrequency+" and the element is "+lowestFrequencyElement);
        System.out.println("The maximum frequency is "+highestFrequency+" and the element is "+highestFrequencyElement);
    }
    public static void main(String[]a){
        int[]nums={1,2,1,2,3,1,4,3};
        highAndLowFrequency(nums);
    }
}