public class FloorCeil {
    // floor
    public static int upperBound(int[]array,int target){
        int n = array.length;
        int ans = n;
        int low = 0;
        int high = n-1;
        while (low<=high) {
            int mid = low+(high-low)/2;
            // condition
            if (array[mid]>target) {
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    // ceil
    public static int lowerBound(int[] array, int target) {
        int low = 0;
        int high = array.length-1;
        int ans = array.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid]>=target) {
                // condition satisfied
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 7, 8, 10};
        int x = 5;
        int floor = upperBound(arr, x);
        int ceil  = lowerBound(arr,x);
        System.out.println("The floor and ceil are: " + floor + "," + ceil);
    }
}