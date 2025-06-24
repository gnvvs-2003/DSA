public class CountInversions{
    public static int merge(int[]array,int low,int mid,int high){
        int[]temp = new int[high-low+1];
        int left = low;
        int right = mid+1;
        int index = 0;
        int count = 0;
        while(left<=right && right<=high){
            if (array[left]<=array[right]) {
                temp[index] = array[left];
                index++;
                left++;
            }
            else{
                temp[index] = array[right];
                index++;
                right++;
            /*
             * @gnvvs-2003 : array[left]>array[right] is the req condition
             */
                // count++; but it occurs (mid-left+1) times as all the elements to the right of array[left]
                count+=(mid-left+1);
            }
        }
        while (left<=mid) {
            temp[index] = array[left];
            index++;
            left++;
        }
        while (right<=high) {
            temp[index] = array[right];
            index++;
            right++;
        }
        // copy back the original array
        for(int i=0;i<temp.length;i++){
            array[low+i]=temp[i];
        }
        return count;
    }
    public static int mergeSort(int[]array,int low,int high){
        int count = 0;
        if (low>=high) {
            return count;
        }
        int mid = (low+high)/2;
        count+=mergeSort(array, low, mid);
        count+=mergeSort(array, mid+1, high);
        count+=merge(array,low,mid,high);
        return count;
    }
    public static int noOfInversions(int[]array){
        return mergeSort(array,0,array.length-1);
    }
    public static void main(String[] args) {
        int [] array = {5, 4, 3, 2, 1};
        System.err.println(noOfInversions(array));
    }
}