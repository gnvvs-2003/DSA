public class MaxSubArraySum {
    public static int maxSum(int[]array){   // kadane's algo
        int maxValue = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int i=0;i<array.length;i++){
            currentSum+=array[i];
            System.out.println("Added value = "+array[i]);
            if(currentSum>maxValue){
                System.out.println("The current sum = "+currentSum);
                maxValue = currentSum;
                System.out.println("current max sum = "+maxValue);
            }
            if (currentSum<0) {
                System.out.println("The current sum is now negative making the current sum to 0 again");
                System.out.println("Now sub array is empty");
                currentSum = 0;
                System.out.println("current sum is now zero");
            }
        }
        return maxValue;
    }
    public static void main(String[] args) {
        int[]array = {1,0,9,-2,1,-5,-12,5,6};
        for (int i : array) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println(maxSum(array));
    }
}