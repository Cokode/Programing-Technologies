import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import secondWeek.Genre.Genre;
import secondWeek.Panel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PanelTest {
    Panel underTest = new Panel("Debrecen",
           19000, 112, 5,
          Genre.FAMILYHOUSE, 3, true);

    Panel toNull;

    @Test
    @BeforeEach
    public void setUp() {
        assertNotNull("object should not be null", underTest);
        /**
         * Learning why this anotation failed.
         * the underText was instantiated in this method and should be
         * runed before each test, but it returned  a NullPointerException
         * reasons: underTest is null
         **/
    }

    @Test
    @Timeout(10)
    public void roomPrice () {
        double actual = underTest.roomPrice();
        double expected = 425600.00;
        assertEquals("maximum difference should not be more than 0.05", expected, actual, 0.05);
    }

    @Test
    @DisplayName("This is the test for totalPrice Method for Panel.")
    public void totalPriceOfARealEstate () {
        long actual = underTest.totalPrice();
        long expected = 2234400;
        assertEquals(expected, actual);
    }
}
