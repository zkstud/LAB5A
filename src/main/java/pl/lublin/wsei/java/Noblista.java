package pl.lublin.wsei.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Noblista {
    public String firstname;
    public String surname;
    public int year;
    public String category;
    public String motivation;
    public String country;
//    public String dataRow;

    //TUTAJ KONSTRUKTOR Z REGEX
    public Noblista(String tekst) {
        Pattern pat = Pattern.compile("\\n\\d{3}\\,(\\w+|\\w+\\s\\w+)(\\.|\\,)");
        Matcher m = pat.matcher(tekst);
        if (m.find()) {
            firstname = m.group(1);
        } else firstname = "";

        pat = Pattern.compile("\\,(\\w+|\\w+\\s\\w+|\\w+\\-\\w+)\\,\\d");
        m = pat.matcher(tekst);
        if (m.find()) {
            surname = m.group(1);
        } else surname = "";

        pat = Pattern.compile("\\,(\\d...)\\,");
        m = pat.matcher(tekst);
        if (m.find()) {
            year = Integer.parseInt(m.group(1));
        } else year = 0;

        pat = Pattern.compile("\\,(\\w+)\\,\\,\\d");
        m = pat.matcher(tekst);
        if (m.find()) {
            category = m.group(1);
        } else category = "";

        pat = Pattern.compile("\\\"\\\"\\\"(.*)\\\"\\\"\\\"");
        m = pat.matcher(tekst);
        if (m.find()) {
            motivation = m.group(1);
        } else motivation = "";

        pat = Pattern.compile("[^country]\\,(\\w+\\s\\w+|\\w+)\\n");
        m = pat.matcher(tekst);
        if (m.find()) {
            country = m.group(1);
        } else country = "";
    }

    public void print() {
        System.out.println(firstname + "\n" + surname + "\n" + year + "\n" + category + "\n" + motivation + "\n" + country + "\n\n");
    }
}
