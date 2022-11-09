package archeologicalExcavations;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExcavationTests {
    private static final String NAME = "Sample Name";
    private static final int CAPACITY = 10;
    private Excavation excavation;

    @Before
    public void setUp() throws Exception {
        excavation = new Excavation(NAME, CAPACITY);
    }

    @Test
    public void getCount_emptyArcheologistCollection_expectedZero() {
        Archaeologist archaeologist = new Archaeologist("John Doe", 10);
        excavation.addArchaeologist(archaeologist);

        int result = excavation.getCount();

        assertEquals(1, result);
    }

    @Test
    public void getName_sampleName_expectedSampleName() {
        String result = excavation.getName();

        assertEquals(NAME, result);
    }

    @Test
    public void getCapacity_createdWithCapacityTen_expectedTen() {
        int result = excavation.getCapacity();

        assertEquals(CAPACITY, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addArchaeologist_capacityIsFull_expectedIllegalArgumentException() {
        Excavation zeroCapacityExcavation = new Excavation(NAME, 0);
        Archaeologist archaeologist = new Archaeologist("John Doe", 10);

        zeroCapacityExcavation.addArchaeologist(archaeologist);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addArchaeologist_archeologistAlreadyPresent_expectedIllegalArgumentException() {
        Archaeologist archaeologist = new Archaeologist("John Doe", 10);
        excavation.addArchaeologist(archaeologist);

        excavation.addArchaeologist(archaeologist);
    }

    @Test
    public void removeArcheologist_archeologistNotPresent_expectedFalse() {
        String name = "John Doe";
        Archaeologist archaeologist = new Archaeologist(name, 10);

        boolean result = excavation.removeArchaeologist(name);

        assertFalse(result);
    }

    @Test
    public void removeArcheologist_archeologistPresent_expectedTrue() {
        String name = "John Doe";
        Archaeologist archaeologist = new Archaeologist(name, 10);
        excavation.addArchaeologist(archaeologist);

        boolean result = excavation.removeArchaeologist(name);

        assertTrue(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setCapacity_negativeCapacityProvided_expectedIllegalArgumentException() {
        new Excavation(NAME, -1);
    }

    @Test(expected = NullPointerException.class)
    public void setName_nameIsNull_expectedNullPointerException() {
        new Excavation(null, CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void setName_nameIsBlank_expectedNullPointerException() {
        new Excavation("   ", CAPACITY);
    }
}
