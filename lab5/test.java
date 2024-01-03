public class test {
    public static void main(String[] args) {
        FuncInterface1 instance;

        instance = () -> (int)(Math.random() * 1000);
        System.out.println(instance.method1());
    }
}
