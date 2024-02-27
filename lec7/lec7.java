public class lec7
{
    public static void main(String[] args) {
        demo3();
    }

    static void demo1()
    {

    }

    static void demo2()
    {
        Aquatic a1 = new Aquatic("smooth");
        Talipia t1 = new Talipia("smooth");

        t1.onlyTalipia();
        ((Talipia)a1).onlyTalipia();
    }

    static void demo3()
    {
        CanSwim nemo = new CanSwim(){
            public void swim()
            {
                System.out.println("from crow fish");
            }
        };

        nemo.swim();

        CanSwim seaHorse = () -> {System.out.println("sea horse");};

        seaHorse.swim();

    }
}