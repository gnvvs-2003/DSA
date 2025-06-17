public class CheckSortedWithRotation{
    // sorted checking
    public static boolean checkSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false; // not sorted
            }
        }
        return true; // sorted
    }
    // rotate
    public static void rotateLeft(int[]array,int n){
        int firstElement = array[0];
        for(int i=1;i<n;i++){
            array[i-1] = array[i];
        }
        array[n-1] = firstElement;
    }
    // brute-force
    public static boolean check(int[] nums) {
        boolean check = false;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if (checkSorted(nums)) {
                check = true;
                break;
            }
            rotateLeft(nums,n);
        }
        return check;
    }
    // OPTIMIZED WAY
    public static boolean checkOptimized(int[] arr){
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int current = arr[i];
            int next = arr[(i + 1) % n]; // circular check
            if (current > next) {
                count++;
            }
        }
        // If the drop occurs more than once, it's not sorted by rotation
        return count <= 1;
    }
    // main
    public static void main(String[] args) {
        int[]array = {4,5,1,3};
        boolean status = check(array);
        System.out.println(status);
        boolean statusOptimized = checkOptimized(array);
        System.out.println(statusOptimized);
    }
}