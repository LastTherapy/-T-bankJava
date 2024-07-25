package ru.dobrocraft.ex5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class Main {

    public HashMap<Integer, Integer> memoPaths = new HashMap<>();
    // храним максимальный путь для каждого потока чтобы не производить повторные вычисления
    public HashMap<Integer, int[]> threads = new HashMap<>();
//    public HashMap<Integer, ArrayList<Integer>> distanceMap = new HashMap<>();
    public int maxDistance = 0;

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
            for (int i = 0; i < threads.size(); i++) {
                if (!memoPaths.containsKey(i + 1)) {
                    memoPaths.put(i + 1, findMaxPath(i + 1, 1));
                }
                maxPathsLen = Math.max(maxPathsLen, memoPaths.get(i + 1));
            }
        }
        this.maxDistance = maxPathsLen;
        return maxPathsLen;
    }

    public int findMaxPath(int threadNumber, int currentWay) {

        if (threads.get(threadNumber).length == 0) {
            memoPaths.put(threadNumber, currentWay);
            return currentWay;
        }
        int max_way = currentWay;
        for (int dependency : threads.get(threadNumber)) {
            if (!memoPaths.containsKey(dependency)) {
                memoPaths.put(dependency, findMaxPath(dependency, 1));
//                distanceMap.get(currentWay).add(dependency);
            }
            max_way = Math.max(max_way, memoPaths.get(dependency) + currentWay);
        }
        return max_way;
    }

    public ArrayList<ArrayList<Integer>> calcSetsOfPaths() {
        ArrayList<ArrayList<Integer>> setsOfPaths = new ArrayList<>();
        for (int i = 0; i <= this.maxDistance; i++) {
            ArrayList<Integer> setPaths = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : this.memoPaths.entrySet()) {
                if (entry.getValue() == i) {
                    setPaths.add(entry.getKey());
                }
            }
            if (setPaths.isEmpty()) {
                continue;
            }
            setsOfPaths.add(setPaths);
        }
        return setsOfPaths;
    }


    public static void main(String[] args){
        Main main = new Main();
        main.readInput();
        main.calcMaxPath();
        ArrayList<ArrayList<Integer>> result = main.calcSetsOfPaths();
        System.out.println(result.size());
        for (ArrayList<Integer> set : result) {
            if (set.isEmpty()) {
                continue;
            }
            System.out.print(set.size() + " ");
            for (Integer i : set) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
