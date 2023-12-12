package pack1;

public class B extends A {
    public String toString()
    {
        return "from B";
    }
    
    public void onlyB()
    {
        System.out.println("from B");
    }
}
