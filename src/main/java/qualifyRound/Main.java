package qualifyRound;

import java.io.File;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    String path = Paths.get(".").toAbsolutePath().normalize().toString();
    String exampleDir = path + "/src/main/java/" + this.getClass().getPackage().getName() + "/example";

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.path);
        System.out.println(m.exampleDir);
        try {
//            File f = new File(m.exampleDir);
//            File[] files = f.listFiles();
//            for (int i = 0; i < files.length; i++) {
//                File example = files[i];
//            }

            File f = new File(m.exampleDir + "/a.txt");
            Scanner scanner = new Scanner(f);
            HashMap<String, Pair> map = new HashMap<>();
            int bonusSec = scanner.nextInt();
            int intersectionCount = scanner.nextInt();
            int streetsCount = scanner.nextInt();
            int carCount = scanner.nextInt();
            int carPoint = scanner.nextInt();
            Pair<String, Integer>[][] graph = new Pair[streetsCount][streetsCount];
            scanner.nextLine();
            int _streetsCount = streetsCount;
            while (_streetsCount > 0) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                String name = scanner.next();
                int time = scanner.nextInt();
                graph[start][end] = new Pair(name, time);
                map.put(name, graph[start][end]);
                scanner.nextLine();
                _streetsCount--;
            }

            // print graph
//            for (int y = 0; y < streetsCount; y++) {
//                for (int x = 0; x < streetsCount; x++) {
//                    if (graph[y][x] != null) {
//                        System.out.println(y + " to " + x + " value : " + graph[y][x].v);
//                    }
//                }
//            }

            int _carCount = carCount;
            Car[] cars = new Car[carCount];
            while (_carCount > 0) {
                int pathPoints = scanner.nextInt();
                Car car = new Car();
                while (pathPoints > 0) {
                    car.streets.add(scanner.next());
                    pathPoints--;
                }
                cars[carCount - _carCount] = car;
                scanner.nextLine();
                _carCount--;
            }

            // print car streets size
//            for (int cIdx = 0; cIdx < carCount; cIdx++) {
//                System.out.println(" " + cars[cIdx].streets.size());
//            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Car {
    ArrayList<String> streets = new ArrayList<>();
}

class Pair<K,V> {
    K k;
    V v;
    Pair(K k, V v) {
        this.k = k;
        this.v = v;
    }
}

