package com.foodproject;
import java.util.ArrayList;
import java.util.Collections;
public class FoodManager {

    private ArrayList<FoodOptions> list;
    private ArrayList<FoodOptions> current_choices;
    private ArrayList<FoodOptions> rejected_choices;

    public FoodManager() {

        FoodData foodData = new FoodData(); // Alla maträtter

        list = foodData.getAllFoodOptions();

        Collections.shuffle(list);

        current_choices = new ArrayList<>();

        current_choices.add(list.get(0));
        current_choices.add(list.get(1));
        current_choices.add(list.get(2));

        rejected_choices = new ArrayList<>();

    }

    public boolean replaceFood(int index) { //make endpoint
        if (!replacementChecker()) {
            return false;
        }

        rejectedFood(index);
        foodReplacement(index);

        return true;

    }

    public ArrayList<FoodOptions> getAllFoods() {
        return list;
    }

    public ArrayList<FoodOptions> getCurrentOptions() {
        return current_choices;
    }

    public void rejectedFood(int index) {

        if (current_choices.isEmpty()) {
                return;
        }

        rejected_choices.add(current_choices.get(index));
        
        }


    public boolean replacementChecker() {

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

    public boolean foodReplacement(int index) {

        boolean foundReplacement = false;

        for (FoodOptions i : list) { // Loopar igenom hela mat listan, kontrollerar om maträtten finns i current och rejected
            if (!current_choices.contains(i) && !rejected_choices.contains(i)) {
                foundReplacement = true;
                current_choices.set(index, i);
                System.out.println("Ny mat rätt: " + i); //Terminal check
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