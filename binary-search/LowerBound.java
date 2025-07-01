// condition for answer array[i]>= target

public class LowerBound {
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
        int[] array = { 3, 5, 8, 15, 19 };
        int x = 9;
        int ind = lowerBound(array, x);
        System.out.println("The lower bound is the index: " + ind);
    }
}