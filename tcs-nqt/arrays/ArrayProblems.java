public class ArrayProblems{
    public static int smallest(int[]array){
        int smallestNumber = Integer.MAX_VALUE;
        for(int i:array){
            if(smallestNumber>i){
                smallestNumber = i;
            }
        }
        return smallestNumber;
    }
    public static int largest(int[]array){
        int largestNumber = Integer.MIN_VALUE;
        for(int i:array){
            if(largestNumber<i){
                largestNumber = i;
            }
        }
        return largestNumber;
    }
    public static void main(String[]a){
        int[] array = {1,2,1,3,1,6,4,2,-2,10,-32,1,-3};
        int smallestNumber = smallest(array);
        System.out.println("The smallest number in the array is "+smallestNumber);
        int largestNumber = largest(array);
        System.out.println("The largest number in the array is "+largestNumber);
    }
}