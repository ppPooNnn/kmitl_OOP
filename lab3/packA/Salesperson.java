package packA;

public class Salesperson extends EmpTmp
{
    private int target;

    public Salesperson(String n, int exp, int sal, int assignedTarget)
    {
        super(n, exp, sal);
        this.target = assignedTarget;
    }

    public Salesperson(String n, int exp)
    {
        super.setName(n);
        super.setExperience(exp);
    }

    public void setTarget(int target)
    {
        this.target = target;
    }

    public int getTarget()
    {
        return this.target;
    }

    public void setSalary(int increasedAmount)
    {
        super.setSalary(super.salary + increasedAmount);
    }

    public void setSalary()
    {
        super.setSalary((super.salary * 110)/100);
    }

    public String makeQuotation()
    {
        double number = Math.random() * 1000;
        int num = (int) number;
        return String.format("Dear value customer, %d is my best offer", num);
    }

    public String toString()
    {
        return "Salesperson [target = " + this.target + " " + super.toString() + " ]";
    }
}
