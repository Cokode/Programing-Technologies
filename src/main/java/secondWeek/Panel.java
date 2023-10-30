package secondWeek;

import secondWeek.Genre.Genre;
import secondWeek.interfaces.PanelInterface;

public class Panel extends RealEstate implements PanelInterface {
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

    @Override
    public double roomPrice() {
        return ((double) price * sqm) / numberOfRooms;
    }

    @Override
    public long totalPrice() {
        long total = (long) price * sqm;
        double forInsulated = (0.05 *  total);

        if (isInsulated) total += forInsulated;

        if (floor <= 2) {
            total += forInsulated;
        } else if (floor >= 10) {
            total -= forInsulated;
        }
        return total;
    }

    @Override
    public String toString() {
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
                average());
    }

    public int getFloor() {
        return floor;
    }

    public boolean isInsulated() {
        return isInsulated;
    }
}
