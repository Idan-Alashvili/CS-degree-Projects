public abstract class  Employee {
    String name;
    int age;
    double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    public Employee(String name, int age, double salary){
        this.age = age;
        this.name = name;
        this.salary = salary;
    }
    public abstract void work();
}
