public class InsertionSort{
    public static void insertionSort(int[]array){
        int n=array.length;
        for(int i=0;i<n;i++){
            int j=i;
            while (j>0 && array[j-1]>array[j]) {
                // swap
                int temp = array[j-1];
                array[j-1] = array[j];
                array[j] = temp;
                j--;
            }
        }
        for (int i : array) {
            System.out.print(i+" ");
        }
    }
    // RECURSIVE method
    public static void recursiveInsertionSort(int[]array,int i,int n){
        if (i==n) {
            return;
        }
        int j=i;
        while (j>0 && array[j-1]>array[j]) {
            // swap
            int temp = array[j-1];
            array[j-1] = array[j];
            array[j] = temp;
            j--;
        }
        recursiveInsertionSort(array, i+1, n);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,1,3,5,1,2};
        insertionSort(arr);
        int n=arr.length;
        recursiveInsertionSort(arr, 0, n);
        for (int element : arr) {
            System.out.print(element+" ");
        }
    }
}