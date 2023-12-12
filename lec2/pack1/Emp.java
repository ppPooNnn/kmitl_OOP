package pack1;

public class Emp {
    protected String name;
    protected double salary;

    public Emp() // alternative way with no super keyword in child's class
    {

    }

    public Emp (String n, double s)
    {
        name = n;
        salary = s;
    }
}
