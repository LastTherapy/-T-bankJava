package ru.dobrocraft.ex2;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int step = scanner.nextInt();
        scanner.close();

        long result = 1;
        if (step > 1) {
            result = (long) (step - 1) * 4;
        }
        System.out.println(result);

    }
}
