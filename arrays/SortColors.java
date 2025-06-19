public class SortColors {
    public static int[] sortedColors(int[]array){
        // fill 0's first 2's last and 1's in the nmiddle
        int n = array.length;
        int[]sortedColors = new int[n];
        int zeroCount = 0;int oneCount = 0;int twoCount = 0;
        int index = 0;
        for (int num : array) {
            if (num == 0) zeroCount++;
            else if (num == 1) oneCount++;
            else if (num == 2) twoCount++;
        }
        while (zeroCount>0) {
            sortedColors[index] = 0;
            index++;
            zeroCount--;
        }
        while (oneCount>0) {
            sortedColors[index] = 1;
            index++;
            oneCount--;
        }
        while (twoCount>0) {
            sortedColors[index] = 2;
            index++;
            twoCount--;
        }
        return sortedColors;
        
    }
    public static void sortedColorsUsingDutchFlagMethod(int[]array){
        int low = 0;
        int mid = 0;
        int n = array.length;
        int high = n-1;
        while (mid<=high) {
            if(array[mid]==0){
                int temp = array[low];
                array[low] = array[mid];
                array[mid] = temp;
                low++;
                mid++;
            }
            else if(array[mid]==1){
                mid++;
            }
            else{
                int temp = array[mid];
                array[mid] = array[high];
                array[high] = temp;
                high--;
            }

        }
    }
    public static void main(String[] args) {
        int[]arr = {2,1,0,1,0,1,0,1,0,1,0,1,0,2,0,1,0,2,0,1,0,2,1};
        for (int i : sortedColors(arr)) {
            System.out.print(i+" ");
        }
        sortedColorsUsingDutchFlagMethod(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}