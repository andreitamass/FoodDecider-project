import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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

        while(replacementChecker(list, current_choices, rejected_choices)) {
            for (int i = 0; i < current_choices.size(); i++ ) { //visar index alternativ + current maträtter
                System.out.println(i  + ": " + current_choices.get(i));
            }

            System.out.println("Vilken maträtt vill du ta bort");

            if(scanner.hasNextInt()) {
                int index = scanner.nextInt();

                if(index >= 0 && index < current_choices.size()) {
                     rejectedFood(list, current_choices, rejected_choices, index);
                    foodReplacement(list, current_choices, rejected_choices);
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

    public static void rejectedFood(ArrayList<FoodOptions> list, ArrayList<FoodOptions> current_choices, ArrayList<FoodOptions> rejected_choices, int index) {

        if (index >= current_choices.size()) {
            return;
        }

          if (current_choices.isEmpty()) {
            return;
        }

        rejected_choices.add(current_choices.get(index));

        current_choices.remove(index);
        
    }

    public static boolean replacementChecker(ArrayList<FoodOptions> list, ArrayList<FoodOptions> current_choices, ArrayList<FoodOptions> rejected_choices) {

        //Kontrollerar ifall det finns ersättare innan vi tar bort maträtten

        boolean foundReplacement = false;

        for (FoodOptions i : list) { // Loopar igenom hela mat listan, kontrollerar om maträtten finns i current och rejected
            if (!current_choices.contains(i) && !rejected_choices.contains(i)) {
                foundReplacement = true;
                break;
            }

        }

        if(!foundReplacement) { //Stoppar processen om ingen ersättare hittas
            return false;
        }

        return foundReplacement;

    }

    public static boolean foodReplacement(ArrayList<FoodOptions> list, ArrayList<FoodOptions> current_choices, ArrayList<FoodOptions> rejected_choices) {

        boolean foundReplacement = false;

        for (FoodOptions i : list) { // Loopar igenom hela mat listan, kontrollerar om maträtten finns i current och rejected
            if (!current_choices.contains(i) && !rejected_choices.contains(i)) {
                foundReplacement = true;
                current_choices.add(i);
                System.out.println("Ny mat rätt: " + i);
                break;
            }

        }

        if(!foundReplacement) { //Stoppar processen om ingen ersättare hittas
            System.out.println("Nu finns det inga fler nya förslag");
            return false;
        }

        return foundReplacement;

    }

}

// Vad händer om använadren säger nej till allt - fixat, "Nu finns det inga fler nya förslag" visas

// Gör program mer generellt, låta användaren ta bort index 1 och 2 också inte bara 0

// Vad händer om användaren säger nej till flera kort - fixat, ersättningsmat finns samt - "Nu finns det inga fler nya förslag"

// Logiken fungerar - stoppar krasch när det inte finns fler ersättare - fixat

// I slutet visas endast 2 kort, då den redan ersatt sista korten - ONGOING