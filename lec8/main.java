interface canSwim
{
    abstract public void swim();
}

class Main
{
    public static void main(String[] args) {
        demo2();
    }

    static void demo1()
    {
        C obj1 = new C();
        obj1.swim();
        Main obj2 = new Main();
        obj2.swim();
    }

    static void demo2()
    {
        canSwim obj3 = new canSwim() { // annonymus class
            public void swim()
            {
                System.out.println("from demo2");
            }
        };
        obj3.swim();

        canSwim obj4 = () -> System.out.println("from obj4"); // lambda expression

        obj4.swim();
    }

    public void swim()
    {
        System.out.println("from main swim");
    }
}

class C implements canSwim
{
    public void swim()
    {
        System.out.println("from C");
    }
}