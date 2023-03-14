package transmission;

public class AutomaticTransmission implements Transmission{
    private int curSpeed = 0;          //current speed of transmission

    private int curGear = 0;
    final private int gearThreshold1;
    final private int gearThreshold2;
    final private int gearThreshold3;
    final private int gearThreshold4;
    final private int gearThreshold5;


    public AutomaticTransmission(int gearThreshold1, int gearThreshold2, int gearThreshold3,
                                 int gearThreshold4, int gearThreshold5){
        if (gearThreshold1 > 0){
            this.gearThreshold1 = gearThreshold1;
        } else {
            throw new IllegalArgumentException("Gear threshold 1 should be larger than 0");
        }
        if (gearThreshold2 > gearThreshold1){
            this.gearThreshold2 = gearThreshold2;
        } else {
            throw new IllegalArgumentException("Gear threshold 2 should be larger than gear threshold 1");
        }
        if (gearThreshold3 > gearThreshold2){
            this.gearThreshold3 = gearThreshold3;
        } else {
            throw new IllegalArgumentException("Gear threshold 3 should be larger than gear threshold 2");
        }
        if (gearThreshold4 > gearThreshold3){
            this.gearThreshold4 = gearThreshold4;
        } else {
            throw new IllegalArgumentException("Gear threshold 4 should be larger than gear threshold 3");
        }
        if (gearThreshold5 > gearThreshold4){
            this.gearThreshold5 = gearThreshold5;
        } else {
            throw new IllegalArgumentException("Gear threshold 5 should be larger than gear threshold 4");
        }

    }


    @Override
    public int getSpeed() {
        return this.curSpeed;
    }

    @Override
    public int getGear() {
        return this.curGear;
    }
//    public int setCurSpeed(int newSpeed){
//        this.curSpeed = newSpeed;
//        return curSpeed;
//    }

    @Override
    public Transmission increaseSpeed() {
        this.curSpeed += 2;
        if (this.curSpeed == 0 ){
            this.curGear = 0;
        }else if (this.curSpeed < gearThreshold1){      // we can redefine the snipple below as new function
            this.curGear = 1;
        } else if (this.curSpeed < gearThreshold2){
            this.curGear = 2;
        } else if (this.curSpeed < gearThreshold3){
            this.curGear = 3;
        } else if (this.curSpeed < gearThreshold4){
            this.curGear = 4;
        } else if (this.curSpeed < gearThreshold5){
            this.curGear = 5;
        } else {
            this.curGear = 6;
        }
        return this;    // returning the Transmission object (Can be AutomaticTransmission)

//        AutomaticTransmission box = new AutomaticTransmission(gearThreshold1, gearThreshold2,
//                gearThreshold3, gearThreshold4, gearThreshold5);
//        int newSpeed = this.curSpeed + 2;
//        box.setCurSpeed(newSpeed);
//        return box;
    }

    @Override
    public Transmission decreaseSpeed() {
        this.curSpeed -= 2;
        if(this.curSpeed < 0){
            throw new IllegalStateException("Vehicles cannot have negative speed!");
        } else if (this.curSpeed == 0){
            this.curGear = 0;
        }  else if (this.curSpeed < gearThreshold1){
            this.curGear = 1;
        } else if (this.curSpeed < gearThreshold2){
            this.curGear = 2;
        } else if (this.curSpeed < gearThreshold3){
            this.curGear = 3;
        } else if (this.curSpeed < gearThreshold4){
            this.curGear = 4;
        } else if (this.curSpeed < gearThreshold5){
            this.curGear = 5;
        } else {
            this.curGear = 6;
        }


        return this;

    }

    @Override
    public String toString(){
        return "Transmission (speed = "+ curSpeed +", gear = " + curGear +")";
    }

}
