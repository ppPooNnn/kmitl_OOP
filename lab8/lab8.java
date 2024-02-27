import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

interface HalfValueInterface
{
    public void printHalf(int n);
}

public class lab8 
{
    static List<Singer> singerList;
    static
    {
        singerList = new ArrayList<Singer>();
        singerList.add(new Singer("aba", Style.POP));
        singerList.add(new Singer("abe", Style.ROCK));
        singerList.add(new Singer("abi", Style.ROCK));
        singerList.add(new Singer("abo", Style.POP));
    }

    public static void main(String[] args) 
    {
        // q1_halfEachNumer();
        // q2_forEachSingerName();
        q3_lambda_comparator();
        // q4_method_reference_comparator();
    }

    public static void q1_halfEachNumer()
    {
        List<Integer> nums = Arrays.asList(100, 105);
        HalfValueInterface q0 = new HalfValueInterface() 
        {
            public void printHalf(int n)
            {
                System.out.println(n / 2);
            }
        };
        for(int n : nums)
        {
            q0.printHalf(n);
        }

        System.out.println("-----------q1.1-------------");
        HalfValueInterface halfVal = (n) -> System.out.println(n / 2);
        for(int n : nums)
        {
            halfVal.printHalf(n);
        }

        System.out.println("-----------q1.2-------------");
        Consumer<Integer> consumer = n -> System.out.println(n / 2);
        for (int n : nums)
        {
            consumer.accept(n);
        }

        System.out.println("-----------q1.3-------------");
        Consumer<Integer> halfMe = n -> System.out.println(n / 2);
        nums.forEach(halfMe);

        System.out.println("-----------q1.4-------------");
        nums.forEach(n -> System.out.println(n / 2));

        System.out.println("-----------q1.5-------------");
        NumberProcessor np = new NumberProcessor();
        nums.forEach(np :: printHalf); // np.printHalf -> np :: printHalf
    }

    public static void q2_forEachSingerName()
    {
        System.out.println("-----------q2.1-------------");
        singerList.stream().map(singer -> singer.getName()).forEach(System.out :: println);

        System.out.println("-----------q2.2-------------");
        singerList.stream().map(Singer :: getName).forEach(System.out :: println); // singer.getname
    }

    public static void q3_lambda_comparator()
    {
        Comparator<Singer> byStyle1 = new Comparator<Singer>() {
            public int compare(Singer o1, Singer o2)
            {
                return o1.getStyle().compareTo(o2.getStyle());
            }
        };

        Collections.sort(singerList, byStyle1);
        singerList.forEach(System.out :: println);

        System.out.println("-----------q3.1-------------");
        Comparator<Singer> byStyle2 = (o1, o2) -> o1.getStyle().compareTo(o2.getStyle());
        Collections.sort(singerList, byStyle2);
        singerList.forEach(System.out :: println); // System.out.println -> System.out :: printf
    }

    public static void q4_method_reference_comparator()
    {
        Comparator<Singer> byName = Comparator.comparing(Singer :: getName);

        System.out.println("-----------q4.1-------------");
        Collections.sort(singerList, byName);
        singerList.forEach(System.out :: println);
        Collections.sort(singerList, (o1, o2) -> o1.getStyle().compareTo(o2.getStyle()));
        System.out.println("-----------q4.2-------------");
        singerList.forEach(System.out :: println);
        
        System.out.println("-----------test 4.3 and 4.4-------------");
        // singerList.sort(Singer :: compareByName);
        // singerList.forEach(System.out :: println);
        // Collections.sort(singerList, Singer :: compareByName);
        // singerList.forEach(System.out :: println);
    }
}

class NumberProcessor implements HalfValueInterface
{
    public void printHalf(int n)
    {
        System.out.println(n / 2);
    }
}