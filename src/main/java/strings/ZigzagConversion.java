package strings;

public class ZigzagConversion {

    public static String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        int n = s.length();
        int numColumns = ((int) Math.ceil(n / (2 * numRows - 2.0))) * (numRows - 1);
        char[][] zigzag = new char[numRows][numColumns];

        int rowNumber = 0;
        int columnNumber = 0;
        int i = 0;

        while (i < n) {
            while (rowNumber < numRows && i < n) {
                zigzag[rowNumber][columnNumber] = s.charAt(i);
                rowNumber++;
                i++;
            }

            rowNumber--;

            while (rowNumber != 0 && i < n) {
                zigzag[--rowNumber][++columnNumber] = s.charAt(i);
                i++;
            }
            rowNumber++;
        }

        StringBuilder result = new StringBuilder();
        for (i = 0; i < zigzag.length; i++) {
            for (int j = 0; j < zigzag[0].length; j++) {
                if (zigzag[i][j] != 0) {
                   result.append(zigzag[i][j]);
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println(convert(s, 5));
    }
}
