package transmission;

import org.junit.function.ThrowingRunnable;

import static org.junit.Assert.*;

public class AutomaticTransmissionTest {

    @org.junit.Test
    public void getSpeed() {
        AutomaticTransmission a = new AutomaticTransmission(10,20,30,40,50);
        a.increaseSpeed().increaseSpeed().increaseSpeed().increaseSpeed();
        assertEquals(8, a.getSpeed());
    }

    @org.junit.Test
    public void getGear() {
        AutomaticTransmission a = new AutomaticTransmission(10,20,30,40,50);
        a.increaseSpeed().increaseSpeed().increaseSpeed().increaseSpeed().increaseSpeed().increaseSpeed();
        assertEquals(2,a.getGear());
    }

    @org.junit.Test
    public void increaseSpeed() {
        AutomaticTransmission a = new AutomaticTransmission(10,20,30,40,50);
        assertNotNull(a.increaseSpeed());  //assure increaseSpeed() returns a object
    }

    @org.junit.Test
    public void decreaseSpeed() {
        AutomaticTransmission a = new AutomaticTransmission(10,20,30,40,50);
        a.increaseSpeed().increaseSpeed();

        assertThrows(IllegalStateException.class, () -> {
            a.decreaseSpeed().decreaseSpeed().decreaseSpeed().decreaseSpeed();
        });
    }

    @org.junit.Test
    public void testToString() {
    }
}