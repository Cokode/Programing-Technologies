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
    public long roomPrice() {
        return ((long) this.price * sqm) / numberOfRooms;
    }

    @Override
    public long totalPrice() {
        long total = (long) this.price * sqm;
        long isInsulated = (long) (((0.1) * 5) * (total / 10));
        if (this.isInsulated) total += isInsulated;

        if (floor <= 2) {
            return total + isInsulated;
        } else if (floor >= 10) {
            return total - isInsulated;
        }
        return total;
    }

    @Override
    public String toString() {
        String forma = "\nPANEL\nFloor => %d\nIsInsulated => %b\nCity => %s\nPrice => %d\nSquare meter => %d\nNumber of rooms => %d\nGenre => %s\nTotal Price => %d\nAverage sqm per room => %d\n";

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
