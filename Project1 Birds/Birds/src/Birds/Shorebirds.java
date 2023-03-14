package Birds;

import java.util.ArrayList;

public class Shorebirds extends WaterBirds {
    public Shorebirds(BirdsType type, ArrayList<String> characteristics,
                      Boolean isExtinct, int wingNum, ArrayList<FoodType> foodList, String waterBody) {
        super(type, characteristics, isExtinct, wingNum, foodList, waterBody);
    }
}
