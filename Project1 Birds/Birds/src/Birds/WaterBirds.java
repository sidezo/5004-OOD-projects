package Birds;

import java.util.ArrayList;

public class WaterBirds extends BirdsParent {

    private final String waterBody;
    public WaterBirds(BirdsType type, ArrayList<String> characteristics,
                      Boolean isExtinct, int wingNum, ArrayList<FoodType> foodList, String waterBody) {
        super(type, characteristics, isExtinct, wingNum, foodList);
        this.waterBody = waterBody;
    }

    public String getWaterBody(){
        return this.waterBody;
    }
}
