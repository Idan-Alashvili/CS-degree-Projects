import java.util.Random;
import java.util.Scanner;

public class EnglishTeacher extends Teacher {
    public EnglishTeacher(String name, int age, double salary) {
        super(name, age, salary, "English");
    }

    @Override
    public void work() {
        System.out.println("The english teacher is working.");
    }

    @Override
    public void teach() {
        System.out.println("The english teacher is teaching english.");
    }

    @Override
    public void generateQuestion() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int i = random.nextInt(11);
        String[] arr = {"cat", "dog", "tree", "book", "cup", "sun", "moon", "star", "car", "house"};
        String questionWord = arr[i];
        String[] arr2 = {"Spell", "Define", "Use in a sentence", "Rhyme with", "Antonym of", "Synonym of"};
        int j = random.nextInt(6);
        String question = arr2[j];
        System.out.println(question + " the word " + questionWord + "\n" +
                "Enter your answer:\n");
        String answer = scanner.nextLine();
        System.out.println("Your answer is : " + answer);
    }
}
