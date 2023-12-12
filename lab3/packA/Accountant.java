package packA;

public class Accountant extends EmpTmp
{
    private static String companyName = "berk barn jamkad";
    private int experience;
    private String specialty;

    public Accountant(String name, int superExp, int experience, int sal, String talent)
    {
        super(name, superExp, sal);
        this.experience = experience;
        this.specialty = talent;
    }

    public void setSpecialty(String newSpecialty)
    {
        this.specialty = newSpecialty;
    }

    public String getSpecialty()
    {
        return this.specialty;
    }

    public void setAccountExperience(int exp)
    {
        this.experience = exp;
    }

    public int AccountExperience()
    {
        return this.experience;
    }

    public String tellProfit()
    {
        int profit = (int)(Math.random() * 1000);

        return String.format("%s's profit is %d. My salary is %d", companyName, profit, super.salary);
    }

    public String toString()
    {
        return String.format("Accountant [experience = %d, specialty = %s]", this.experience, this.specialty);
    }

    public void sayHi()
    {
        System.out.printf("%s says hello\n", super.getName());
    }

    public static String tellMyRole()
    {
        return String.format("I am an accountant at %s", companyName);
    }
}
