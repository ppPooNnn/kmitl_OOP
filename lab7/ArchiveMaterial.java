public class ArchiveMaterial extends Book
{
    private int id;
    
    private Status status;

    public ArchiveMaterial(int id, String isbn, String title, String author, String publisher, int yr, int numPages, Status status)
    {
        super(isbn, title, author, publisher, yr, numPages);
        this.id = id;
        this.status = status;
    }

    @Override
    public String toString() {
        return "ArchiveMaterial [id=" + id + ", title = " + title + ", status = " + status + ", message = I am glad you pick me. ]";
    }
}
