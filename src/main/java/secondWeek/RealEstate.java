package secondWeek;

import secondWeek.Genre.Genre;
import secondWeek.interfaces.PropertyInterface;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class RealEstate implements PropertyInterface,
        Comparable<RealEstate> {
    private static final Logger LOGGER = Logger.getLogger(RealEstate.class.getName());

    String city;
    int price;
    int sqm;
    int numberOfRooms;
    Genre genre;

    public RealEstate(String city,
                      int price,
                      int sqm,
                      int numberOfRooms,
                      Genre genre) {
        this.city = city;
        this.price = price;
        this.sqm = sqm;
        this.numberOfRooms = numberOfRooms;
        this.genre = genre;
    }

    public RealEstate (){
        /**
         * This constructor initializes fields manually without any parameters.
         */
    }

    /**
     * Applies a discount to the property price per square meter.
     *
     * @param discountPercentage An integer specifying the discount percentage to be applied.
     */

    @Override
    public void discount(int discountPercentage) {
        LOGGER.info("Calling discount() method\"");

        double percentage = (discountPercentage * 0.01);
        price -= ((double) price - percentage);
    }

    /**
     * Calculates the total price of a real estate property.
     *
     * This method computes and returns an integer representing the total price of the property,
     * based on the given price and square meter fields. The final price is affected by the city location:
     * 30% more if the property is in Budapest, 20% more if in Debrecen, and 15% more if in Nyíregyháza,
     * in addition to the calculated value.
     *
     * @return The total value of the property as a long.
     */


    @Override
    public long totalPrice() {
        LOGGER.info("Calling totalPrice() method\n");

        long pricePerSqm = ((long) this.price * sqm);

        try {

            if (this.city.equalsIgnoreCase("Nyiregyhaza")) {
                pricePerSqm = (long) (pricePerSqm + (0.15 * pricePerSqm));
            } else if (this.city.equalsIgnoreCase("Debrecen")) {
                pricePerSqm = (long) (pricePerSqm + (0.2 * pricePerSqm));
            } else if (this.city.equalsIgnoreCase("Budapest")) {
                pricePerSqm = (long) (pricePerSqm + (0.3 * pricePerSqm));
            }
        } catch (Exception exception) {
            LOGGER.log(Level.WARNING, "Check for Arithmetic errors ", exception);
        }

        return pricePerSqm;
    }

    /**
     * Calculates and returns the average area in square meters of a room.
     * @return The average area of a room in square meters.
     */

    @Override
    public int average () {
        LOGGER.info("Calling average() method\n");

            try {
                if(numberOfRooms < 1.0) numberOfRooms = 1;
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, "type error", e);
            }

        return sqm / numberOfRooms;
    }

    /**
     * Records logs for all classes and methods in the 'LogMessages.log' file.
     * This includes messages for each call, warnings, and exceptions.
     */
    public static void logInfo() {
        FileHandler fileHandler;

        try {
            fileHandler =
                    new FileHandler("/Volumes/PASSWORD/allthingstogether/Programinig" +
                            " Technologies/LogMessages.log");
            LOGGER.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            LOGGER.info("Logger initialized");
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Exception ::", e);
        }
    }

    /**
     * This method provides complete information about a real estate.
     * @return All the details of the real estate.
     */

    @Override
    public String toString() {
        LOGGER.info("Calling toString() method\"");

        String forma = "\nREAL ESTATE\nCity => %s\nPrice => %d\nSquare meter => %d" +
                "\nNumber of rooms => %d\nGenre => %s\nTotal Price => %d\nAverage sqm per room => %d\n";

        return String.format(forma,
                city,
                price,
                sqm,
                numberOfRooms,
                genre,
                totalPrice(),
                average()
        );
    }

    public String getCity() {
        return city;
    }

    public double getPrice() {
        return price;
    }

    public int getSqm() {
        return sqm;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSqm(int sqm) {
        this.sqm = sqm;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public int compareTo(RealEstate o) {
        return Double.compare(this.totalPrice(), o.totalPrice());
    }

}
