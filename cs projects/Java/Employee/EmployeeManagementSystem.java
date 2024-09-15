package Employee;

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        EmployeeRecord EmployeeRecord1 = new EmployeeRecord("1", "Gil", 25, "Kings", "Gvarim");
        EmployeeRecord EmployeeRecord2 = new EmployeeRecord("2", "Hanna", 25, "Queens", "Nashim");

        System.out.println(EmployeeRecord1);
        System.out.println();
        System.out.println(EmployeeRecord2);
        System.out.println();

        PayrollRecord PayrollRecord1 = new PayrollRecord("3", 50, 2, 4);
        PayrollRecord PayrollRecord2 = new PayrollRecord("4", 25, 1, 2);

        System.out.println(PayrollRecord1);
        System.out.println();
        System.out.println(PayrollRecord2);
        System.out.println();


        LeaveRecord LeaveRecord1 = new LeaveRecord("5", 69, 50);
        LeaveRecord LeaveRecord2 = new LeaveRecord("6", 96, 69);

        System.out.println(LeaveRecord1);
        System.out.println();
        System.out.println(LeaveRecord2);
        System.out.println();


        AttendanceRecord AttendanceRecord1 = new AttendanceRecord("7", 50, 10);
        AttendanceRecord AttendanceRecord2 = new AttendanceRecord("8", 40, 20);

        System.out.println(AttendanceRecord1);
        System.out.println();
        System.out.println(AttendanceRecord2);
        System.out.println();
    }
}
