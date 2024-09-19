import java.util.Random;
import java.util.Scanner;

public class MathTeacher extends Teacher {
    public MathTeacher(String name, int age, double salary) {
        super(name, age, salary, "Math");
    }

    @Override
    public void work() {
        System.out.println("The math teacher is working.");
    }

    @Override
    public void teach() {
        System.out.println("The math teacher is teaching math.");
    }

    @Override
    public void generateQuestion() {
        Random random = new Random();
        int num1 = random.nextInt(11);
        int num2 = random.nextInt(11);
        int solution = num2 * num1;
        System.out.println("What is " + num1 + " * " + num2 + "?\n" +
                "Enter your answer:\n");
        Scanner scanner = new Scanner(System.in);
        int userSolution = scanner.nextInt();
        if (userSolution == solution) System.out.println("Well done your answer is correct.");
        else System.out.println("Your answer is incorrect. The correct answer is: " + solution);
    }
}
