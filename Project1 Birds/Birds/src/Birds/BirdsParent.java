package Birds;

import java.util.ArrayList;

public class BirdsParent implements Birds {

    private final BirdsType type;
    private final ArrayList<String> characteristics;
    private final Boolean isExtinct;
    private final int wingNum;

    private ArrayList<FoodType> foodList;

    public BirdsParent(BirdsType type, ArrayList<String> characteristics,
                       Boolean isExtinct, int wingNum, ArrayList<FoodType> foodList) {    //bird parent class constructor
        this.type = type;
        this.isExtinct = isExtinct;
        this.wingNum = wingNum;
        this.foodList = foodList; //need to pass in ArrayList to instantiate
        if (characteristics.size() > 4 || characteristics.size() < 2){
            throw new IllegalArgumentException("number of bird characteristics should be 2 - 4");
        } else {
            this.characteristics = characteristics;   //when exception is reached program terminates
        }
    }

    public BirdsParent(BirdsType type, ArrayList<String> characteristics, //overload constructor for FlightlessBirds
                       Boolean isExtinct, ArrayList<FoodType> foodList) {  //so that wingNum is set to 0
        this(type, characteristics, isExtinct, 0, foodList);
        //equivalent to this.wingNum = 0;
    }

    @Override                               //getTypeName() is in the interface
    public BirdsType getTypeName() {
        return type;
    }
    @Override
    public ArrayList<String> getCharacteristic(){//characteristic can be stored as arraylist or string
        return characteristics;
    }


    public boolean getIsExtinct() {
        return this.isExtinct;
    }

    @Override
    public int getNumOfWings() {
        return this.wingNum;
    }


    public ArrayList<FoodType> getFoodList(){    // return arrayLIST of food types
        return foodList;                              //iterate update when bird come and go
    }

    @Override
    public String toString() {
        return "This bird is called " + this.getTypeName() + " and it has " + this.getNumOfWings() + " number of wings"
                + ". They are know to be:" + this.getCharacteristic();
    }
}
