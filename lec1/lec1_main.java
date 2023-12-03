import java.util.ArrayList;

import abc.Person;

public class lec1_main 
{
    public static void main(String[] args) 
    {
        demo5();
    }

    static void demo1()
    {
        Person p1 = new Person();
        p1.set_attribute("yindee", 500);
        String str = p1.name;
        int balance = p1.saving;

        System.out.println(str + " " + balance);
    }

    static void demo2()
    {
        Person [] pArr = new Person[5]; // เหมือนสร้างกรอบของ person แต่ยังไม่มี person จริง ๆ
        Person p1 = new Person(); // สร้าง person จริง ๆ
        pArr[0] = p1; // way to create person into arrays
        pArr[1] = new Person(); // alternative way

        ArrayList<Person> pList = new ArrayList<Person>();
        pList.add(p1);
    }

    static void demo3()
    {
        Person p3 = new Person();
        // p1.set_attribute("yindee", 500);
       
        Person p4 = new Person();
        // p2.set_attribute("preeda", 200);

        Person p1 = new Person("yindee", 500);
        Person p2 = new Person("preeda", 200);
        System.out.println(p1.isWealthier(p2));
    }

    static void demo4()
    {
        // Person.method1(); // if static method you NEED to access from class name
    }

    static void demo5()
    {
        Person p1 = new Person("preeda",200);
        Programmer prog1 = new Programmer("yindee", 500, "java");
        prog1.method1();
        // prog1.method2();
    }
}
