import java.util.Arrays;

public class Merge2Arrays {
    public static void merge(int[]array1,int[]array2){
        int n1 = array1.length;
        int n2 = array2.length;
        int left = n1-1;
        int right = 0;
        // comparing the elements from right in 1st array and from left in 2nd array
        while (left>=0 && right<n2) {
            if (array1[left]>array2[right]) {
                int temp = array1[left];
                array1[left] = array2[right];
                array2[right] = temp;
                left--;
                right++;
            }
            else{
                break;
            }
        }
        Arrays.sort(array1);
        Arrays.sort(array2);
        for (int i : array1) {
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i : array2) {
            System.out.print(i+" ");
        }
    }
    public static void main(String[]a){
        int [] array1 = {1, 4, 8, 10};
        int [] array2 = {2, 3, 9};
        merge(array1,array2);
    }
}