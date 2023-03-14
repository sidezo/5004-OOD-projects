package Birds;

import java.util.ArrayList;

public class Aviary {

    final private String aviaryLocation;
    final private int aviaryIndex;

    private ArrayList<Birds>  birdList = new  ArrayList<Birds>();
                                        //calling arrayList constructor ot create empty
                                        //array list of Birds object

    /*Constructor for aviary class that takes aviaryIndex and aviaryLocation as input*/
    public Aviary(String aviaryLocation, int aviaryIndex) {
        this.aviaryLocation = aviaryLocation;
        this.aviaryIndex = aviaryIndex;
    }
    /*getter function for the size of ListArray containing birds*/
    public int getAviarySize() {
        return this.birdList.size();
    }
    /*getter function for BirdsArray*/
    public ArrayList<Birds> getBirdList(){
        return birdList;
    }
    /*getter function for specific aviary*/
    public int getAviaryIndex() {
        return aviaryIndex;
    }
    /*getter function for AviaryLocation*/
    public String getAviaryLocation() {
        return aviaryLocation;
    }
    /*This function is called  in observatory class in every iteration to see whether a bird can be
    * added to observatory, will first check if aviary is full and then separate bids of prey, watefowl birds and
    * flightless birds*/
    public boolean AddBird(Birds b){//// since public should be careful,
        boolean addIsDone = true;
        boolean addIsNotDone = false;

        if(this.birdList.size() > 5){   //no aviary can house more than 5 birds
            return addIsNotDone;
        }

        if(this.birdList.size() == 0){
            birdList.add(b);
            return addIsDone;
        }
        if (b instanceof FlightlessBirds || b instanceof Watefowl || b instanceof BirdsOfPrey){
            if (b.getClass() == birdList.get(0).getClass()){     //getClass would get concrete class at runtime due to polymorphism
                birdList.add(b);                        //want to check first element in birdList
                return addIsDone;
            }
        } else {
            if (!(birdList.get(0) instanceof FlightlessBirds) &&!(birdList.get(0) instanceof Watefowl)
            && !(birdList.get(0) instanceof BirdsOfPrey) ){
                birdList.add(b);
            }
            return addIsNotDone;
        }
        return addIsDone;
    }
}
