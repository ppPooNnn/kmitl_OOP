import abc.Person;

public class Programmer extends Person{
    private String languages;
    Programmer(String name, int saving, String langs)
    {
        super(name, saving);
        this.languages = langs;
    }

    void method2()
    {
        String str = this.name;
        String str2 = super.name;
        System.out.println(str + " " + str2);
    }

    void method1()
    {
        System.out.println("from programmer");
    }
}
