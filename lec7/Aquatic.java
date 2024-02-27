public class Aquatic {
    protected String skin;

    Aquatic ()
    {

    }

    Aquatic (String s)
    {
        skin = s;
    }

    public void method1()
    {
        System.out.println("fromt aquatic");
    }

    public void setSkin(String s)
    {}
}

class Talipia extends Aquatic
    {
        Talipia(String s)
        {
            super(s);
        }

        public void method1()
        {
            System.out.println("from talipia");
        }
        void onlyTalipia()
        {
            System.out.println("yyy");
        }
    }

class Parrot extends Aquatic
{
    Parrot(String s)
    {
        super(s);
    }
}

interface CanSwim
{
    public void swim();
}