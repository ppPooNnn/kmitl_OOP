public enum Status 
{
    READY("READY"), REPAIRED("REPAIRED");

    private String status;

    private Status(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return this.status;
    }
}
