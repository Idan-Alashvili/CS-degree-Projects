package CarDealership;
// Assignment: 5
// Author: Idan Alashvili, ID: 326117629
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
/**
 * The Car class represents a car in a car dealership.
 */
public class Car {


    private String carNumber;
    private int year;
    private String manufacturerName;
    private int Km;
    private int price;

    /**
     * get's & set's
     */
    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public int getKm() {
        return Km;
    }

    public void setKm(int km) {
        Km = km;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * constructor, setting the params according to the real world.
     * @param carNumber         The car number.
     * @param Year              The year of the car.
     * @param manufacturerName  The manufacturer name of the car.
     * @param Km                The kilometers driven by the car.
     * @param price             The price of the car.
     * @throws Exception if the car details are invalid.
     */
    Car(String carNumber, int Year, String manufacturerName, int Km, int price) throws Exception {
        if (price < 0) throw new Exception("price must be non-negative!");
        else this.price = price;
        if (Km < 0) throw new Exception("Km must be non-negative!");
        else this.Km = Km;
        if (carNumber.length() != 6) throw new Exception("Car Number must be 6 digits!");
        else this.carNumber = carNumber;
        if (Year < 2017 || Year > 2023) throw new Exception("Year is not valid!");
        else this.year = Year;
        if (manufacturerName.length() == 0) throw new Exception("Manufacturer Name not valid!");
        else this.manufacturerName = manufacturerName;
    }

    /**
     * decreasing the car's price with given percentage, and limits to the decrease.
     * @param percent The percentage by which to decrease the car's price.
     * @throws Exception if the price decrease is not valid.
     */
    public void DecreaseCarPrice(int percent) throws Exception {
        if (this.price * percent / 100 >= 5000 || percent <= 0)
            throw new Exception("This car's price can't be decreased that way!");
        else setPrice(this.price - (this.price * percent / 100));
    }

    /**
     * selling car and writing the sold car in Cars.txt
     * @param path The path of the file to write the car details.
     */
    public void CarSell(Path path) {
        String filePath = "Cars.txt";
        try {
            Files.write(path, this.toString().getBytes(), StandardOpenOption.APPEND);
            System.out.println("Car details added to file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Car Details:\n" + this.manufacturerName + " " + this.carNumber + " " + this.year + " " + this.price + " " + this.Km + "\n";
    }
}