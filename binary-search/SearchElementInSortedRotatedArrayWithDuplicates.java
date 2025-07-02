public class SearchElementInSortedRotatedArrayWithDuplicates {
    public static int search(int[]array,int target){
        int low = 0;
        int n = array.length;
        int high = n-1;
        while (low<=high) {
            int mid = low+(high-low)/2;
            if (array[mid]==target) {
                return mid;
            }
            // @gnvvs-2003 : edge case
            if (array[low]==array[mid] && array[mid]==array[high]) {
                low = low+1;
                high = high-1;
                continue;
            }
            // check sorted array half
            // @gnvvs-2003 : left half is sorted
            if (array[low]<=array[mid]) {
                if (array[low]<=target && target<=array[mid]) {
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
            // @gnvvs-2003 : right half is sorted
            else{
                if (array[mid]<=target && target<=array[high]) {
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[]array = {7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
        int target = 3;
        int ans = search(array, target);
        if (ans==-1) {
            System.out.println("Element not found");
        }
        else{
            System.out.println("Found element at "+ans);
        }
    }
}