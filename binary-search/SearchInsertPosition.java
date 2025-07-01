public class SearchInsertPosition {
    public static int searchIndex(int[]array,int target){
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int target = 10;
        int []array = {1,2,3,6,9,11,35};
        System.out.println(searchIndex(array,target));
    }
}