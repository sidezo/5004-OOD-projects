import weather.WeatherReading;

import static org.junit.Assert.*;

public class WeatherReadingTest {

    @org.junit.Test
    public void getTemperature() {
        WeatherReading A = new WeatherReading(27,19,3,20);
        assertEquals(27, A.getTemperature());
    }

    @org.junit.Test
    public void getDewPoint() {
        WeatherReading A = new WeatherReading(27,15,3,20);
        assertEquals(15, A.getDewPoint());
    }

    @org.junit.Test
    public void getWindSpeed() {
        WeatherReading A = new WeatherReading(27,15,3,20);
        assertEquals(3, A.getWindSpeed());
    }

    @org.junit.Test
    public void getTotalRain() {
        WeatherReading A = new WeatherReading(27,15,3,20);
        assertEquals(20, A.getTotalRain());
    }

    @org.junit.Test
    public void getRelativeHumidity() {
        WeatherReading A = new WeatherReading(27,15,3,20);
        assertEquals(40, A.getRelativeHumidity());
    }

    @org.junit.Test
    public void getHeatIndex() {
        double delta = 0.1;     //provides heat index tolerance
        WeatherReading A = new WeatherReading(27,15,3,20);
        assertEquals(26.9, A.getHeatIndex(),delta);
    }

    @org.junit.Test
    public void getWindChill() {
        double delta = 0.1;     //provides windchill tolerance
        WeatherReading A = new WeatherReading(27,15,3,20);
        assertEquals(84.29, A.getWindChill(),delta);
    }

    @org.junit.Test
    public void testToString() {
        WeatherReading A = new WeatherReading(27,15,3,10);
        assertEquals("Reading: T = 27, D = 15, v = 3, rain = 10", A.toString());
    }
}