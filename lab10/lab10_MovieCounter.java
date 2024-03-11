import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import pack10_CSMovie.*;

public class lab10_MovieCounter 
{
    ArrayList<CSMovie> mList = new ArrayList<>();
    Set<String> uniqueTitle = new HashSet<>();

    public lab10_MovieCounter()
    {
        String row;
        int rowCount = 1;
        int incompleteCount = 0;
        String title;
        String rating;
        String genre;
        Integer year;
        String skipped_released;
        Double score;
        Integer votes;
        String director;
        String skipped_writer;
        String star;
        String country;
        Integer budget;
        Long gross;
        String company;
        Integer runtime;

        
        try(Scanner input = new Scanner(Paths.get("pack10_CSMovie/movies.csv"))) {
            input.nextLine();

            while(input.hasNext())
            {
                row = input.nextLine();
                rowCount++;
                String[] tokens = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                if(tokens.length < 15)
                {
                    incompleteCount++;
                    System.out.println((rowCount + " " + incompleteCount + " is incompleted"));
                    continue;
                }
                title = tokens[0];
                rating = tokens[1];
                genre = tokens[2];
                year = Integer.parseInt(tokens[3]);
                score = Double.parseDouble(parseDouble(tokens[5]));
                votes = (int) (Double.parseDouble(parseDouble(tokens[6])));
                director = tokens[7];
                star = tokens[9];
                country = tokens[10];
                budget = (int) (Double.parseDouble(parseDouble(tokens[11])));
                gross = (long) (Double.parseDouble(parseDouble(tokens[12])));
                company = tokens[13];
                runtime = (int) (Double.parseDouble(parseDouble(tokens[14])));
                if(!uniqueTitle.contains(title))
                {
                    mList.add(new CSMovie(title, rating, genre, year, score, votes, director, star, country, budget, gross, company, runtime));
                }
                uniqueTitle.add(title);
                // System.out.print("There are " + incompleteCount + " rows of incompleted data ");
                // System.out.println("from " + rowCount + " rows. (" + uniqueTitle.size() + ") unique titles.");
                // System.out.println("list size is " + mList.size());
            }
            
        } catch (IOException e) {
            System.out.println("from IO error");
            e.printStackTrace();
        }
    
    }

    private static String parseDouble(String str)
    {
        if(str.isEmpty())
            return ".0";
        return str;
    }

    public void q1()
    {
        Double average = mList.stream().mapToDouble(m -> m.getScore()).average().getAsDouble();
        System.out.println("q1 average is " + average);
    }

    public void q2()
    {
        CSMovie[] res = mList.stream().filter(mv -> mv.getVotes() > 1_900_000).toArray(CSMovie[] :: new);
        for(CSMovie m : res)
            System.out.println(m);
    }

    public void q3()
    {
        Optional<CSMovie> maxGross = mList.stream().max(Comparator.comparing(CSMovie :: getGross));
        System.out.println(maxGross);

    }

    public void q4()
    {
        Map<String, List<CSMovie>> movie_genre = mList.stream().collect(Collectors.groupingBy(CSMovie :: getGenre));
        System.out.println(movie_genre.keySet());
    }

    public void q5()
    {
        List<String> nameList = mList.stream().sorted(Comparator.comparing(CSMovie :: getRuntime)).map(e -> String.format("%-55s --> %s", e.getTitle(), e.getRuntime())).toList();
        int count = 0;
        for(String name : nameList)
        {
            if(count == 5)
                break;
            System.out.println(name);
            count++;
        }
    }

    public void q6()
    {
        Optional<CSMovie> maxBudget = mList.stream().max(Comparator.comparing(CSMovie :: getBudget));
        System.out.println("max budget");
        System.out.println(String.format("%-55s --> %s", maxBudget.get().getTitle(), maxBudget.get().getRuntime()));
        Optional<CSMovie> minBudget = mList.stream().min(Comparator.comparing(CSMovie :: getBudget));
        System.out.println("min budget");
        System.out.println(String.format("%-55s --> %s", minBudget.get().getTitle(), minBudget.get().getRuntime()));
    }

    public void q7()
    {
        List<String> genreList = mList.stream().sorted(Comparator.comparing(CSMovie :: getScore).reversed()).map(e -> String.format("%-55s --> %s", e.getGenre(), e.getScore())).toList();
        int count = 0;
        for(String movie : genreList)
        {
            if(count == 3)
                break;
            System.out.println(movie);
            count++;
        }
    }

    public void q8()
    {
        Map<String, List<CSMovie>> movie_genre = mList.stream().collect(Collectors.groupingBy(CSMovie :: getGenre));
        List<String> action_movie = movie_genre.get("Action").stream().sorted(Comparator.comparing(CSMovie :: getScore).reversed().thenComparing(CSMovie :: getTitle)).map(e -> String.format("%-55s --> %s", e.getTitle(), e.getScore())).toList();
        int count = 0;
        for(String movie : action_movie)
        {
            if(count == 3)
                break;
            System.out.println(movie);
            count++;
        }
    }

    public void q9()
    {
        Map<String, List<CSMovie>> movie_genre = mList.stream().collect(Collectors.groupingBy(CSMovie :: getGenre));
        for(String genre : movie_genre.keySet())
        {
            Long total_gross = movie_genre.get(genre).stream().collect(Collectors.summingLong(e -> e.getGross()));
            System.out.println(String.format("total gross of %s movie is %,d", genre, total_gross));
        }
    }

    public void q10()
    {
        Map<String, List<CSMovie>> Company = mList.stream().collect(Collectors.groupingBy(CSMovie :: getCompany));
        List<Long> movies = new ArrayList<>();
        for(String company : Company.keySet())
        {
            movies.add(Company.get(company).stream().count());
        }
        Map<String, Long> unorderedMap = new HashMap<>();
        int i = 0;
        for(String company : Company.keySet())
        {
            unorderedMap.put(company, movies.get(i));
            i++;
        }
        Map<String, Long> orderedMap = unorderedMap.entrySet().stream().sorted(Collections.reverseOrder(Entry.comparingByValue(Long :: compareTo))).collect(Collectors.toMap(Entry :: getKey, Entry :: getValue, (e1, e2) -> e1, LinkedHashMap :: new));
        int count = 0;
        for(Entry entry : orderedMap.entrySet())
        {
            if(count == 10)
                break;
            System.out.println(entry.getKey() + " " + entry.getValue());
            count++;
        }
    }

    public void q11()
    {
        Function<String, Integer> numWords = entry -> 
        {
            int count = 0;
            for(int i = 0; i < entry.length(); i++)
            {
                if(entry.charAt(i) == 'a')
                    count++;
            }
            return count;
        };

        Optional<CSMovie> opt = mList.stream().max(Comparator.comparing(CSMovie :: getTitle));
        System.out.println(opt.get());
    }

    private static void hintQ10()
    {
        Map<String, Integer> unordered = new HashMap<>();
        unordered.put("A", 12);
        unordered.put("C", 7);
        unordered.put("B", 20);

        Map<String, Integer> orderByValueMap;
        orderByValueMap = unordered.entrySet().stream().sorted(Entry.comparingByValue()).collect(Collectors.toMap(Entry :: getKey, Entry :: getValue, (e1, e2) -> e1, LinkedHashMap :: new));
        for(Entry entry : orderByValueMap.entrySet())
            System.out.println(entry.getKey() + " " + entry.getValue());

        Map<String, Long> unorderedLong = new HashMap<>();
            unorderedLong.put("D", 12L);
            unorderedLong.put("E", 7L);
            unorderedLong.put("F", 20L);
        
        Map<String, Long> longAndReverseMap;
        longAndReverseMap = unorderedLong.entrySet().stream().sorted(Collections.reverseOrder(Entry.comparingByValue(Long :: compareTo))).collect(Collectors.toMap(Entry :: getKey, Entry :: getValue, (e1, e2) -> e1, LinkedHashMap :: new));

        for(Entry entry : longAndReverseMap.entrySet())
            System.out.println(entry.getKey() + " " + entry.getValue());
    }

    private static void hintQ11()
    {
        Function<String, Integer> numWords = entry -> 
        {
            int count = 0;
            for(int i = 0; i < entry.length(); i++)
            {
                if(entry.charAt(i) == 'a')
                    count++;
            }
            return count;
        };

        List<String> data = Arrays.asList("aaa", "a", "aaaa");

        Optional<String> opt = data.stream().max(Comparator.comparing(numWords));

        System.out.println(opt.get());
    }
}
