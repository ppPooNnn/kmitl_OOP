import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class lab10_660261
{
    public static void main(String [] args)
    {
        testBed(args);
    }

    private static void testBed(String[] args)
    {
        System.out.println("**AAAAAAAA**");
        System.out.print("command arguments are ");
        for(String s : args)
            System.out.println(s.trim());
        System.out.println();

        System.out.println("**BBBBBBBB**");

        String row;
        String [] tokens;
        try(Scanner input = new Scanner(Paths.get("./pack10_CSMovie/movies15.csv")))
        {
            input.nextLine();
            while(input.hasNext())
            {
                row = input.nextLine();
                tokens = row.split(",");
                for(String token : tokens)
                    System.out.print(token + " ");
                System.out.println();
            }            
        } catch (IOException e) {
            System.out.println("from IO error");
            e.printStackTrace();
        }

        System.out.println("**CCCCCCCC**");

        row = "\"This is, a sample title\", \"Horror\", \"10.0\"";
        tokens = row.split(",");
        System.out.println("There are " + tokens.length + " tokens");

        for(String token : tokens)
            System.out.println(token.trim() + " ");
        tokens = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
        System.out.println("There are " + tokens.length + " tokens");

        for(String token : tokens)
            System.out.println(token.trim() + " ");
    }

    
}
