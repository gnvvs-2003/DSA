public class RotateImage {
    public static void reverse(int[]arr){
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            // Swap arr[start] and arr[end]
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static void rotateImage(int[][]matrix){
        // step - 1 : transpose
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        // step - 2 : mirror image 
        for (int[] rowMatrix : matrix) {
            reverse(rowMatrix);
        }
    }
    public static void display(int[][]matrix){
        for (int[] rowMatrix : matrix) {
            for (int element : rowMatrix) {
                System.out.print(element+"  ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int [][]matrix = {
            {1,2,3},
            {4,2,1},
            {0,-2,8}
        };
        display(matrix);
        System.out.println();
        rotateImage(matrix);
        display(matrix);
    }
}