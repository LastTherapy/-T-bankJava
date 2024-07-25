package ru.dobrocraft.ex4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        ArrayList<Integer> memoPaths = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int threadNumbers = scanner.nextInt();
        HashMap<Integer, int[]> threads = new HashMap<>();
        for (int i = 0; i < threadNumbers; i++) {
            int dependencyCurrentNumber = scanner.nextInt();
            int[] dependencies = new int[dependencyCurrentNumber];
            for (int j = 0; j < dependencyCurrentNumber; j++) {
                dependencies[j] = scanner.nextInt();
            }
            threads.put(i + 1, dependencies);
        }
        scanner.close();

        int maxPathsLen = 0;
        if (threads.containsKey(1)) {
            maxPathsLen = findMaxPath(threads,  1, 1);
        }
            System.out.println(maxPathsLen);;
        }

        /*
        * 5
        * 3 2 3 5
        * 1 4
        * 0
        * 0
        * 1 3
        *
        * 6
        * 1 2
        * 1 3
        * 1 4
        * 1 5
        * 1 6
        * 0
        *
        * 6
        * 5 2 3 4 5 6
        * 0
        * 0
        * 0
        * 0
        * 0
        *
        * 3
        * 0
        * 0
        * 0
        * */



    public static int findMaxPath(HashMap<Integer, int[]> threads, int threadNumber, int currentWay) {

        if (threads.get(threadNumber).length == 0) {
            return currentWay;
        }
        int max_way = currentWay;
        for (int dependency : threads.get(threadNumber)) {
            max_way = Math.max(max_way, findMaxPath(threads, dependency, currentWay + 1));
        }
        return max_way;
    }

}
