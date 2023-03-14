package Birds;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static Birds.FoodType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConservatoryTest {
    private Conservatory conservatory;

    @BeforeEach
    public void setUp() {
        Map<FoodType, Integer> foodMap = new HashMap<>();
        foodMap.put(FoodType.INSECTS, 10);
        foodMap.put(FoodType.FISH, 20);
        foodMap.put(FoodType.SEEDS, 30);
        conservatory = new Conservatory(foodMap);
    }

    @Test
    public void testAddAviaries() {
        assertThrows(IllegalStateException.class, () -> {
            for (int i = 0; i < 21; i++) {
                conservatory.AddAviaries(new Aviary("test", i));
            }
        });
    }

    @Test
    public void testRescueBird() {
        ArrayList<String> characteristics = new ArrayList<>();
        characteristics.add("webbed feet");
        characteristics.add("live near water");
        ArrayList<FoodType> foodList = new ArrayList<>();
        foodList.add(EGGS);
        foodList.add(BUDS);
        Birds bird = new Watefowl(BirdsType.DUCK, characteristics, false, 2, foodList, "lake");
        boolean result = conservatory.rescueBird(bird);
        assertEquals(true, result);
    }

    @Test
    public void testRescueExtinctBird() {          // this would throw exception in rescueFunction
                                                    //if the bird is extinct
        ArrayList<String> characteristics = new ArrayList<>();
        characteristics.add("webbed feet");
        characteristics.add("live near water");
        ArrayList<FoodType> foodList = new ArrayList<>();
        foodList.add(EGGS);
        foodList.add(BUDS);
        Birds bird = new Watefowl(BirdsType.DUCK, characteristics, true, 2, foodList, "lake");
        assertThrows(IllegalArgumentException.class, () -> {
            conservatory.rescueBird(bird);
        });
    }

    @Test
    public void testLookUpBird() {
        ArrayList<String> characteristics = new ArrayList<>();
        characteristics.add("webbed feet");
        characteristics.add("live near water");
        ArrayList<FoodType> foodList = new ArrayList<>();
        foodList.add(EGGS);
        foodList.add(BUDS);
        Birds bird = new Watefowl(BirdsType.DUCK, characteristics, false, 2, foodList, "lake");
        conservatory.rescueBird(bird);
        String result = conservatory.lookUpBird(BirdsType.DUCK);
        assertEquals("The Bird you are looking for is in number 1 in Shanghai", result);
    }

    @Test
    public void testPrintCharacteristicSign() {
        Aviary aviary = new Aviary("test", 1);
        ArrayList<String> characteristics = new ArrayList<>();
        characteristics.add("webbed feet");
        characteristics.add("live near water");
        ArrayList<FoodType> foodList = new ArrayList<>();
        foodList.add(EGGS);
        foodList.add(BUDS);
        Birds bird = new Watefowl(BirdsType.DUCK, characteristics, false, 2, foodList, "lake");
        aviary.AddBird(bird);
        String result = conservatory.printCharacteristicSign(aviary);
        String expected = "This bird is called DUCK and it has 2 number of wings. They are know to be:[webbed feet, live near water]";
        assertEquals(expected, result);
    }


    @Test
    public void testPrintIndex() {
        Aviary aviary1 = new Aviary("Shanghai", 1);
        Aviary aviary2 = new Aviary("SuZhou", 2);
        ArrayList<String> characteristics = new ArrayList<>();
        characteristics.add("webbed feet");
        characteristics.add("live near water");
        ArrayList<FoodType> foodList = new ArrayList<>();
        foodList.add(EGGS);
        foodList.add(BUDS);
        Birds bird1 = new Watefowl(BirdsType.DUCK, characteristics, false, 2, foodList, "lake");
        ArrayList<String> characteristics1 = new ArrayList<>();
        characteristics1.add("webbed feet");
        characteristics1.add("live near water");
        ArrayList<FoodType> foodList2 = new ArrayList<>();
        foodList2.add(NUTS);
        foodList2.add(VEGETATION);
        Birds bird2 = new FlightlessBirds(BirdsType.KIWIS, characteristics1, false, 0, foodList2);
        aviary1.AddBird(bird1);
        aviary2.AddBird(bird2);
        conservatory.getAviaryList().add(aviary1);
        conservatory.getAviaryList().add(aviary2);
        String result = conservatory.printIndex();
        assertEquals("Bird Name=DUCK, Bird Type=DUCK, Location = Shanghai\n" +
                "Bird Name=KIWIS, Bird Type=KIWIS, Location = SuZhou\n", result);
    }
}
