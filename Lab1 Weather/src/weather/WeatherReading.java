package weather;

public class WeatherReading {
    private int temperature;
    private int dewPoint;
    private int windSpeed;
    private int totalRain;

    public WeatherReading(int temperature, int dewPoint, int windSpeed, int totalRain) {
        this.temperature = temperature;
        this.dewPoint = dewPoint;                   // this refers to instance itself
        this.windSpeed = windSpeed;
        this.totalRain = totalRain;
    }

    public int getTemperature() {

        return temperature;    // the same as this.temperature
                                // this. in java refers to object (instance) the object was called on
    }

    public int getDewPoint() {

        return dewPoint;
    }

    public int getWindSpeed() {

        return windSpeed;
    }

    public int getTotalRain() {

        return totalRain;
    }

    public int getRelativeHumidity() {
        int T = getTemperature();     //apply getter function
        int D = getDewPoint();
        return 100 - 5 * T + 5 * D;  // directly returning relative humidity
    }

    public double getHeatIndex() {
        int RE = getRelativeHumidity();
        int T = getTemperature();
        double C1 = -8.78469475556;
        double C2 = 1.61139411;
        double C3 = 2.33854883889;
        double C4 = -0.14611605;
        double C5 = -0.012308094;
        double C6 = -0.0164248277778;
        double C7 = 0.002211732;
        double C8 = 0.00072546;
        double C9 = -0.000003582;

        double heatIndex = C1 + C2 * T + C3 * RE + C4 * T * RE + C5 * T * T +
                C6 * RE * RE + C7 * T * T * RE + C8 * T * RE * RE + C9 * T * T * RE * RE ;

        return heatIndex;
    }

    public double getWindChill() {
        int T = getTemperature();   // in celsius
        int S = getWindSpeed();
        double TF = T * 1.8 + 32;
        double WC = 35.74 + 0.6215 * TF - 35.75 * Math.pow(S, 0.16) + 0.4275 * TF * Math.pow(S, 0.16);
        return WC;
    }
    public String toString() {
        return "Reading: T = " + this.temperature + ", " + "D = " + this.dewPoint + ", " + "v = " + this.windSpeed + ", " + "rain = " + this.totalRain;
    }
}
