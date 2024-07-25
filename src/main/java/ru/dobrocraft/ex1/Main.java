package ru.dobrocraft.ex1;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        int l = n - 100 + 1;
        long result = (long) l * (100 + n) / 2;
        System.out.println(result);
    }
}
