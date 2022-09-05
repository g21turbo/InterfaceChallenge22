import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Player sqaull = new Player("Squall", 100, 100);
        System.out.println(sqaull.toString());
        saveObject(sqaull);

        sqaull.setHitPoints(75);
        System.out.println(sqaull);
        sqaull.setWeapon("LionHeart Buster Sword");
        saveObject(sqaull);
       // loadObject(sqaull);
        System.out.println(sqaull);

        Saveable wendigo = new Wendigo("Wendigo", 100, 250);
        System.out.println("Strength = " + ((Wendigo) wendigo).getStrength());
        System.out.println(wendigo);e
        ((Wendigo) wendigo).setWeapon("Spiked Club");
        saveObject(wendigo);
        System.out.println(wendigo);

    }


    public static ArrayList<String> readValues() {

        ArrayList<String> values = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;

            }
        }
        return values;
    }


    public static void saveObject(Saveable objectToSave) {
        for (int i = 0; i < objectToSave.write().size(); i++) {
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device");
        }
    }

    public static void loadObject(Saveable objectToLoad) {
        ArrayList<String> values = readValues();
       objectToLoad.read(values);
    }
}




