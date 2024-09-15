package CarDealership;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws Exception {
        Path filePath= Paths.get("Sold.txt");
       // Files.createFile(filePath);
        Car car = new Car("156551", 2018, "pipi", 50, 20000);
        Car car2 = new Car("564568", 2020, "lama", 8970, 200000);
        Employee employee = new Employee("Idan", "100000010", 2);
        System.out.println(car);
        System.out.println(employee);
        employee.CarSell2(car,filePath);
        employee.CarSell2(car2,filePath);
        System.out.println(employee);
    }
}