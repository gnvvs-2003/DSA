import java.util.ArrayList;

public class ReverseAnArray{
    public static void reverseAnArray(int[]array){
        ArrayList<Integer>reversedArray = new ArrayList<Integer>();
        int index = 0;
        while(index<array.length){
            reversedArray.add(array[array.length-index-1]);
            index++;
        }
        System.out.println(reversedArray);
    }
    public static void main(String[] args) {
        int[]arr = {1,2,3,4,5};
        reverseAnArray(arr);
    }
}