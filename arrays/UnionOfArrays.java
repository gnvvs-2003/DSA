import java.util.Arrays;

public class UnionOfArrays {
    public static int[] union(int[] array1, int[] array2) {
        Arrays.sort(array1);
        Arrays.sort(array2);
        int n1 = array1.length;
        int n2 = array2.length;
        int[] array = new int[n1 + n2];
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        while (index1 < n1 && index2 < n2) {
            if (array1[index1] < array2[index2]) {
                array[index++] = array1[index1++];
            } else {
                array[index++] = array2[index2++];
            }
        }
        while (index1 < n1) {
            array[index++] = array1[index1++];
        }
        while (index2 < n2) {
            array[index++] = array2[index2++];
        }
        return Arrays.copyOf(array, index);
    }
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 1, 4};
        int[] array2 = {-1, 12, 5, 3, 2};

        int[] result = union(array1, array2);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}