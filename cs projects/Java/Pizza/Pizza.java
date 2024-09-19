package exc1Pizza;
//Assignment 1
//author: Idan Alashvili 
public class Pizza {
    private int size;
    private boolean extra_cheese, olives, onion;

    /**
     * default constructor
     */
    Pizza() {
        this.size = 0;
        this.olives = false;
        this.onion = false;
        this.extra_cheese = false;
    }

    /**
     * build constructor
     * @param size
     * @param extra_cheese
     * @param olives
     * @param onion
     */
    Pizza(int size, boolean extra_cheese, boolean olives, boolean onion) {
        if (size <= 2 && size >= 0) {
            this.size = size;
        } else this.size = 0;
        this.extra_cheese = extra_cheese;
        this.olives = olives;
        this.onion = onion;
    }

    /**
     * copy constructor
     * @param other
     */
    Pizza(Pizza other) {
        this.size = other.size;
        this.extra_cheese = other.extra_cheese;
        this.olives = other.olives;
        this.onion = other.onion;
    }

    //getters and setters
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if (size >= 0 && size <=2)this.size = size;
        else this.size = 0;
    }

    public boolean getExtra_cheese() {
        return extra_cheese;
    }

    public void setExtra_cheese(boolean extra_cheese) {
        this.extra_cheese = extra_cheese;
    }

    public boolean getOlives() {
        return olives;
    }

    public void setOlives(boolean olives) {
        this.olives = olives;
    }

    public boolean getOnion() {
        return onion;
    }

    public void setOnion(boolean onion) {
        this.onion = onion;
    }

    public int calcCost() {

        int price = 0;
        if (this.size == 0) {
            price += 35;
            if (this.onion) price += 6;
            if (this.olives) price += 6;
            if (this.extra_cheese) price += 6;
        }
        if (this.size == 1) {
            price += 45;
            if (this.onion) price += 7;
            if (this.olives) price += 7;
            if (this.extra_cheese) price += 7;
        }
        if (this.size == 2) {
            price += 60;
            if (this.onion) price += 9;
            if (this.olives) price += 9;
            if (this.extra_cheese) price += 9;
        }
        return price;
    }

    @Override
    public String toString() {
        String olive = "", onions = "", extraCheese = "", contains = "", sizetxt = "";
        if (this.size == 0) sizetxt = "Small";
        else if (this.size == 1) sizetxt = "Medium";
        else if (this.size == 2) sizetxt = "Large";
        if (this.olives) olive = "olives ";
        if (this.onion) onions = "and onions .";
        if (this.extra_cheese) extraCheese = "extra cheese ";
        if (this.extra_cheese || this.onion || this.olives) contains = " with ";
        return  " Pizza size - " + sizetxt + contains + extraCheese + olive + onions;
    }


    public boolean equals(Pizza other) {
        return (this.size == other.size) && (this.onion == other.onion) && (this.extra_cheese == other.extra_cheese) && (this.olives == other.olives);
    }
}
