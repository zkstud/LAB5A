package pl.lublin.wsei.java.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegEx {
    public static void main(String[] args) {
        String tekst = "id,firstname,surname,born,died,bornCountry,bornCountryCode,bornCity,diedCountry,diedCountryCode,diedCity,gender,year,category,overallMotivation,share,motivation,name,city,country\n" +
                "553,Aung San Suu Kyi,,6/19/1945,0000-00-00,Burma (now Myanmar),MM,Rangoon (now Yangon),,,,female,1991,peace,,1,\"\"\"for her non-violent struggle for democracy and human rights\"\"\",,,\n" +
                "640,Nelly,Sachs,12/10/1891,5/12/1970,Germany,DE,Berlin,Sweden,SE,Stockholm,female,1966,literature,,2,\"\"\"for her outstanding lyrical and dramatic writing, which interprets Israel's destiny with touching strength\"\" \",,,\n" +
                "924,Svetlana,Alexievich,5/31/1948,0000-00-00,Ukraine,UA,Ivano-Frankivsk,,,,female,2015,literature,,1,\"\"\"for her polyphonic writings, a monument to suffering and courage in our time\"\"\",,,\n" +
                "610,Pearl,Buck,06/26/1892,3/6/1973,USA,US,\"Hillsboro, WV\",USA,US,\"Danby, VT\",female,1938,literature,,1,\"\"\"for her rich and truly epic descriptions of peasant life in China and for her biographical masterpieces\"\"\",,,\n" +
                "673,Wislawa,Szymborska,7/2/1923,2/1/2012,Poland,PL,Bnin (now K„rnik),Poland,PL,Krak„w,female,1996,literature,,1,\"\"\"for poetry that with ironic precision allows the historical and biological context to come to light in fragments of human reality\"\"\",,,\n" +
                "843,Ada E.,Yonath,6/22/1939,0000-00-00,British Mandate of Palestine (now Israel),IL,Jerusalem,,,,female,2009,chemistry,,3,\"\"\"for studies of the structure and function of the ribosome\"\"\",Weizmann Institute of Science,Rehovot,Israel\n" +
                "413,Rosalyn,Yalow,7/19/1921,5/30/2011,USA,US,\"New York, NY\",USA,US,\"New York, NY\",female,1977,medicine,,2,\"\"\"for the development of radioimmunoassays of peptide hormones\"\"\",Veterans Administration Hospital,\"Bronx, NY\",USA\n" +
                "836,Carol W.,Greider,4/15/1961,0000-00-00,USA,US,\"San Diego, CA\",,,,female,2009,medicine,,3,\"\"\"for the discovery of how chromosomes are protected by telomeres and the enzyme telomerase\"\"\",Johns Hopkins University School of Medicine,\"Baltimore, MD\",USA\n" +
                "835,Elizabeth H.,Blackburn,11/26/1948,0000-00-00,Australia,AU,\"Hobart, Tasmania\",,,,female,2009,medicine,,3,\"\"\"for the discovery of how chromosomes are protected by telomeres and the enzyme telomerase\"\"\",University of California,\"San Francisco, CA\",USA\n" +
                "79,Maria,Goeppert Mayer,6/28/1906,2/20/1972,Germany (now Poland),PL,Kattowitz (now Katowice),USA,US,\"San Diego, CA\",female,1963,physics,,4,\"\"\"for their discoveries concerning nuclear shell structure\"\"\",University of California,\"La Jolla, CA\",USA\n" +
                "453,Christiane,Nôsslein-Volhard,10/20/1942,0000-00-00,Germany,DE,Magdeburg,,,,female,1995,medicine,,3,\"\"\"for their discoveries concerning the genetic control of early embryonic development\"\"\",Max-Planck-Institut fôr Entwicklungsbiologie,Tôbingen,Federal Republic of Germany\n" +
                "904,May-Britt,Moser,1/4/1963,0000-00-00,Norway,NO,Fosnavëg,,,,female,2014,medicine,,4,\"\"\"for their discoveries of cells that constitute a positioning system in the brain\"\"\",Norwegian University of Science and Technology (NTNU),Trondheim,Norway\n" +
                "435,Rita,Levi-Montalcini,4/22/1909,12/30/2012,Italy,IT,Turin,Italy,IT,Rome,female,1986,medicine,,2,\"\"\"for their discoveries of growth factors\"\"\",Institute of Cell Biology of the C.N.R.,Rome,Italy";

        String s;
        Pattern pat = Pattern.compile("\\n(\\d{3}|\\d{1}|\\d{2})\\,(\\w+\\-\\w+\\s\\w+|\\w+\\-\\w+|\\w+|\\w+\\s\\w+|\\w+\\s\\w+\\s\\w+|\\w+\\s\\w+\\s\\w+\\s\\w+)(\\,|\\.)");
        Matcher m = pat.matcher(tekst);
        if (m.find()) {
            s = m.group(2);
            System.out.println("Znaleziono tytul: " + s);
        } else System.out.println("Nie znaleziono tytulu ... ");
    }
}
