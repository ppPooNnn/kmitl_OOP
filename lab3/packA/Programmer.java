package packA;

public class Programmer extends EmpTmp
{
    private String name;
    protected int salary;
    private int experience;

    public Programmer(String n, int exp, int sal)
    {
        this.name = n;
        this.experience = exp;
        this.salary = sal;
    }

    public Programmer(String n)
    {
        this.name = n;
    }

    public Programmer()
    {

    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void setSalary(int newSalary)
    {
        this.salary = newSalary;
    }

    public int getSalary()
    {
        return this.salary;
    }

    public void setExperience(int exp)
    {
        this.experience = exp;
    }

    public int getExperience()
    {
        return this.experience;
    }

    public String toString()
    {
        return String.format("Programmer [name = %s, salary = %d, experience = %d]", this.name, this.salary, this.experience);
    }

    public void sayHi()
    {
        System.out.println("hi from " + this.name);
    }

    public String coding()
    {
        return "Coding from programmer";
    }
}