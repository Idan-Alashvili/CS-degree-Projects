public abstract class Administrator extends Employee{
    public Administrator(String name, int age, double salary){
        super(name, age, salary);
    }
    public abstract void manage();

}
