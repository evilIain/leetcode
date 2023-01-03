package codinginterview.arraysstrings;

public class RotateMatrix_1_7 {

    public static int[][] rotate(int[][] matrix) {
        int[][] newMatrix = new int[matrix.length][matrix.length];
        for (int i = 0, k = matrix.length - 1; i < matrix.length; i++, k--) {
            for (int j = 0; j < matrix.length; j++) {
                newMatrix[j][k] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}, {16,17,18,19,20}, {21,22,23,24,25}};
        matrix = rotate(matrix);
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
