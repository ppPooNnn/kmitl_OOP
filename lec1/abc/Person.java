package abc;
public class Person
{
    String name;
    int saving;

    public Person()
    {

    }

    public Person(String x, int y)
    {
        name = x;
        saving = y;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSaving() {
        return saving;
    }

    public void setSaving(int saving) {
        this.saving = saving;
    }

    public void set_attribute(String x, int y)
    {
        name = x;
        saving = y;
    }

    public boolean isWealthier(Person obj)
    {
        return this.saving > obj.saving;
    }

    public void method1()
    {
        System.out.println("from method1");
    }
}