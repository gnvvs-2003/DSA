public class selectionSort{
    public static void display(int[]array){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+",");
        }
        System.out.println();
    }
    public static void _selectionSort(int[]array){
        // select and minimum
        for(int i=0;i<array.length;i++){
            int minimumIndex = i;
            // finding minimum between array and minimum
            for(int j=i;j<array.length;j++){
                // compare and find minimum
                if(array[minimumIndex]>array[j]){
                    minimumIndex = j;
                }

            }
            // swap
            int temp = array[minimumIndex];
            array[minimumIndex] = array[i];
            array[i] = temp;
        }
        display(array);
    }
    public static void main(String[] args) {
        int[]array = {1,2,1,5,4,3};
        _selectionSort(array);
    }
}