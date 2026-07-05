package Backend;
import java.util.ArrayList;

public class FoodData {
    public ArrayList<FoodOptions> getAllFoodOptions() {

        FoodOptions pizza = new FoodOptions("Pizza", "Italienskt", 120);

        FoodOptions sushi = new FoodOptions("Sushi", "Japanskt", 140);

        FoodOptions hamburger = new FoodOptions("Hamburgare", "Amerikanskt", 99);

        FoodOptions kebab = new FoodOptions("Kebab", "Snabbmat", 89);

        FoodOptions tacos = new FoodOptions("Tacos", "Sydamerikanskt", 119);

        FoodOptions thai = new FoodOptions("Pad Thai", "Thai", 119);

        ArrayList<FoodOptions> list = new ArrayList<FoodOptions>();

        list.add(hamburger);
        list.add(sushi);
        list.add(pizza);
        list.add(kebab);
        list.add(tacos);
        list.add(thai);

        return list;

    }
}
