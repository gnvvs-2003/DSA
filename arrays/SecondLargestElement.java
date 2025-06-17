public class SecondLargestElement{
    public static int largestElementOfArray(int[]array){
        int maxValue = Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++){
            if(maxValue<array[i]){
                maxValue = array[i];
            }
        }
        return maxValue;
    }
    public static int secondLargestNumberInAnArray(int[]array){
        // find the largest number and compare for second largest
        int largest = largestElementOfArray(array);
        int secondLargestNumber = Integer.MIN_VALUE;
        int n = array.length;
        int i=0;
        while (i<n) {
            if(largest>array[i] && secondLargestNumber<array[i]){
                secondLargestNumber = array[i];
            }
            i++;
        }
        return secondLargestNumber;
    }
    public static void main(String[] args) {
        int[]array = {1,2,1,540,-1,21,82};
        int secondLargestNumber = secondLargestNumberInAnArray(array);
        System.out.println(secondLargestNumber);
    }
}