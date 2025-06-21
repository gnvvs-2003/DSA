public class QuickSortSinglePivot {
    static int partition(int[] array, int low, int high) {
        int pivot = array[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (i <= high - 1 && array[i] <= pivot) {
                i++;
            }
            while (j >= low + 1 && array[j] > pivot) {
                j--;
            }

            if (i < j) {
                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap pivot with array[j]
        int temp = array[low];
        array[low] = array[j];
        array[j] = temp;

        return j;
    }

    static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pIndex = partition(array, low, high);
            quickSort(array, low, pIndex - 1);
            quickSort(array, pIndex + 1, high);
        }
    }

    public static int[] quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }
    public static void main(String[] args) {
        int[] array = {4, 6, 2, 5, 7, 9, 1, 3};

        System.out.println("Before Quick Sort:");
        for (int val : array) {
            System.out.print(val + " ");
        }

        quickSort(array);

        System.out.println("\nAfter Quick Sort:");
        for (int val : array) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
