package exc2bank;
//author: Idan Alashvili 
public class SavingsAccount {

    private static double annualInterestRate;
    private static int accountCounter = 1000;
    private final int accountNum;
    private PersonId person;

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        if (annualInterestRate <= 1 && annualInterestRate >= -1)
            SavingsAccount.annualInterestRate = annualInterestRate;
        else SavingsAccount.annualInterestRate = 0;
    }


    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    public PersonId getPerson() {
        return person;
    }

    public void setPerson(PersonId person) {
        this.person = person;
    }

    /**
     * default constructor
     */
    private double savingsBalance;

    SavingsAccount() {
        this.person = new PersonId();
        this.savingsBalance = 0;
        this.accountNum = accountCounter;
        accountCounter++;
    }

    /**
     * default constructor with known PersonID
     */
    SavingsAccount(PersonId person) {
        this.person = person;
        this.savingsBalance = 0;
        this.accountNum = accountCounter;
        accountCounter++;
    }

    /**
     * build constructor with full information about the user
     */
    SavingsAccount(PersonId person, double savingsBalance) {
        this.person = new PersonId(person);
        this.savingsBalance = savingsBalance;
        this.accountNum = accountCounter;
        accountCounter++;
    }

    void calculateMonthlyInterest() {
        if (annualInterestRate != 0) {
            this.savingsBalance += this.savingsBalance * annualInterestRate / 12;
        }
    }

    static void modifyInterestRate(double NewAnnualInterestRate) {
        annualInterestRate = NewAnnualInterestRate;
    }

    @Override
    public String toString() {
        return "Account number: " + this.accountNum + "\nClient details: " +
                this.person.toString() + "\nSaving Balance: " + this.savingsBalance + "\n";
    }

    public boolean equals(SavingsAccount other) {
        return this.accountNum == other.accountNum;
    }
}
