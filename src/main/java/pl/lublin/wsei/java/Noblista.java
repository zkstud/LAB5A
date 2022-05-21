package pl.lublin.wsei.java;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Noblista {
    public String firstname;
    public String surname;
    public int year;
    public String category;
    public String motivation;
    public String country;
    public String dataRow;

    public Noblista(String tekst) {
        Pattern pat = Pattern.compile("[\\d|\\d{2}|\\d{3}]\\,(.*)\\,(\\w+|\\w+\\s\\w+|\\w+\\s\\w..|\\w+\\-\\w+|\\w+|)(\\,|\\.)(\\d\\/|\\d{2}\\/)");
        Matcher m = pat.matcher(tekst);
        if (m.find()) {
            firstname = m.group(1);
        } else firstname = "";

        pat = Pattern.compile("(\\w|\\.|\\ )\\,(\\w+|\\w+\\s\\w+|\\w+\\s\\w..|\\w+\\-\\w+)(\\,|\\.)(\\d\\/|\\d{2}\\/)");
        m = pat.matcher(tekst);
        if (m.find()) {
            surname = m.group(2);
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
        } else category = "No data.";

        pat = Pattern.compile("\\\"\\\"\\\"(.*)\\\"\\\"\\\"");
        m = pat.matcher(tekst);
        if (m.find()) {
            motivation = m.group(1);
        } else motivation = "No data.";

        pat = Pattern.compile("(?!.*\\.\\.)(?!.*\\.$)[^\\W][\\w.]{0,29}$");
        m = pat.matcher(tekst);
        if (m.find()) {
            country = m.group(0);
        } else country = "No data.";

        dataRow = firstname + "," + surname + "," + year + "," + category + ",\"" + motivation + "\"," + country;
    }

    public void print() {
        System.out.println(dataRow);
    }
}
