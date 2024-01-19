abstract class Book extends Library
{
    protected String isbn;
    protected String title;
    protected String author;
    protected String publisher;
    protected int year;
    protected int numberOfPage;
    private int currentPageNumber;

    public Book()
    {

    }

    public Book(String isbn, String title, String author, String publisher, int yr, int numPages)
    {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = yr;
        this.numberOfPage = numPages;
    }

    public void turnPageForward()
    {
        this.currentPageNumber += 1;
    }

    public void turnPageBackward()
    {
        this.currentPageNumber -= 1;
    }

    public int nowAtPage()
    {
        return currentPageNumber;
    }

    public String getTitle()
    {
        return this.title;
    }

    @Override
    public String toString() {
        return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", publisher=" + publisher + ", year="
                + year + ", numberOfPage=" + numberOfPage + ", currentPageNumber=" + currentPageNumber + "]";
    }

}