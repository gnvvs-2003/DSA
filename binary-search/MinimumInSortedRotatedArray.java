public class MinimumInSortedRotatedArray {
    public static int minValue(int[]array){
        int low = 0;
        int n = array.length;
        int high = n-1;
        int ans = Integer.MAX_VALUE;
        while (low<=high) {
            int mid = low+(high-low)/2;
            //@gnvvs-2003 : if no rotation happens
            if (array[low]<=array[high]) {
                ans = Math.min(ans, array[low]);
            }
            // @gnvvs-2003 : if left part is sorted
            if (array[low]<=array[mid]) {
                ans = Math.min(ans, array[low]);
                low = mid+1;
            }
            // @gnvvs-2003 : right part is sorted
            else{
                ans = Math.min(ans, array[mid]);
                high = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] array = {4, 5, 6, 7, 0, 1, 2, 3};
        int ans = minValue(array);
        System.out.println("The minimum element is: " + ans );
    }
}