import pack1.*;

public class lec2_Main {
    public static void main(String[] args) {
        // Emp e1 = new Emp("yindee", 500.0);
        // Reader r1 = new Reader("preeda", 20, "java");
        // Emp e2 = new Reader();

        A [] arr = new A[4];
        arr[0] = new B();
        arr[1] = new C();
        arr[2] = new B();
        arr[3] = new C();
        // for (int i = 0; i < arr.length; i++)
        // {
        //     System.out.println(arr[i]);
        // }
        for (int i = 0; i < arr.length; i++)
        {
            B ref;
            if (arr[i] instanceof B)
            {
                ref = ((B)arr[i]); // turn (A arr[i]) --> (B ref)
                ref.onlyB();
            }
            if (arr[i] instanceof C)
            {
                ((C)arr[i]).onlyC(); // cast (A arr[i]) --> (C arr[i])
            }
        }


    }
}
