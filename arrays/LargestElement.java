public class LargestElement{
    // Brute-force 
    public static int largestElementOfArray(int[]array){
        int maxValue = Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++){
            if(maxValue<array[i]){
                maxValue = array[i];
            }
        }
        return maxValue;
    }
    public static void main(String[]a){
        int[]array = {1,2,1,540,-1,21,82};
        int largestElement = largestElementOfArray(array);
        System.out.println(largestElement);
    }
}