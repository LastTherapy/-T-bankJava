package ru.dobrocraft.ex3;

import java.util.Scanner;

public class Test {

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

    public static int longestSolution(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int iterest_number = 0;
        for (int i = 0; i < n; i++) {
            int row = sumRow(matrix, i);
            for (int j = 0; j < n; j++) {
                int column = sumColumn(matrix, j);
                int different = Math.abs(row - column);
                if (different <= matrix[i][j]) {
                    iterest_number++;
                }
            }
        }
        return iterest_number;
    }
}
