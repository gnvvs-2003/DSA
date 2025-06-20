public class GameLife {
    /*
     * @gnvvs-2003 : conditions
     * live to die : liveCount(element)<2 or >3
     * die to live : liveCount(element)==3
     */
    public static int liveNeighbourCount(int[][] matrix, int row, int col) {
        int count = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        // Top
        if (row > 0 && (matrix[row - 1][col] == 1 || matrix[row - 1][col] == -2)) count++;

        // Bottom
        if (row < m - 1 && (matrix[row + 1][col] == 1 || matrix[row + 1][col] == -2)) count++;

        // Left
        if (col > 0 && (matrix[row][col - 1] == 1 || matrix[row][col - 1] == -2)) count++;

        // Right
        if (col < n - 1 && (matrix[row][col + 1] == 1 || matrix[row][col + 1] == -2)) count++;

        // Top-Left
        if (row > 0 && col > 0 && (matrix[row - 1][col - 1] == 1 || matrix[row - 1][col - 1] == -2)) count++;

        // Top-Right
        if (row > 0 && col < n - 1 && (matrix[row - 1][col + 1] == 1 || matrix[row - 1][col + 1] == -2)) count++;

        // Bottom-Left
        if (row < m - 1 && col > 0 && (matrix[row + 1][col - 1] == 1 || matrix[row + 1][col - 1] == -2)) count++;

        // Bottom-Right
        if (row < m - 1 && col < n - 1 && (matrix[row + 1][col + 1] == 1 || matrix[row + 1][col + 1] == -2)) count++;

        return count;
    }

    public static void markMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = liveNeighbourCount(matrix, i, j);

                if (matrix[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        matrix[i][j] = -2; // live → die
                    }
                } else if (matrix[i][j] == 0) {
                    if (liveNeighbors == 3) {
                        matrix[i][j] = 2; // dead → live
                    }
                }
            }
        }
    }

    public static void updateMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == -2) matrix[i][j] = 0;
                if (matrix[i][j] == 2) matrix[i][j] = 1;
            }
        }
    }

    public static void display(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1},
            {0, 0, 1},
            {1, 1, 0},
            {0, 0, 1}
        };

        System.out.println("Original Matrix:");
        display(matrix);

        markMatrix(matrix);
        updateMatrix(matrix);

        System.out.println("Updated Matrix:");
        display(matrix);
    }
}
