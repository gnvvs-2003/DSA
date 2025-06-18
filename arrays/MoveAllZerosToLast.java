// Input: 1 ,0 ,2 ,3 ,0 ,4 ,0 ,1
// Output: 1 ,2 ,3 ,4 ,1 ,0 ,0 ,0

public class MoveAllZerosToLast{
    public static void moveAllZerosToLast(int[]array){
        // 1. find non-zeros and move them forward
        int index=0;
        for (int i = 0; i < array.length; i++) {
            if(array[i]!=0){
                array[index] = array[i];
                index++;
            }
        }
        while (index<array.length) {
            array[index] = 0;
            index++;
        }
    }
    public static void main(String[] args) {
        int[]array = {1,0,2,3,0,4,0,1};
        moveAllZerosToLast(array);
        for (int i : array) {
            System.out.print(i+" ");
        }
    }
}