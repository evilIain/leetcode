package codinginterview.arraysstrings;

import java.util.Arrays;

public class ZeroMatrix_1_8 {

    public static void nullify(int[][] matrix) {

        boolean[] rows = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }

        for (int i = 0; i < rows.length; i++) {
            if (rows[i]) {
                nullifyRow(matrix, i);
            }
        }

        for (int i = 0; i < columns.length; i++) {
            if (columns[i]) {
                nullifyColumn(matrix, i);
            }
        }
    }

    public static void nullifyRow(int[][] matrix, int row) {
        Arrays.fill(matrix[row], 0);
    }

    public static void nullifyColumn(int[][] matrix, int column) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix =
                {
                        {1,2,3,4,0},
                        {6,7,8,9,10},
                        {11,12,13,14,15},
                        {16,0,18,19,20},
                        {21,22,23,24,25}
                };

        nullify(matrix);
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
