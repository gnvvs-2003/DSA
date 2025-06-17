public class RemoveDuplicateElementsFromSortedArray{
    public static int removeDuplicateElementsFromSortedArray(int[]arr){
        if(arr.length==0) return 0;
        int i=0;
        for (int j = 1; j < arr.length; j++) {
            if(arr[i]!=arr[j]){
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1; // new length
    }
    public static void main(String[] args) {
        int[]array = {1,1,1,2,3,4,4,5};
        int newLength = removeDuplicateElementsFromSortedArray(array);
        for (int i = 0; i < array.length; i++) {
            if(i<newLength){
                System.out.print(array[i]+" ");
            }
            else{
                System.out.print("_ ");
            }
        }

    }
}