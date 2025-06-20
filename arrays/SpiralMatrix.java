public class SpiralMatrix {

    public static void spiralDisplay(int[][] matrix) {
        int startRow = 0;
        int endRow = matrix.length;
        int startCol = 0;
        int endCol = matrix[0].length;

        while (startRow < endRow && startCol < endCol) {
            // Top row
            for (int i = startCol; i < endCol; i++) {
                System.out.print(matrix[startRow][i] + " ");
            }
            startRow++;

            // Right column
            for (int i = startRow; i < endRow; i++) {
                System.out.print(matrix[i][endCol - 1] + " ");
            }
            endCol--;

            // Bottom row (if remaining)
            if (startRow < endRow) {
                for (int i = endCol - 1; i >= startCol; i--) {
                    System.out.print(matrix[endRow - 1][i] + " ");
                }
                endRow--;
            }

            // Left column (if remaining)
            if (startCol < endCol) {
                for (int i = endRow - 1; i >= startRow; i--) {
                    System.out.print(matrix[i][startCol] + " ");
                }
                startCol++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            { 1,  2,  3,  4 },
            { 5,  6,  7,  8 },
            { 9, 10, 11, 12 },
            {13, 14, 15, 16}
        };

        System.out.println("Spiral order of the matrix:");
        spiralDisplay(matrix);
    }
}
