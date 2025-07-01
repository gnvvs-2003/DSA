public class HigherBound {
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
    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 9, 15, 19};
        int n = 6, x = 9;
        int ind = upperBound(arr, x);
        System.out.println("The upper bound is the index: " + ind);
    }
}