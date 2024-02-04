class Singer
{
    String name;
    Style style;
    
    Singer(String n, Style style)
    {
        this.name = n;
        this.style = style;
    }

    String getName()
    {
        return this.name;
    }

    String getStyle()
    {
        return style.toString();
    }

    public String toString()
    {
        return String.format("Singer (%s - Sing Style.%s)", this.getName(), this.getStyle());
    }

    public int compareByName(Singer s)
    {
        return name.compareTo(s.getName());
    }
}

enum Style
{
    POP, ROCK;

    public String toString()
    {
        switch(this.ordinal()) {
            case 0 :
                return "POP";
            case 1 :
                return "ROCK";
            default :
                return null;
        }
    }
}