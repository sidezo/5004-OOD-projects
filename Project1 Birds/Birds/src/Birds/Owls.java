package Birds;

import java.util.ArrayList;

public class Owls extends BirdsParent {
    public Owls(BirdsType type, ArrayList<String> characteristics,
                Boolean isExtinct, int wingNum, ArrayList<FoodType> foodList) {
        super(type, characteristics, isExtinct, wingNum, foodList);
    }
}
