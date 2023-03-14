package Birds;

import java.util.ArrayList;

public class Pigeons extends BirdsParent {
    public Pigeons(BirdsType type, ArrayList<String> characteristics,
                   Boolean isExtinct, int wingNum, ArrayList<FoodType> foodList) {
        super(type, characteristics, isExtinct, wingNum, foodList);
    }
}
