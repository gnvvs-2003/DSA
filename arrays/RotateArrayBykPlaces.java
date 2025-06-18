public class RotateArrayBykPlaces{
    // rotate
    public static void rotate(int[]array,int k){
        int n = array.length;
        k=k%n;
        reverse(array, 0, n-1);
        reverse(array, 0, k-1);
        reverse(array, k, n-1);
    }
    public static void reverse(int[]arr,int start,int end){
        // swap until start and end
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[]a){
        int[]array = {1,2,3,4,5};
        rotate(array, 3);
        for (int i : array) {
            System.out.println(i+" ");
        }
    }
}