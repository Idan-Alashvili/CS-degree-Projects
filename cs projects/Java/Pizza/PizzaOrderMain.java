package exc1Pizza;
//Assignment 1
//author: Idan Alashvili
public class PizzaOrderMain {
    public static void main(String[] args) {
        PizzaOrder order1 = new PizzaOrder("Idan", "Alashvili");
        PizzaOrder order2 = new PizzaOrder("Leonid", "Kogel");
        order1.addPizza(0, true, false, true);
        order1.addPizza(1, true, false, false);
        order2.addPizza(2, true, true, true);
        order2.addPizza(2, true, true, true);
        order2.addPizza(2, true, true, true);
        System.out.println(order1.tab());
        System.out.println(order2.tab());
        if(order1.equals(order2)) System.out.println("The orders are equal");
        else System.out.println("The orders are not equal");
    }
}
