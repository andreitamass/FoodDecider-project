public class FoodOptions {

    private String foodName;
    private String foodType; 
    private int foodPrice;

    public FoodOptions(String foodName, String foodType, int foodPrice) { 
        this.foodName = foodName;
        this.foodType = foodType;
        this.foodPrice = foodPrice;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getFoodType() {
        return foodType;
    }

    public int getFoodPrice() {
        return foodPrice;
    }

   @Override
   public String toString() {
        return "| Maträtt: " + this.foodName + 
        ", Kök: " + this.foodType +
        ", Pris: " + this.foodPrice + " SEK";
   }

}
