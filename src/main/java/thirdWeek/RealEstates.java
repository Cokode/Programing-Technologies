package thirdWeek;

import secondWeek.Genre.Genre;
import secondWeek.Panel;
import secondWeek.RealEstate;

import java.io.*;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RealEstates {
    private static final Logger LOGGER = Logger.getLogger(RealEstates.class.getName());

    static TreeSet<RealEstate> stocks = new TreeSet<>();

    public static void writeToFile(TreeSet<RealEstate> r) {
        LOGGER.info("Calling writeToFile Method");

        long totalPriceOfProperties = 0L;
        long priceOfCheapestProperty = Long.MAX_VALUE;
        long mostExpensiveApartmentInBudapest = 0;
        int sqmRooms = 0;
        int price = 0;

        for (RealEstate realE : r) {
            totalPriceOfProperties += realE.totalPrice();
            priceOfCheapestProperty = Math.min(priceOfCheapestProperty, realE.totalPrice());

                if (realE.getCity().equalsIgnoreCase("budapest")) {
                    // collecting most expensive property in Budapest
                    mostExpensiveApartmentInBudapest = Math.max(mostExpensiveApartmentInBudapest, realE.totalPrice());
                    if (realE.totalPrice() >= mostExpensiveApartmentInBudapest) sqmRooms = realE.getSqm();
                }

            price += realE.getPrice();
        }

        String b = "The average square meter price of real estate " + price / 10;
        String d = "The price of the cheapest property " + priceOfCheapestProperty;
        String a = "Average Square meter value per room of the most expensive apartment in Budapest "
                + (mostExpensiveApartmentInBudapest / sqmRooms);
        String c = "The total price of property " + totalPriceOfProperties+ "\n";

        /**
         * Looking for list of condominium properties whose
         * total price does not exceed the average price of properties
         */
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
            writer.write(c); writer.newLine();
            writer.write(e); writer.newLine();
            writer.write(f); writer.newLine();
        } catch (IOException x) {
            x.printStackTrace();
            LOGGER.log(Level.WARNING, "Problem writing to file example.text", x);
        }
    }

    public static void main(String[] args) throws SecurityException, IOException {

        LOGGER.info(Logger.class.getName());
        RealEstate.logInfo();
        String filePath2, filePath1, line;

        /**
         * For Mac OS users, `filePath2` refers to the file path located in an external hard drive.
         * To write/access files in external drives in Mac OS, the file path must start with /volumes/drive_name/folder/file.filetype.
         * `filePath1` represents the file path for my HP/Windows machine.
         */

        //String filePath1 = "C:/Users/HP/Desktop/allthingstogether/Semester-3-Sept-Jan-2023/Programming Technologies- Sandor Valyi/fileinput.txt"; // Replace with the actual file path
        filePath2 = "/Volumes/PASSWORD/allthingstogether/Programinig Technologies/fileinput.txt"; // Replace with the actual file path

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath2))) {
            while ((line = reader.readLine()) != null) {
                String[] obj = line.split("#");

                if(obj[0].equalsIgnoreCase("realestate")) {
                    RealEstate realEstate = new RealEstate(obj[1],
                            Integer.parseInt(obj[2]),
                            Integer.parseInt(obj[3]),
                            Integer.parseInt(obj[4]),
                            Genre.valueOf(obj[5]));
                    stocks.add(realEstate);
                    /**
                     * stocks.add(realEstate) adds RealEstate properties to the collection
                     */
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
                    /**
                     * stocks.add(panel) adds panel properties to the collection
                     */
                }
            }
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.WARNING, "\nFile not found -> `fileinput.text\n".toUpperCase(), e);
            e.printStackTrace();
        }

        System.out.println("LIST OF ALL REAL ESTATES == > \n");
        System.out.println(stocks);

        /**
         * This method, 'writeToFile', saves all the information
         * from the 'stocks' collection to a file named 'example.txt'.
         */
        writeToFile(stocks);
    }
}
