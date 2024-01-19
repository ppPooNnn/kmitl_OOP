package packA;

public abstract class Employee 
{
    protected String name;
    protected int experience;
    protected int salary;

    public abstract void sayHi();

    public Employee(String name, int experience, int salary) {
        this.name = name;
        this.experience = experience;
        this.salary = salary;
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee()
    {
        
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public int getSalary() {
        return salary;
    }

    
}
