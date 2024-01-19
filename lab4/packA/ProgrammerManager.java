package packA;

public class ProgrammerManager extends Programmer implements ManagerRoles 
{
    protected String name;
    protected int salary;
    protected int experience;

    public ProgrammerManager(String n, int exp, int sal) {
        super(n, exp, sal);
    }

    public ProgrammerManager(String n) {
        super(n);
    }

    public ProgrammerManager() {
    }

    public void sayHi()
    {
        System.out.println("Coding in [solidity, typescript]");
    }

    public int evaluate(Programmer p)
    {
        int new_salary = 0;

        new_salary = p.getSalary() + (p.getSalary() * 15/100);
        return new_salary;
    }

    @Override
    public String toString()
    {
        return String.format("ManagerProgrammer [name = %s, experience = %d, salary = %d]", name, experience, salary);
    }
}
