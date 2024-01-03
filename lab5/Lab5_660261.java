import java.util.Arrays;

public class Lab5_660261
{
    static int[] data = {28, 58, 8, 77, 48, 39};
    static ArrayProcessor q1NumberOfEvenElement;
    static ArrayProcessor q2IndexOfLargestEvenValue;
    static ArrayProcessor myMedian;
    
    public static void main(String[] args) {
        q1();
        q2();
        oneline();
    }

    static void q1()
    {
        q1NumberOfEvenElement = (int[] data) -> {
            int count = 0;
            for(int i = 0; i < data.length; i++)
            {
                if(data[i] % 2 == 0)
                    count++;
            }
            return count;
        };

        System.out.println(q1NumberOfEvenElement.calculate(data));

    }
    
    static void q2()
    {
        q2IndexOfLargestEvenValue = (int[] data) -> 
        {
            int index = 0;
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < data.length; i++)
            {
                if(data[i] % 2 == 0 && data[i] > max)
                {
                    max = data[i];
                    index = i;
                }
            }
            return index;
        };
        System.out.println(q2IndexOfLargestEvenValue.calculate(data));
    }

    static void oneline()
    {
        int[] tmp = Arrays.copyOf(data, data.length);
        Arrays.sort(tmp);
        myMedian = (arr) -> arr[arr.length / 2];
        System.out.println(myMedian.calculate(tmp));
    }
}