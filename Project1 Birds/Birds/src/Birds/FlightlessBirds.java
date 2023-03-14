package Birds;

import java.util.ArrayList;

public class FlightlessBirds extends BirdsParent{


    //here we do not pass wingNum because in the overloaded constructor wingNum has been set to zero;
    public FlightlessBirds(BirdsType type, ArrayList<String> characteristics,
                           Boolean isExtinct, int noWings, ArrayList<FoodType> foodList){
        super(type, characteristics, isExtinct, foodList);

    }

}
