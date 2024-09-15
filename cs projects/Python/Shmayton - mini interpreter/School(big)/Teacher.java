public abstract class Teacher extends Employee{
    public final String subject;
    public Teacher(String name, int age, double salary, String subject){
        super(name, age , salary);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public abstract void teach();
    public abstract void generateQuestion();
}
