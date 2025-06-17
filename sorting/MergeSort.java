import java.util.ArrayList;

public class MergeSort {
    public static void merge(int[] array, int low, int high, int mid) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (array[left] <= array[right]) {
                temp.add(array[left]);
                left++;
            } else {
                temp.add(array[right]);
                right++;
            }
        }

        // Remaining elements on the left
        while (left <= mid) {
            temp.add(array[left]);
            left++;
        }

        // Remaining elements on the right
        while (right <= high) {
            temp.add(array[right]);
            right++;
        }

        // Copy sorted elements back to original array IMPORTANT
        for (int i = low; i <= high; i++) {
            array[i] = temp.get(i - low);
        }
    }

    public static void mergeSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);
        merge(array, low, high, mid);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 1, 4, 2, 6, 3, 4};
        mergeSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
