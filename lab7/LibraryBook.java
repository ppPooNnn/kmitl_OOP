import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LibraryBook extends Book implements BorrowAble
{
    private int id;
    private boolean availForBorrow = true;
    private LocalDate dateBorrow;

    private PrintType type;

    public LibraryBook(int id, String isbn, String title, String author, String publisher, int yr, int numPages, PrintType type)
    {
        super(isbn, title, author, publisher, yr, numPages);
        this.id = id;
        this.type = type;
    }

    public void setBookAvailableFalse()
    {
        this.availForBorrow = false;
    }

    public void setBookAvailableTrue()
    {
        this.availForBorrow = false;
    }

    public boolean isAvailable()
    {
        return this.availForBorrow;
    }

    public PrintType getPrintType()
    {
        return this.type;
    }

    public boolean checkoutItem(int yy, int mm, int dd)
    {
        if(this.isAvailable() == true && type == PrintType.PRINT)
        {
            this.dateBorrow = LocalDate.of(yy,mm,dd);
            this.setBookAvailableFalse();
            return true;
        }
        return false;
    }

    public int returnItem(int yy, int mm, int dd)
    {
        LocalDate today = LocalDate.of(yy,mm,dd);
        long daysBetween = ChronoUnit.DAYS.between(dateBorrow, today);
        if(this.isAvailable() == false && daysBetween > 7)
        {
            return (int)daysBetween - 7;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "LibraryBook [id=" + id + ", title=" + title + ", type = " + type +  ", avail = " + availForBorrow +"]";
    }
}
