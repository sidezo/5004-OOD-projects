package Birds;

import java.util.ArrayList;

public class Watefowl extends WaterBirds {
    public Watefowl(BirdsType type, ArrayList<String> characteristics,
                    Boolean isExtinct, int wingNum, ArrayList<FoodType> foodList, String waterBody) {
        super(type, characteristics, isExtinct, wingNum, foodList, waterBody);
    }
}
