import javax.swing.*;
import java.util.*;

public class Main {

    public static boolean valid(int[][] matrix, int r, int c) {
        int n = matrix.length; // Numărul de rânduri
        int m = matrix[0].length; // Numărul de coloane
        return r >= 0 && r < n && c >= 0 && c < m && matrix[r][c] == 0;
    }

    public static void lee(int[][] matrix, int iStart, int jStart, int iFinal, int jFinal) {

        int[] row = { -1, 0, 1, 0};
        int[] column = { 0, 1, 0, -1};

        if (matrix[iStart][jStart] == -1 || matrix[iFinal][jFinal] == -1) {
            System.out.println("Pozitii incorecte");
            return;
        }

        int n = matrix.length; // Numărul de rânduri
        int m = matrix[0].length; // Numărul de coloane

        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(iStart, jStart, 1));

        while (!queue.isEmpty()) {

            Coordinate coordinate = queue.poll();
            int r = coordinate.i;
            int c = coordinate.j;
            int distance = coordinate.length;

            if (r == iFinal && c == jFinal) {
                System.out.println("Distanta minima: " + (distance - 1));
                return;
            }

            for (int k = 0; k < 4; k++) {
                int newR = r + row[k];
                int newC = c + column[k];
                if (valid(matrix, newR, newC)) {
                    matrix[newR][newC] = 1; // Marcați celula ca vizitată
                    queue.add(new Coordinate(newR, newC, distance + 1));
                }
            }

        }
        System.out.println("Nu se poate ajunge la destinație.");

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int iStart = input.nextInt();
        int jStart = input.nextInt();
        int iFinal = input.nextInt();
        int jFinal = input.nextInt();
        int[][] matrix =
                {
                        { -1, -1, -1, -1, -1, -1, -1 },
                        { -1, -1,  0, -1, -1, -1, -1 },
                        { -1, -1,  0,  0,  0, -1, -1 },
                        { -1, -1,  0, -1, -1, -1, -1 },
                        { -1,  0,  0,  0,  0, -1, -1 },
                        { -1, -1, -1, -1,  0, -1, -1 },
                        { -1, -1, -1, -1, -1, -1, -1 }
                };
        lee(matrix, iStart, jStart, iFinal, jFinal);
    }
}