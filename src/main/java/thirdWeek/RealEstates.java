package thirdWeek;

import secondWeek.Genre.Genre;
import secondWeek.Panel;
import secondWeek.RealEstate;

import java.io.*;
import java.util.Arrays;
import java.util.TreeSet;

public class RealEstates {
    static TreeSet<RealEstate> stocks = new TreeSet<>();

    public static void writeToFile(TreeSet<RealEstate> r) {
        long totalPriceOfProperties = 0L;
        long priceOfCheapestProperty = Long.MAX_VALUE;
        long mostExpensiveApartmentInBudapest = 0;
        int sqmRooms = 0;
        int price = 0;

        for (RealEstate realE : r) {
            totalPriceOfProperties += realE.totalPrice();
            priceOfCheapestProperty = Math.min(priceOfCheapestProperty, realE.totalPrice());
            if (realE.getCity().equalsIgnoreCase("budapest")) { // collecting most expensive property in Budapest
                mostExpensiveApartmentInBudapest = Math.max(mostExpensiveApartmentInBudapest, realE.totalPrice());
                if (realE.totalPrice() >= mostExpensiveApartmentInBudapest) sqmRooms = realE.getSqm();
            }
            price += realE.getPrice();
        }

        //The average square meter price of real estate
        String b = "The average square meter price of real estate " + price / 10;

        // The price of the cheapest property
        String d = "The price of the cheapest property " + priceOfCheapestProperty;

        // The average square meter value per room of the most expensive apartment in Budapest
        String a = "Average Square meter value per room of the most expensive apartment in Budapest " + (mostExpensiveApartmentInBudapest / sqmRooms);

        // The total price of the properties
        String c = "The total price of property " + totalPriceOfProperties;

        // List of condominium properties whose total price does not exceed the average price of properties
        long price1 = totalPriceOfProperties / 10;
        RealEstate[] rexList = new RealEstate[10];
        int i = 0;
        for (RealEstate rex : r) {
            if (rex.totalPrice() <= price1) rexList[i++] = rex;
        }

        String e = "List of condominium properties whose total price does not exceed the average price of properties => " + price1;
        rexList = Arrays.copyOfRange(rexList, 0, i);
        String f = Arrays.toString(rexList);
        String fileName = "example.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(b); writer.newLine();
            writer.write(d); writer.newLine();
            writer.write(a); writer.newLine();
            writer.write( c); writer.newLine(); writer.newLine();
            writer.write(  e); writer.newLine();
            writer.write( f); writer.newLine();
        } catch (IOException x) {
            x.printStackTrace();
        }
    }


    public static void main(String[] args) {

        String filePath = "C:/Users/HP/Desktop/allthingstogether/Semester-3-Sept-Jan-2023/Programming Technologies- Sandor Valyi/fileinput.txt"; // Replace with the actual file path
        String line;

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                while ((line = reader.readLine()) != null) {
                    String[] obj = line.split("#");

                    if(obj[0].equalsIgnoreCase("realestate")) {
                        RealEstate realEstate = new RealEstate(obj[1],
                                Integer.parseInt(obj[2]),
                                Integer.parseInt(obj[3]),
                                Integer.parseInt(obj[4]),
                                Genre.valueOf(obj[5]));
                        stocks.add(realEstate);
                    } else {
                        boolean bo = obj[7].equalsIgnoreCase("yes") ? true : false;
                        Panel panel = new Panel(obj[1],
                                Integer.parseInt(obj[2]),
                                Integer.parseInt(obj[3]),
                                Integer.parseInt(obj[4]),
                                Genre.valueOf(obj[5]),
                                Integer.parseInt(obj[6]),
                                bo);
                        stocks.add(panel);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        System.out.println("LIST OF ALL REAL ESTATES == > \n");
        System.out.println(stocks);

       writeToFile(stocks);
    }
}
