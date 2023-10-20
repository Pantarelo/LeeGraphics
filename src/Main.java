import javax.swing.*;
import java.util.Scanner;

public class Main {

    static int rows = 5, columns = 5;
    public void Lee() {

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int iStart = input.nextInt();
        int jStart = input.nextInt();
        int iFinal = input.nextInt();
        int jFinal = input.nextInt();
        int[][] matrix =
                {
                        { -1,  0, -1, -1, -1 },
                        { -1,  0,  0,  0, -1 },
                        { -1, -1, -1,  0, -1 },
                        {  0,  0,  0,  0, -1 },
                        { -1, -1, -1,  0, -1 }
                };
    }
}