import java.util.ArrayList;

class Lab1Coder
{
    private String name;
    int experience;
    ArrayList<String> languages = new ArrayList<String>();

    Lab1Coder(String n, int exp)
    {
        this.name = n;
        this.experience = exp;
    }

    Lab1Coder()
    {

    }

    Lab1Coder(String n)
    {
        this.name = n;
        this.experience = 0;
    }

    void setName(String name)
    {
        this.name = name;
    }

    String getName()
    {
        return this.name;
    }

    void setExperience(int experience) 
    {
        this.experience = experience;
    }

    int getExperience()
    {
        return this.experience;
    }

    void setLanguages(String ...lang)
    {
        for(String str : lang)
            this.languages.add(str);
    }

    ArrayList<String> getLanguages()
    {
        return this.languages;
    }

    public String toString()
    {
        String know_langs = "";
        for(String str : this.languages)
        {
            know_langs += str;
            know_langs += " ";
        }
        return this.name + "(" + this.experience + ") " + "knows " + know_langs;
    }

    ArrayList<String> findCommonLanguage(Lab1Coder other)
    {
        ArrayList<String> common_lang = new ArrayList<String>();
        for(String str1 : this.languages)
        {
            for(String str2 : other.languages)
            {
                if(str1.equals(str2))
                {
                    common_lang.add(str1);
                    break;
                }
            }
        }
        if(common_lang.size() == 0)
            common_lang.add("none");
        return common_lang;
    }
}