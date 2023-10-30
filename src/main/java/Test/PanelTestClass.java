package Test;

import org.junit.Test;
import secondWeek.Genre.Genre;
import secondWeek.Panel;

import static org.junit.Assert.assertEquals;

public class PanelTestClass {

    Panel undertest = new Panel("Debrecen",
            19000, 112, 5,
            Genre.FAMILYHOUSE, 3, true);

    @Test
    public void roomPrice () {
        double actual = undertest.roomPrice();
        double expected = 425600.00;
        assertEquals("maximum difference should not be more than 0.05", expected, actual, 0.05);
    }

    @Test
    public void totalPriceOfARealEstate () { // This is the test for totalprice for Panel.
        long actual = undertest.totalPrice();
        long expected = 2234400;
        assertEquals(expected, actual);
    }
}
