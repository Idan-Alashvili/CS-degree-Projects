public class Principal extends Administrator{
    public Principal (String name, int age, double salary){
        super(name,age,salary);
    }

    @Override
    public void work() {
        System.out.println("The principal is working. ");
    }

    @Override
    public void manage() {
        System.out.println(" The principal is managing the school.");
    }
}
