package pl.lublin.wsei.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Noblista {
    public String firstname;
    public String surname;
    public String year;
    public String category;
    public String motivation;
    public String country;
//    public String dataRow;

    //TUTAJ REGEX
    public Noblista(String tekst) {
        Pattern pat = Pattern.compile("");
        Matcher m = pat.matcher(tekst);
        if (m.find()) {
            firstname = m.group(1);
        } else firstname = "";
    }

}
