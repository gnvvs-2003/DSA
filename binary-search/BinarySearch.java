public class BinarySearch {
    /*
     * @gnvvs-2003 :Iterative Approach
     */
    public static int binarySearchIterative(int[] array, int target) {
        int n = array.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low+(high-low) / 2;
            // case -1 target is in right side of array
            if (target > array[mid]) {
                // upadte the low
                low = mid + 1;
            }
            // case -2 target is in the left side of array
            else if (target < array[mid]) {
                // update the high
                high = mid - 1;
            }
            // case -3 taget=array[mid]
            else {
                return mid;
            }
        }
        return -1;
    }

    /*
     * @gnvvs-2003 : Recursive approach
     */
    public static int binarySearchRecursive(int[] array, int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low+(high-low) / 2;
        // case-1 : target = array[mid]
        if (target == array[mid]) {
            return mid;
        }
        // case -2 : target is on right side
        else if (target > array[mid]) {
            return binarySearchRecursive(array, target, mid + 1, high);
        }
        // case -3 : target is on left side
        else {
            return binarySearchRecursive(array, target, low, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] array = { -11, -2, 1, 4, 5, 16, 67, 234 };
        int target = 1;
        System.out.println(binarySearchIterative(array, target));
        System.out.println(binarySearchRecursive(array, target, 0, array.length - 1));
    }
}