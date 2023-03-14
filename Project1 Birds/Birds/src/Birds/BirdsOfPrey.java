package Birds;

import java.util.ArrayList;

public class BirdsOfPrey extends BirdsParent{

    public BirdsOfPrey(BirdsType type, ArrayList<String> characteristics,
                       Boolean isExtinct, int wingNum, ArrayList<FoodType> foodList){
        super(type, characteristics, isExtinct, wingNum, foodList);
    }
}
