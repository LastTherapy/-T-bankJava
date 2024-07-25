package ru.dobrocraft.ex4;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public HashMap<Integer, Integer> memoPaths = new HashMap<>();
    // храним максимальный путь для каждого потока чтобы не производить повторные вычисления
    public HashMap<Integer, int[]> threads = new HashMap<>();

    public void readInput() {
        Scanner scanner = new Scanner(System.in);
        int threadNumbers = scanner.nextInt();
        for (int i = 0; i < threadNumbers; i++) {
            int dependencyCurrentNumber = scanner.nextInt();
            int[] dependencies = new int[dependencyCurrentNumber];
            for (int j = 0; j < dependencyCurrentNumber; j++) {
                dependencies[j] = scanner.nextInt();
            }
            threads.put(i + 1, dependencies);
        }
        scanner.close();
    }

    public int calcMaxPath() {
        int maxPathsLen = 0;
        if (threads.containsKey(1)) {
            maxPathsLen = findMaxPath(  1, 1);
        }
        return maxPathsLen;
    }

    public int findMaxPath(int threadNumber, int currentWay) {

        if (threads.get(threadNumber).length == 0) {
            return currentWay;
        }
        int max_way = currentWay;
        for (int dependency : threads.get(threadNumber)) {
            if (!memoPaths.containsKey(dependency)) {
                memoPaths.put(dependency, findMaxPath(dependency, 1));
            }
            max_way = Math.max(max_way, memoPaths.get(dependency) + currentWay);
        }
        return max_way;
    }


    public static void main(String[] args){
        Main main = new Main();
        main.readInput();
        System.out.println(main.calcMaxPath());
        }
}
