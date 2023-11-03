import org.junit.Test;
import secondWeek.Genre.Genre;
import secondWeek.RealEstate;

import static org.junit.Assert.assertEquals;

public class RealEstateTest {

    private RealEstate underTest = new RealEstate("Budapest",
            8500, 224, 4, Genre.CONDOMINIUM);


    @Test
    public void totalRoomPrice() {
        long actual = underTest.totalPrice();
        long expected = 2475200;
        assertEquals(expected, actual);
    }

    @Test
    public void averageSqmPerRoom () {
        int actual = underTest.average();
        int expected = 56;
        assertEquals(expected, actual);
    }
}
