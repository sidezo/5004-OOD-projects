package Birds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

public class Conservatory {

    // should use static variable to store max size of conservatory storing aviaries
    private ArrayList<Aviary> aviaryList = new ArrayList<Aviary>();
    private final int aviaryNum;

    final private Map<FoodType, Integer> foodMap;    // required hashmap when creating Conservatory

/*constructor of Conservatory, taking a hashmap that store foodtype and quantity required for entire conservatory*/
    public Conservatory(Map<FoodType, Integer> foodMap){
        for (int i = 0; i<5; i++){
            aviaryList.add(new Aviary("Shanghai", aviaryList.size() + 1 ));
            aviaryList.add(new Aviary("SuZhou",aviaryList.size() + 1 ) );
            aviaryList.add(new Aviary("WuHan", aviaryList.size() + 1 ));
            aviaryList.add(new Aviary("XiaMen", aviaryList.size() + 1 ));
        }
        this.aviaryNum = aviaryList.size();
        this.foodMap = foodMap;

    }



    /*Getter function for obtaining the Aviarylist*/
    public ArrayList<Aviary> getAviaryList(){
        return aviaryList;
    }

    /*Getter function to print out the food hashmap created in the constructor*/
    public String getFoodTypeQuantity(){
        String output = "";
        for (FoodType food: foodMap.keySet()){
            int quantity = foodMap.get(food);
            output += food.name() + ": " + quantity + "\n";

        }
        return output;
    }
    /*Function to add aviaries, would always output an error reminding 20 aviaries are already created in the conservatory*/
    public void AddAviaries(Aviary avy){
        if (aviaryNum >= 20) {
            throw new IllegalStateException("aviary size is at maximum");
        } else{
            getAviaryList().add(avy);     // this would never be called since we constructed 20 aviaries in constructor
        }
    }

    /*this function used to rescue birds and put then into aviaries following the specified requirements
    * would give a true boolean value when rescue succeeded. We make sure that birds of extinction is not
    * added to the observatory*/
    public boolean rescueBird(Birds newBird){
        if (newBird.getIsExtinct()) {
            throw new IllegalArgumentException("Bird extincted, does not exist");
        }
        for (int i = 0; i < 20; i++){
          if (getAviaryList().get(i).AddBird(newBird)){
                return true;
            }
        }
        throw new IllegalArgumentException("All aviaries are at capacity, sorry for the inconvenience");

    }
    /*Search for a specific bird in the 20 aviaries, once found would return the location where it was last found
    * as a string to inform users*/

    public String lookUpBird(Enum birdName){
        int indexOfAviary = -1;
        String aviaryLocation = "Null";
        for (Aviary a: getAviaryList()){
            if (a.getAviarySize() != 0){
                for( Birds b: a.getBirdList()){
                    if (b.getTypeName() == birdName){   // compare if the input enum matches
                        indexOfAviary = a.getAviaryIndex();
                        aviaryLocation = a.getAviaryLocation();
                    }
                }
            }
        }
        if (indexOfAviary == -1){
            return "The Bird you are looking for is not in our conservatory, sorry";
        } else {
            return "The Bird you are looking for is in number " + indexOfAviary + " in " + aviaryLocation;
        }
    }

    /*Would print out the birds and characteristics of birds in specific aviary as a String (Sign)
    * would inform user there is no birds if the aviary given is empty*/
    public String printCharacteristicSign(Aviary avy){
        String sign = "";
        if (avy.getAviarySize() <=  0){
            return "There is no birds in this aviary";
        }
        for (Birds b: avy.getBirdList()){
            sign += b.toString();  //
        }
        return sign;
    }

    /*This function prints out the map of all aviaries in the conservatories, it not only includes the string
    * name of the aviary but also the series number of the aviary. Starting form 0-19. Its output would be a
    * String */
    public String printMap(){
        String map = "";
        if (getAviaryList().size() < 1){
            return "There is aviary in this conservatory";
        }
        for (Aviary a: getAviaryList()){
            map += String.format("Location of aviary: %s \n",a.getAviaryLocation());
            for (Birds b: a.getBirdList()){
                map += String.format("%e \n", b.getTypeName().name());
            }
            map += "are the birds in this aviary";
        }
        return map;
    }

    /*This function calls the BirdLocPair class and iterate through each aviary in the conservatory and sorts
    * through the arrayList by using the birds name as a comparator. Eventually we will return the concatenated
    * string to output the index*/
    public String printIndex() {
        ArrayList<BirdLocPair> allBirds = new ArrayList<BirdLocPair>();
        for (Aviary aviary : getAviaryList()) {
            for (Birds bird : aviary.getBirdList()) {
                allBirds.add(new BirdLocPair(bird, aviary.getAviaryLocation()));
            }
        }

        Comparator<BirdLocPair> compareByName = (BirdLocPair b1, BirdLocPair b2) ->
                b1.getBird().getTypeName().name().compareTo(b2.getBird().getTypeName().name());  //need to compare enum
        Collections.sort(allBirds, compareByName);
        String returnString = "";

        for (BirdLocPair birdLocPair : allBirds) {
                returnString += String.format("Bird Name=%s, Bird Type=%s, Location = %s\n", birdLocPair.getBird().getTypeName().name()
                        , birdLocPair.getBird().getTypeName().name(), birdLocPair.getLocation());
        }
        return returnString;
    }
}


