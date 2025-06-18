import java.util.*;
public class LinearSearch{
    public static int linearSearch(int[]array,int value){
        int index = -1;
        while (index<array.length) {
            index++;
            if(array[index]==value){
                break;
            }
        }
        if (index!=-1) {
            return index;
        }
        else{
            throw new IndexOutOfBoundsException();
        }
    }
    public static void main(String[] args) {
        int[]arr = {1,2,11,3,5,2};
        System.out.println(linearSearch(arr,5));
    }
}