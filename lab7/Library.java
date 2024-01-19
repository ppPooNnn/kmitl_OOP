import java.util.HashMap;

public class Library 
{
    private static final HashMap<Integer, Book> allBooks = new HashMap<>();

    static
    {
        allBooks.put(1,new LibraryBook(1, null, "Charlotte's Web","EB White","abc",1952,100,PrintType.PRINT));
        allBooks.put(2,new LibraryBook(2, null, "Charlotte's Web","EB White","abc",1952,100,PrintType.ECOPY));
        allBooks.put(3,new LibraryBook(3, null, "The BFG","Roald Dahl","abc",1982,300,PrintType.PRINT));
        allBooks.put(4,new LibraryBook(4, null, "The Little Prince","Antoine de Saint-Exupéry","abc",1943,200,PrintType.ECOPY));
        allBooks.put(5,new ArchiveMaterial(5, null, "My Mister","not KBS","abc",2018,400,Status.READY));
        allBooks.put(6,new ArchiveMaterial(6, null, "Sword Snow Stride","CNTV","abc",2018,500,Status.REPAIRED));
    }

    public void printAllItems()
    {
        for(Book b : allBooks.values())
            System.out.println(b);
    }

    public Book getBookById(int id)
    {
        return allBooks.get(id);
    }

    public boolean checkOut (Book item, int yy, int mm, int dd)
    {
        if(!(item instanceof ArchiveMaterial))
            return ((LibraryBook)item).checkoutItem(yy, mm, dd);
        return false;
    }

    public void checkIn(Book item, int yy, int mm, int dd)
    {

        if(((LibraryBook)item).isAvailable() == true)
        {
            System.out.println("The item has not been check out");
            return;
        }

        int daysBetween = ((LibraryBook)item).returnItem(yy, mm, dd);
        
        if(daysBetween < 7)
            System.out.println("see you next time");
        else
            System.out.println("pay fine for " + daysBetween + " days.");
    }
}
