import java.util.Random;

public class Secretary extends SupportStaff {
    public Secretary(String name, int age, double salary) {
        super(name, age, salary);
    }

    @Override
    public void work() {
        System.out.println("The secretary is working .");
    }

    @Override
    public void support() {
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            int j = random.nextInt(101);
            System.out.println("The secretary enters the following grades into moodle:\n" +
                    "Student #" + i + "\tgrade:" + j);
        }
    }
}
