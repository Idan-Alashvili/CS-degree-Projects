package CarDealership;

// Author: Idan Alashvili
import javax.swing.text.AbstractDocument;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import java.util.*;

public class CarDealerShip {
    /**
     * Sorts the ArrayList in ascending order using bubble sort.
     *
     * @param arr the ArrayList to be sorted
     * @param <T> the type of elements in the ArrayList, must implement Comparable
     */
    public static <T extends Comparable<T>> void sortArrayList(ArrayList<T> arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = 0; j < arr.size() - 1 - i; j++) {
                if (arr.get(j).compareTo(arr.get(j + 1)) < 0) {
                    T temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        Path path = Paths.get("Sold.txt");
        Path path2 = Paths.get("CarDealership.txt");
        Path path3 = Paths.get("Employee.txt");
        ArrayList<Car> carList = new ArrayList<>();
        try {
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(path2));
            for (String line : lines) {
                try {
                    String[] carData = line.split(" ");
                    String manufacturer = carData[0];
                    String carNumber = carData[1];
                    int year = Integer.parseInt(carData[2]);
                    int km = Integer.parseInt(carData[3]);
                    int price = Integer.parseInt(carData[4]);
                    Car car = new Car(carNumber, year, manufacturer, km, price);
                    carList.add(car);
                } catch (Exception e) {
                    System.out.println("Invalid car data: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to read car data from file: " + e.getMessage());
        }

        for (Car car : carList) {
            System.out.println(car);
        }

        ArrayList<Employee> employeeList = new ArrayList<>();

        try {
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(path3));
            for (String line : lines) {
                try {
                    String[] employeeData = line.split(" ");
                    String name = employeeData[0];
                    String id = employeeData[1];
                    int salesCounter = Integer.parseInt(employeeData[2]);
                    Employee employee = new Employee(name, id, salesCounter);
                    employeeList.add(employee);
                } catch (Exception e) {
                    System.out.println("Invalid employee data: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to read employee data from file: " + e.getMessage());
        }

        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

        Scanner scan = new Scanner(System.in);
        menu m;
        do {
            System.out.println("1 - displayEmployee\n" +
                    "2 - displayUnSoldCars\n" +
                    "3 - carSell\n" +
                    "4 - addNewCar\n" +
                    "5 - endProject");
            int choice;
            do {
                System.out.println("Enter your choice: ");
                choice = scan.nextInt();

                if (choice < 1 || choice > 5) {
                    System.out.println("Error ");
                }
            }
            while (choice < 1 || choice > 5);

            m = menu.values()[choice - 1];

            switch (m) {

                case displayEmployee:

                    sortArrayList(employeeList);

                    for (Employee employee : employeeList) {
                        System.out.println(employee);
                    }
                    break;

                case displayUnSoldCars:

                    for (Car car : carList) {
                        System.out.println(car);
                    }
                    break;

                case carSell:

                    for (Employee employee : employeeList) {
                        System.out.println(employee.show());
                    }

                    try {
                        System.out.println("Choose the employee by typing his ID.");
                        String employeeChoice = scan.next();

                        Employee e1;
                        String carNumberChoice;

                        do {
                            e1 = employeeIDCheck(employeeChoice, employeeList);
                            if (e1 == null) {
                                System.out.println("Employee ID not exist - try again");
                                employeeChoice = scan.next();
                            }
                        }
                        while (e1 == null);

                        for (Car car : carList) {
                            System.out.println(car);
                        }

                        do {
                            System.out.println("Choose the car number.");
                            carNumberChoice = scan.next();

                            if (CarNumberCheck(carNumberChoice, carList) == null) {
                                System.out.println("Car Number not exist - try again");
                                carNumberChoice = scan.next();
                            }
                        }
                        while (CarNumberCheck(carNumberChoice, carList) == null);

                        e1.CarSell2(CarNumberCheck(carNumberChoice, carList), path);
                        carList.remove(CarNumberCheck(carNumberChoice, carList));

                    } catch (Exception e) {
                        throw new Exception("Invalid input - please enter new input.");
                    }
                    break;

                case addNewCar:
                    System.out.println("Enter the car's number: ");
                    String carNumber = scan.next();

                    System.out.println("Enter the car's year: ");
                    int year = scan.nextInt();

                    System.out.println("Enter the car's manufacturer ");
                    String Manufacturer = scan.next();

                    System.out.println("Enter the car's km: ");
                    int km = scan.nextInt();

                    System.out.println("Enter the car's price: ");
                    int price = scan.nextInt();

                    Car c10 = new Car(carNumber, year, Manufacturer, km, price);

                    carList.add(c10);

                    break;


                case endProject:
                    try {
                        Files.delete(path2);
                        Path path4 = Paths.get("CarDealership.txt");
                        Files.createFile(path4);
                        ArrayList<String> lines = new ArrayList<>(Files.readAllLines(path2));

                        for (Car car : carList) {
                            Files.writeString(path4, car.toString(), StandardOpenOption.APPEND);
                        }
                        System.out.println("The dealership file have been updated. ");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

            }
        }
        while (m != menu.endProject);
    }

    /**
     * Checks if the given Employee ID exists in the Employee list.
     *
     * @param id         the Employee ID to check
     * @param EmployeeID the list of Employees
     * @return the Employee object if found, null otherwise
     */
    public static Employee employeeIDCheck(String id, ArrayList<Employee> EmployeeID) {
        for (Employee employee : EmployeeID) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    /**
     * Checks if the given car number exists in the car list.
     *
     * @param carNumber the car number to check
     * @param carN      the list of cars
     * @return the Car object if found, null otherwise
     */
    public static Car CarNumberCheck(String carNumber, ArrayList<Car> carN) {
        for (Car car : carN) {
            if (car.getCarNumber().equals(carNumber)) {
                return car;
            }
        }
        return null;
    }
}
