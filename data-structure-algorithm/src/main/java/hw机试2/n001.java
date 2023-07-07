package hw机试2;

import java.util.Scanner;

public class n001 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String colRow = in.nextLine();
        int rowCount = Integer.parseInt(colRow.split(" ")[0]);
        int colCount = Integer.parseInt(colRow.split(" ")[1]);
        int[][] matrix = new int[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            String row = in.nextLine();
            String[] s = row.split(" ");
            for (int i1 = 0; i1 < s.length; i1++) {
                matrix[i][i1] = Integer.parseInt(s[i1]);
            }
        }
        int count = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                } else if (i - 1 >= 0 && matrix[i - 1][j] == 1) {
                    count++;
                } else if (i + 1 < rowCount && matrix[i + 1][j] == 1) {
                    count++;
                } else if (j - 1 >= 0 && matrix[i][j - 1] == 1) {
                    count++;
                } else if (j + 1 < colCount && matrix[i][j + 1] == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

}
