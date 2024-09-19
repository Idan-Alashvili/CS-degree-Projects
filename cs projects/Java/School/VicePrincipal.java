public class VicePrincipal extends Administrator {
    public VicePrincipal(String name, int age, double salary) {
        super(name, age, salary);
    }

    @Override
    public void work() {
        System.out.println("The vice principal is working.");
    }

    @Override
    public void manage() {
        System.out.println("The vice principal is assisting the principal.");
    }
}
