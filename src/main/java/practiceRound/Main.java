package practiceRound;

import java.io.File;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
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
            int pizzaCount = scanner.nextInt();
            int[] teams = new int[3]; // each team people : 2, 3, 4; teams[0] mean that there are teams[0] teams with 2 people.
            for (int tIdx = 0; tIdx < teams.length; tIdx++) {
                teams[tIdx] = scanner.nextInt();
                System.out.println((tIdx + 2) + " people team count ");
            }
            scanner.nextLine();
            PizzaIngredient[] pizzas = new PizzaIngredient[pizzaCount];
            // construct pizza
            for (int pIdx = 0; pIdx < pizzaCount; pIdx++) {
                int gradientCount = scanner.nextInt();
                ArrayList<String> ingredients = new ArrayList<>();
                for (int gIdx = 0; gIdx < gradientCount; gIdx++) {
                    ingredients.add(scanner.next());
                }
                pizzas[pIdx] = new PizzaIngredient(ingredients, gradientCount);
                scanner.nextLine();
            }

            for (int ii = 0; ii < pizzas.length; ii++) {
                System.out.print(pizzas[ii].ingredientsCount + " ");
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class PizzaIngredient {
    List<String> ingredients;
    int ingredientsCount = 0;
    PizzaIngredient(List<String> ingredients, int count) {
        this.ingredients = ingredients;
        this.ingredientsCount = count;
    }
}
