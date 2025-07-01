public class CountOccurences {
    public static int occurences(int[]array,int target){
        int firstIndex = -1;
        int lastIndex = -1;
        int n = array.length;
        int low = 0;
        int high = n-1;
        while (low<=high) {
            int mid = low+(high-low)/2;
            if (array[mid]==target) {
                lastIndex = mid;
                low = mid+1;
            }
            else if (array[mid]>target) {
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        low = 0;
        high = n-1;
        while (low<=high) {
            int mid = low+(high-low)/2;
            if (array[mid]==target) {
                firstIndex = mid;
                high = mid-1;
            }
            else if (array[mid]>target) {
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return lastIndex-firstIndex; 
    }
    public static void main(String[] args) {
        int[]array = {3,4,13,13,13,20,40};
        int target = 13;
        System.out.println(occurences(array,target)+1);
    }
}