package practiceRound;

import java.io.File;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Paths;
import java.util.Scanner;

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

            File f = new File(m.exampleDir + "/a_example");
            Scanner scanner = new Scanner(f);
            System.out.println("file : " + scanner.nextInt());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
