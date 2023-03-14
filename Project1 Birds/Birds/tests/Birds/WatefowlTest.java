package Birds;

import Birds.BirdsType;
import Birds.FoodType;
import Birds.Watefowl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WatefowlTest {
    @Test
    public void testWatefowlConstructor() {
        BirdsType type = BirdsType.DUCK;
        ArrayList<String> characteristics = new ArrayList<>();
        characteristics.add("webbed feet");
        characteristics.add("live near water");
        Boolean isExtinct = false;
        int wingNum = 2;
        ArrayList<FoodType> foodList = new ArrayList<>();
        foodList.add(FoodType.INSECTS);
        String waterBody = "lake";

        Watefowl watefowl = new Watefowl(type, characteristics, isExtinct, wingNum, foodList, waterBody);

        assertEquals(type, watefowl.getTypeName());
        assertEquals(characteristics, watefowl.getCharacteristic());
        assertEquals(isExtinct, watefowl.getIsExtinct());
        assertEquals(wingNum, watefowl.getNumOfWings());
        assertEquals(foodList, watefowl.getFoodList());
        assertEquals(waterBody, watefowl.getWaterBody());    // specific to waterbirds
    }
}





