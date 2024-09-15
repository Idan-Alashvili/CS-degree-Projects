package CarDealership;
import java.nio.file.Path;
// Assignment: 5
// Author: Idan Alashvili, ID: 326117629
public class Employee implements Comparable<Employee> {
    private String name;
    private String id;
    private int SellingNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * get's & set's
     * @return
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSellingNum() {
        return SellingNum;
    }

    public void setSellingNum(int sellingNum) {
        SellingNum = sellingNum;
    }

    /**
     * constructor
     * @param name       the name of the employee
     * @param id         the ID of the employee
     * @param sellingNum the number of cars sold by the employee
     * @throws Exception if the name, ID, or selling number is invalid
     */
    Employee(String name, String id, int sellingNum) throws Exception {
        for (int i = 0; i < name.length(); i++) {
            if (65 < name.charAt(i) && name.charAt(i) > 122) throw new Exception("Name not valid!");
            else this.name = name;
        }
        if (name.length() == 0) throw new Exception("Name not valid!");
        if (id.length() != 9) throw new Exception("ID not valid!");
        else this.id = id;
        if (sellingNum < 0) throw new Exception("Selling num must be non-negative!");
        else this.SellingNum = sellingNum;
    }


    /**
     * Calculates the salary of the employee based on the number of cars sold.
     *
     * @return the salary of the employee
     */
    public int salaryCalc() {
        return 6000 + (this.SellingNum * 100);
    }

    /**
     * Comparing between 2 employees Selling number.
     *
     * @param o
     * @return -1 if the current employee have more selling than the other employee.
     * @return 0 if they have the same amount of selling.
     * @return 1 if the other employee have more selling than the current employee.
     */
    public int compareTo(Employee o) {
        if (this.SellingNum == o.SellingNum) return 0;
        else if (this.SellingNum < o.SellingNum) return -1;
        else return 1;
    }
    /**
     * Sells a car and updates the selling number for the employee.
     *
     * @param car  the car to sell.
     * @param path the path to write the sales information.
     */
    public void CarSell2(Car car, Path path) {
        try {
            car.CarSell(path);
        } catch (Exception e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
        this.SellingNum++;
    }
    /**
     * @return a string representation of the employee.
     */
    public String show() {
        return "Employee Details:" + "\nEmployee Name: " + this.name +
                "\nEmployee ID: " + this.id;
    }
    @Override
    public String toString() {
        return "Employee Details:\n" + "Employee Name: " + this.name +
                "\nEmployee ID: " + this.id + "\nSales Counter: " + this.SellingNum +
                "\nEmployee salary: " + salaryCalc() + "\n";
    }

}
