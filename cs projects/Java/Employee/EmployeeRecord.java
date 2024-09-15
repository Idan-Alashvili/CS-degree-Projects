package Employee;

public record EmployeeRecord(String ID, String name, int age, String department, String designation) {
    @Override
    public String toString() {
        return "Employee ID: " + ID +
                "\nName: " + name +
                "\nAge: " + age +
                "\nDepartment: " + department +
                "\nDesignation: " + designation;
    }
}
