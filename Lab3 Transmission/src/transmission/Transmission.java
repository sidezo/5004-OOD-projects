package transmission;

public interface Transmission {
    int getSpeed();

    int getGear();
    Transmission increaseSpeed();

    Transmission decreaseSpeed();



    String toString();

}
