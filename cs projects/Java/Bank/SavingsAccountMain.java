package exc2bank;
//author: Idan Alashvili 
public class SavingsAccountMain {
    public static void main(String[] args) {
        PersonId[] personIds = new PersonId[10];
        personIds[0] = new PersonId(251456, "Bill", " Gates", "Tel-Aviv");
        personIds[1] = new PersonId(5412, "Steve", " Jobs", "Ashdod");
        personIds[2] = new PersonId(45687, "Aviv", " Ben hamor", "Cislev 32");
        SavingsAccount[] savingsAccounts = new SavingsAccount[10];
        savingsAccounts[0] = new SavingsAccount(personIds[0] , 2000.0);
        savingsAccounts[1] = new SavingsAccount(personIds[1] , 3000.0);
        savingsAccounts[2] = new SavingsAccount(personIds[2] , 4000.0);
        double annualInterestRate = 0.01;
        SavingsAccount.modifyInterestRate(annualInterestRate);
        for (int i = 0; i < 3 ; i++){
            savingsAccounts[i].calculateMonthlyInterest();
        }
        for (int i = 0; i < 3 ; i++){
            savingsAccounts[i].calculateMonthlyInterest();
        }
        annualInterestRate = -0.015;
        SavingsAccount.modifyInterestRate(annualInterestRate);
        for (int i = 0; i < 3 ; i++){
            savingsAccounts[i].calculateMonthlyInterest();
            System.out.println(savingsAccounts[i]);
        }
    }
}
