import java.util.Arrays;

public class NextPermutation {
    public static void nextPermutation(int[]array){
        int n = array.length;
        int index = n-2;
        while(index>0 && array[index]>=array[index+1]){
            index--;
        }
        if(index>=0){
            int j = n-1;
            while (array[j]<=array[index]) {
                j--;
            }
            swap(array,index,j);
        }

        /**
         * @gnvvs-2003 : sort the part after the index : but finding pivot means it was sorted till the index so just reversing is ok 
         */

        reverse(array,index+1,n-1);
    }
    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void reverse(int[]array,int startIndex,int end){
        while (startIndex<end) {
            swap(array, startIndex++, end--);
        }
    }
    public static void main(String[]a){
        int[]array = {2, 1, 5, 4, 3, 0, 0};
        nextPermutation(array);
        for (int i : array) {
            System.out.print(i+" ");
        }
    }
}