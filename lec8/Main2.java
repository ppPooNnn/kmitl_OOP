import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main2 {
    static List<Integer> nums = Arrays.asList(100, 105);
    
    public static void main(String[] args) {
        demo1();
    }

    static void demo1()
    {
        Consumer<Integer> consumer = num -> System.out.println(num / 2);

        nums.forEach(consumer); // for each keeping sending number individually
        // มันโยน method ไปให้เอง implicit call to .accept(); หรือคือ เรียก .accept ให้อัตโนมัต

        consumer.accept(500); // เรียกใช้เอง
    }
}
