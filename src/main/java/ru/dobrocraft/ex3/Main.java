package ru.dobrocraft.ex3;
import java.util.Scanner;

public class Main {

    private static int sumColumn(int[][] data, int posColumn) {

        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i][posColumn];
        }
        return sum;
    }

    private static int sumRow(int[][] data, int posRow) {
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[posRow][i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] matrix = new int[n][n];
        int[] rows = new int[n];
        int[] columns = new int[n];

        // заполняем матрицу из потока ввода
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // суммируем строки и столбцы
        for (int i = 0; i < n; i++) {
            rows[i] = sumRow(matrix, i);
            columns[i] = sumColumn(matrix, i);
        }
        int iterest_number = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                int column = sumColumn(matrix, j);
                int different = Math.abs(rows[i] - columns[j]);
                if (different <= matrix[i][j]) {
                    iterest_number++;
                }
            }
        }

        System.out.println(iterest_number);
    }
}
