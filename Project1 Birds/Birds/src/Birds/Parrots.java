package Birds;

import java.util.ArrayList;

public class Parrots extends BirdsParent {

    private final String favSaying;
    private final int vocabNum;

    public Parrots(BirdsType type, ArrayList<String> characteristics,
                   Boolean isExtinct, int wingNum, ArrayList<FoodType> foodList, String favSaying, int vocabNum ) {
        super(type, characteristics, isExtinct, wingNum, foodList);
        this.favSaying = favSaying;
        this.vocabNum = vocabNum;
    }

    public String getFavSong() {   //getter function for parrot's favorite song
        return this.favSaying;
    }

    public int getVocabNum() {  //getter function for parrot's vocab number
        return this.vocabNum;
    }
}
