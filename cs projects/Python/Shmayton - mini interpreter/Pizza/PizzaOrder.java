package exc1Pizza;
//Assignment 1
//author: Idan Alashvili ID:326117629
import java.util.Arrays;

public class PizzaOrder extends Pizza {
    private int pizzaCounter = 0;
    private String FirstName;
    private String LastName;
    private static final int MAXPIZZAS = 3;
    private Pizza[] pizzas = new Pizza[MAXPIZZAS];

    public PizzaOrder(String firstName, String lastName)
    {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.pizzas = new Pizza [MAXPIZZAS];
    }

    public void addPizza(int size, boolean extraCheese, boolean olives, boolean onions) {
        if (pizzaCounter < MAXPIZZAS) {
            pizzas[pizzaCounter] = new Pizza(size, extraCheese, olives, onions);
            pizzaCounter++;
        } else {
            System.out.println("Sorry, you can order max " + MAXPIZZAS + " pizzas");
        }
    }

    int calcTotal() {
        int totalPrice = 0;
        for (int i = 0; i < pizzaCounter; i++)
            totalPrice += pizzas[i].calcCost();
        return totalPrice;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    boolean equals(PizzaOrder other) {
        return Arrays.equals(this.pizzas , other.pizzas);
    }

    String tab() {
        return "Customer name : " + this.FirstName + " " + this.LastName + toString();
    }

    @Override
    public String toString() {
        String pizza2 = "";
        String pizza3 = "";
        String pizza1 = "\nPizzaOrder: \nPizza 1:" + pizzas[0].toString() + " costs " + calcCost();
        if (pizzaCounter >= 2) pizza2 = "\nPizza 2:" + pizzas[1].toString() + " costs " + calcCost();
        if (pizzaCounter == 3) pizza3 = "\nPizza 3:" + pizzas[2].toString() + " costs " + calcCost();
        return pizza1 + pizza2 + pizza3 + ". Total price: " + calcTotal();
    }
}