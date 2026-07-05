package Backend;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import Backend.FoodMananger;

public class Main {
    public static void main(String[] args) {

        FoodData foodData = new FoodData(); // Alla maträtter

        ArrayList<FoodOptions> list = foodData.getAllFoodOptions();

        Collections.shuffle(list);

        ArrayList<FoodOptions> current_choices = new ArrayList<>(); // Det användaren kommer att se
        current_choices.add(list.get(0));
        current_choices.add(list.get(1));
        current_choices.add(list.get(2));

        ArrayList<FoodOptions> rejected_choices = new ArrayList<>(); // Rätterna användaren har tackat nej till

        Scanner scanner = new Scanner(System.in);

        while(FoodMananger.replacementChecker(list, current_choices, rejected_choices)) {
            for (int i = 0; i < current_choices.size(); i++ ) { //visar index alternativ + current maträtter
                System.out.println(i  + ": " + current_choices.get(i));
            }

            System.out.println("Vilken maträtt vill du ta bort");

            if(scanner.hasNextInt()) {
                int index = scanner.nextInt(); //Kontrollerar om indexet finns

                if(index >= 0 && index < current_choices.size()) {
                    FoodMananger.rejectedFood(list, current_choices, rejected_choices, index);
                    FoodMananger.foodReplacement(list, current_choices, rejected_choices);
                } else {
                    System.out.println("Alternativ finns inte!");
                }

            } else {
                System.out.println("Text är inte tilltåten!");
                scanner.next();
            }
        }
        System.out.println("Nu finns det inte fler rätter!");
        System.out.println(current_choices);
        return;

    }

}

// Vad händer om använadren säger nej till allt - fixat, "Nu finns det inga fler nya förslag" visas

// Gör program mer generellt, låta användaren ta bort index 1 och 2 också inte bara 0

// Vad händer om användaren säger nej till flera kort - fixat, ersättningsmat finns samt - "Nu finns det inga fler nya förslag"

// Logiken fungerar - stoppar krasch när det inte finns fler ersättare - fixat

// I slutet visas endast 2 kort, då den redan ersatt sista korten - fixat