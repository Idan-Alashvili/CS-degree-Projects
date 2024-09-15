package Employee;

public record PayrollRecord(String ID, int salary, int bonus, int tax) {
    @Override
    public String toString() {
        int finalSalary = salary + bonus - tax;

        return "Employee ID: " + ID +
                "\nSalary: " + salary +
                "\nbonus: " + bonus +
                "\ntax: " + tax +
                "\nFinal Salary: " + finalSalary;
    }
}