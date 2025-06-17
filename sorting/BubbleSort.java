public class BubbleSort {
    public static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(); // new line after printing the array
    }

    public static void _bubbleSort(int[] array) {
        int n = array.length;
        for (int i = n - 1; i >= 0; i--) {
            boolean didSwap = false;
            for (int j = 0; j < i; j++) { // FIXED: j < i
                if (array[j] > array[j + 1]) {
                    // swap
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    didSwap = true;
                }
            }

            // If no swaps in this pass, array is sorted
            if (!didSwap) {
                break;
            }
        }
        display(array);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 1, 3, 2, 4, 5, 3};
        _bubbleSort(array);
    }
}
