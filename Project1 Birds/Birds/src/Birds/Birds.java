package Birds;

import java.util.ArrayList;


public interface Birds {

    BirdsType getTypeName();

    ArrayList<String> getCharacteristic();

    boolean getIsExtinct();

    int getNumOfWings();

    ArrayList<FoodType> getFoodList();     // return arrayLIST of food types


}
