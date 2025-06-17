public class CheckSortedWithRotation{
    public static boolean checkSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false; // not sorted
            }
        }
        return true; // sorted
    }
    public static void rotateLeft(int[]array,int n){
        int firstElement = array[0];
        for(int i=1;i<n;i++){
            array[i-1] = array[i];
        }
        array[n-1] = firstElement;
    }
    public static void main(String[] args) {
        int[]array = {4,5,1,3};
        int n = array.length;
        boolean check = false;
        for(int i=0;i<n;i++){
            if (checkSorted(array)) {
                check = true;
                break;
            }
            rotateLeft(array,n);
        }
        System.out.println(check);
    }
}