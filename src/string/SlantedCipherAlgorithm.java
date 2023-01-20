package string;

public class SlantedCipherAlgorithm {

    private static String decodedString(String encodedString, int numberOfRows) {



        int n = encodedString.length() / numberOfRows;
        char[][] arr = new char[numberOfRows][n];
        int row = 0, col = 0, maxCol = arr[0].length;
        for (int i = 0; i < encodedString.length(); i++) {
            if (encodedString.charAt(i) == '_')
                arr[row][col] = '#';
            else
                arr[row][col] = encodedString.charAt(i);
            col++;
            if (col % maxCol == 0) {
                row++;
                col = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr[0].length; i++) {
            int index = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j][(i + index) % n] == '#')
                    sb.append(" ");
                else
                    sb.append(arr[j][(i + index) % n]);
                index++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(decodedString("mnes__ya_____mi", 3));
        System.out.println(decodedString("hlowrd_el_ol", 2));
    }
}
