package Backend;
import java.util.ArrayList;

public class FoodMananger {

    public static void rejectedFood(ArrayList<FoodOptions> list, ArrayList<FoodOptions> current_choices, ArrayList<FoodOptions> rejected_choices, int index) {

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