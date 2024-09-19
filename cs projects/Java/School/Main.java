public class Main {
    public static void main(String[] args) {
        Administrator principal = new Principal("John Doe", 45, 100000.0);
        Administrator vicePrincipal = new VicePrincipal("Jane Smith", 35, 80000.0);
        Teacher mathTeacher = new MathTeacher("Bob Johnson", 30, 60000.0);
        Teacher englishTeacher = new EnglishTeacher("Mary Brown", 40, 70000.0);
        Teacher scienceTeacher = new ScienceTeacher("David Lee", 50, 90000.0);
        SupportStaff janitor = new Janitor("Tom Wilson", 55, 40000.0);
        SupportStaff secretary = new Secretary("Samantha Davis", 25, 50000.0);
        Employee[] employees = { principal, vicePrincipal, mathTeacher, englishTeacher, scienceTeacher, janitor, secretary };

        for (Employee employee : employees) {
            employee.work();

            if (employee instanceof Administrator) {
                ((Administrator) employee).manage();
            }

            if (employee instanceof Teacher) {
                ((Teacher) employee).teach();
                ((Teacher) employee).generateQuestion();
            }

            if (employee instanceof SupportStaff) {
                ((SupportStaff) employee).support();
            }
        }
    }}
