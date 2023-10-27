package Test;
import jdk.jfr.StackTrace;
import org.junit.Test;
import secondWeek.Genre.Genre;
import secondWeek.Panel;
import secondWeek.RealEstate;

import static org.junit.Assert.assertEquals;

public class RealEstateTest {
    private RealEstate underTest = new RealEstate("Budapest",
            8500, 224, 4, Genre.CONDOMINIUM);

    @Test
    public void totalRoomPrice() { // This i text for method totalPrice
       long actual = underTest.totalPrice();
       long expected = 2475200;
       assertEquals(expected, actual);
    }

    public void showDiscount () {

    }


}