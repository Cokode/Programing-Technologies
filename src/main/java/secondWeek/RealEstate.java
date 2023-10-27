package secondWeek;

import secondWeek.Genre.Genre;
import secondWeek.interfaces.PropertyInterface;
public class RealEstate implements PropertyInterface,
        Comparable<RealEstate> {
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

    @Override
    public String toString() {
        String forma = "\nREAL ESTATE\nCity => %s\nPrice => %d\nSquare meter => %d" +
                "\nNumber of rooms => %d\nGenre => %s\nTotal Price => %d\nAverage sqm per room => %d\n";
        return String.format(forma,
                city,
                price,
                sqm,
                numberOfRooms,
                genre,
                totalPrice(),
                average());
    }

    @Override
    public void discount(int discountPercentage) {
        double percentage = (discountPercentage * 0.01);
        price -= ((double) price - percentage);
    }

    @Override
    public long totalPrice() {
        long pricePerSqm = ((long) this.price * sqm);

        if (this.city.equalsIgnoreCase("Nyiregyhaza")) {
            pricePerSqm = (long) (pricePerSqm + (0.15 * pricePerSqm));
        } else if (this.city.equalsIgnoreCase("Debrecen")) {
            pricePerSqm = (long) (pricePerSqm + (0.2 * pricePerSqm));
        } else if (this.city.equalsIgnoreCase("Budapest")) {
            pricePerSqm = (long) (pricePerSqm + (0.3 * pricePerSqm));
        }
        return pricePerSqm;
    }

    @Override
    public int average () {
        if(numberOfRooms < 1.0) numberOfRooms = 1;
        return sqm / numberOfRooms;
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

    @Override
    public int compareTo(RealEstate o) {
        return Double.compare(this.totalPrice(), o.totalPrice());
    }
}
