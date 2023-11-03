package secondWeek;

/**
 * This Panel class extends the RealEstate Class and implements the Panel Interface.
 *
 * It includes two additional properties: an integer field 'floor' and a boolean 'isInsulated'.
 * The property type influences the price.
 */


import secondWeek.Genre.Genre;
import secondWeek.interfaces.PanelInterface;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Panel extends RealEstate implements PanelInterface {
    private static final Logger LOGGER = Logger.getLogger(Panel.class.getName());

    int floor;
    boolean isInsulated;

    public Panel(String city,
                 int price,
                 int sqm,
                 int numberOfRooms,
                 Genre genre,
                 int floor,
                 boolean isInsulated) {
        super(city, price, sqm, numberOfRooms, genre);
        this.floor = floor;
        this.isInsulated = isInsulated;
    }

    @Override
    public boolean hasSameAmount() { // Not yet implemented because instruction not understood.
        return false;
    }

    /**
     * This method calculates and returns the cost of a room in real estate.
     *
     * @return The cost of the room as a decimal number.
     */

    @Override
    public double roomPrice() {
        LOGGER.info("Calling roomPrice method for Panel class\n");

        return ((double) price * sqm) / numberOfRooms;
    }

    /**
     * Calculates the total price of the property.
     * If the property is insulated, a 5% increase is applied.
     * Additionally, there's a 5% increase for properties on and below the 2nd floor,
     * and a 5% decrease for properties on the 10th floor or above.
     *
     * @return the total cost of the property after all adjustments.
     */

    @Override
    public long totalPrice() {
        LOGGER.info("Calling totalPrice of Panel class Method\n");

        long total = (long) price * sqm;
        double forInsulated = (0.05 *  total);

        try {
            if (isInsulated) total += forInsulated;

            if (floor <= 2) {
                total += forInsulated;
            } else if (floor >= 10) {
                total -= forInsulated;
            }
        } catch (Exception exception) {
            LOGGER.log(Level.WARNING, "Problem with arithmetic ", exception);
        }
        return total;
    }


    /**
     * This method provides complete information about a Panel real estate.
     * @return All the details of the real estate.
     */

    @Override
    public String toString() {
        LOGGER.info("Calling toString method for Panel class\n");

        String forma
                = "\nPANEL\nFloor => %d\nIsInsulated => %b\nCity => %s\nPrice => %d\nSquare meter => %d\nNumber of rooms => %d\nGenre => %s\nTotal Price => %d\nAverage sqm per room => %d\n";

        return String.format(forma,
                floor,
                isInsulated,
                city,
                price,
                sqm,
                numberOfRooms,
                genre,
                totalPrice(),
                average()
        );
    }

    public int getFloor() {
        return floor;
    }

    public boolean isInsulated() {
        return isInsulated;
    }
}
