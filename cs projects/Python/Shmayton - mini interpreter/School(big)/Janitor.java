import java.util.Random;

public class Janitor extends SupportStaff {
    public Janitor(String name, int age, double salary) {
        super(name, age, salary);
    }

    @Override
    public void work() {
        System.out.println("The janitor is working .");
    }

    @Override
    public void support() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int j = random.nextInt(11);
            System.out.println("The janitor is ordering the following items:\n" +
                    "Item #" + i + "\tamount:" + j);
        }
    }
}
