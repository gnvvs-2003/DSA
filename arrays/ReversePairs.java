public class ReversePairs {
    public static void merge(int[]array,int low,int mid,int high){
        int[]temp = new int[high-low+1];
        int left = low;
        int right = mid+1;
        int index = 0;
        while(left<=mid && right<=high){
            if (array[left]<=array[right]) {
                temp[index] = array[left];
                index++;
                left++;
            }
            else{
                temp[index] = array[right];
                index++;
                right++;
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
    }
    public static int countCondition(int[] array, int low, int mid, int high) {
        int count = 0;
        int right = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (right <= high && (long) array[i] > 2L * array[right]) {
                right++;
            }
            count += (right - (mid + 1));
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
        // count+=merge(array,low,mid,high);
        /*
         * @gnvvs-2003 The only difference is while count inversion pair just merge condition is ok but now a different condition is required
         */
        count+=countCondition(array,low,mid,high);
        merge(array, low, mid, high);

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