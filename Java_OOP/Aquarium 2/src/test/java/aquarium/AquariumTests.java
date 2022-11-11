package aquarium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class AquariumTests {
    @Test(expected = NullPointerException.class)
    public void setName_nullName_expectedNullPointerException() {
        new Aquarium(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void setName_blankName_expectedNullPointerException() {
        new Aquarium("  ", 10);
    }

    @Test
    public void setName_nameIsNonBlank_expectedNameSetSuccessfully() {
        String expectedName = "Aquarium One";

        Aquarium aquarium = new Aquarium(expectedName, 10);

        assertEquals(expectedName, aquarium.getName());
    }

    @Test
    public void getCapacity_capacityTen_expectedCapacityIsTen() {
        int capacity = 10;

        Aquarium aquarium = new Aquarium("Test Name", capacity);

        assertEquals(capacity, aquarium.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setCapacity_negativeCapacity_expectedIllegalArgumentException() {
        new Aquarium("Test Name", -1);
    }

    @Test
    public void getCount_singleFishAdded_expectedCountOne() {
        Aquarium aquarium = new Aquarium("Test Name", 10);
        aquarium.add(new Fish("Test Fish"));

        int result = aquarium.getCount();

        assertEquals(1, result);
    }

    @Test
    public void getCount_noFishAdded_expectedCountZero(){
        Aquarium aquarium = new Aquarium("Test Name", 10);

        int result = aquarium.getCount();

        assertEquals(0, result);
    }

    @Test
    public void add_haveFreeSpace_expectedFishAddedToAquarium() {
        Aquarium aquarium = new Aquarium("Test Name", 10);
        Fish fish = new Fish("Test Fish");

        aquarium.add(fish);

        assertEquals(1, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void add_noFreeSpace_expectedIllegalArgumentException() {
        Aquarium aquarium = new Aquarium("Test Name", 0);

        aquarium.add(new Fish("Test Fish"));
    }

    @Test
    public void remove_fishExistsInAquarium_expectedFishSuccessfullyRemoved() {
        Aquarium aquarium = new Aquarium("Test Aquarium", 10);
        Fish fish = new Fish("Test Fish");
        aquarium.add(fish);

        aquarium.remove("Test Fish");

        assertEquals(0, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void remove_fishDoesNotExistInAquarium_expectedIllegalArgumentException() {
        Aquarium aquarium = new Aquarium("Test Aquarium", 10);

        aquarium.remove("Non-existent Fish");
    }

    @Test
    public void sellFish_fishExistsInAquarium_expectedFishNotAvailable() {
        Aquarium aquarium = new Aquarium("Test Aquarium", 10);
        Fish fish = new Fish("Test Fish");
        aquarium.add(fish);

        aquarium.sellFish("Test Fish");

        assertFalse(fish.isAvailable());
    }

    @Test(expected = IllegalArgumentException.class)
    public void sellFish_fishDoesNotExistInAquarium_expectedIllegalArgumentException() {
        Aquarium aquarium = new Aquarium("Test Aquarium", 10);

        aquarium.sellFish("Non-existent Fish");
    }

    @Test
    public void report_zeroFishInTheAquarium_expectedEmptyReport() {
        String aquariumName = "TestAquarium";
        String expectedReport = "Fish available at " + aquariumName + ": ";
        Aquarium aquarium = new Aquarium(aquariumName, 10);

        String actualReport = aquarium.report();

        assertEquals(expectedReport, actualReport);
    }

    @Test
    public void report_singleFishInTheAquarium_expectedOneFishNameInTheReport() {
        String aquariumName = "TestAquarium";
        String fishName = "TestFish";
        String expectedReport = "Fish available at " + aquariumName + ": " + fishName;
        Aquarium aquarium = new Aquarium(aquariumName, 10);
        Fish fish = new Fish(fishName);
        aquarium.add(fish);

        String actualReport = aquarium.report();

        assertEquals(expectedReport, actualReport);
    }

    @Test
    public void report_multipleFishInTheAquarium_expectedMultipleFishNamesInTheReport() {
        String aquariumName = "TestAquarium";
        String fishName1 = "TestFish1";
        String fishName2 = "TestFish2";
        String expectedReport = "Fish available at " + aquariumName + ": " + fishName1 + ", " + fishName2;
        Aquarium aquarium = new Aquarium(aquariumName, 10);
        Fish fish1 = new Fish(fishName1);
        Fish fish2 = new Fish(fishName2);
        aquarium.add(fish1);
        aquarium.add(fish2);

        String actualReport = aquarium.report();

        assertEquals(expectedReport, actualReport);
    }
}

