package pl.lublin.wsei.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Noblista {
    private String firstname;
    private String surname;
    private int year;
    private String category;
    private String motivation;
    private String country;
    private String dataRow;

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


    public String getFirstname() {
        return firstname;
    }


    public String getSurname() {
        return surname;
    }

    public int getYear() {
        return year;
    }


    public String getCategory() {
        return category;
    }


    public String getMotivation() {
        return motivation;
    }


    public String getCountry() {
        return country;
    }


    public String getDataRow() {
        return dataRow;
    }

}
