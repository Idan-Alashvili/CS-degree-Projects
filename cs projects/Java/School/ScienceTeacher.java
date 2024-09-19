import java.util.Random;
import java.util.Scanner;

public class ScienceTeacher extends Teacher {
    public ScienceTeacher(String name, int age, double salary) {
        super(name, age, salary, "Science");
    }

    @Override
    public void work() {
        System.out.println("The science teacher is working.");
    }

    @Override
    public void teach() {
        System.out.println("The science teacher is teaching science.");
    }

    @Override
    public void generateQuestion() {
        Random random = new Random();
        int mass = random.nextInt(101);
        int acceleration = random.nextInt(10);
        int solution = mass*acceleration;
        Scanner scanner = new Scanner(System.in);
        System.out.println("A " + mass +" grams object is accelerating at " + acceleration
         + "m/s^2.\nEnter your answer:\n" );
        int userSolution = scanner.nextInt();
        if (userSolution == solution) System.out.println("Well done your answer is correct.");
        else System.out.println("Your answer is incorrect. The correct answer is: " + solution);
    }
}
