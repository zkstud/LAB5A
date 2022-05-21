package pl.lublin.wsei.java.test;

import pl.lublin.wsei.java.Noblista;

public class TestNoblista {
    public static void main(String[] args) {
        String tekst = "id,firstname,surname,born,died,bornCountry,bornCountryCode,bornCity,diedCountry,diedCountryCode,diedCity,gender,year,category,overallMotivation,share,motivation,name,city,country\n" +
                "846,Elinor,Ostrom,8/7/1933,6/12/2012,USA,US,\"Los Angeles, CA\",USA,US,\"Bloomington, IN\",female,2009,economics,,2,\"\"\"for her analysis of economic governance, especially the commons\"\"\",Indiana University,\"Bloomington, IN\",USA\n" +
                "846,Elinor,Ostrom,8/7/1933,6/12/2012,USA,US,\"Los Angeles, CA\",USA,US,\"Bloomington, IN\",female,2009,economics,,2,\"\"\"for her analysis of economic governance, especially the commons\"\"\",Arizona State University,\"Tempe, AZ\",USA\n" +
                "783,Wangari Muta,Maathai,4/1/1940,9/25/2011,Kenya,KE,Nyeri,Kenya,KE,Nairobi,female,2004,peace,,1,\"\"\"for her contribution to sustainable development, democracy and peace\"\"\",,,\n" +
                "230,Dorothy Crowfoot,Hodgkin,5/12/1910,7/29/1994,Egypt,EG,Cairo,United Kingdom,GB,Shipston-on-Stour,female,1964,chemistry,,1,\"\"\"for her determinations by X-ray techniques of the structures of important biochemical substances\"\"\",\"University of Oxford, Royal Society\",Oxford,United Kingdom\n" +
                "918,Youyou,Tu,12/30/1930,0000-00-00,China,CN,Zhejiang Ningbo,,,,female,2015,medicine,,2,\"\"\"for her discoveries concerning a novel therapy against Malaria\"\"\",China Academy of Traditional Chinese Medicine,Beijing,China\n" +
                "428,Barbara,McClintock,6/16/1902,9/2/1992,USA,US,\"Hartford, CT\",USA,US,\"Huntington, NY\",female,1983,medicine,,1,\"\"\"for her discovery of mobile genetic elements\"\"\",Cold Spring Harbor Laboratory,\"Cold Spring Harbor, NY\",USA\n" +
                "773,Shirin,Ebadi,6/21/1947,0000-00-00,Iran,IR,Hamadan,,,,female,2003,peace,,1,\"\"\"for her efforts for democracy and human rights. She has focused especially on the struggle for the rights of women and children\"\"\",,,\n" +
                "597,Grazia,Deledda,09/27/1871,8/15/1936,Italy,IT,\"Nuoro, Sardinia\",Italy,IT,Rome,female,1926,literature,,1,\"\"\"for her idealistically inspired writings which with plastic clarity picture the life on her native island and with depth and sympathy deal with human problems in general\"\"\",,,\n" +
                "615,Gabriela,Mistral,04/07/1889,1/10/1957,Chile,CL,Vicu_a,USA,US,\"Hempstead, NY\",female,1945,literature,,1,\"\"\"for her lyric poetry which, inspired by powerful emotions, has made her name a symbol of the idealistic aspirations of the entire Latin American world\"\"\",,,\n" +
                "782,Elfriede,Jelinek,10/20/1946,0000-00-00,Austria,AT,Môrzzuschlag,,,,female,2004,literature,,1,\"\"\"for her musical flow of voices and counter-voices in novels and plays that with extraordinary linguistic zeal reveal the absurdity of society's clich&eacute;s and their subjugating power\"\"\",,,\n" +
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
//        System.out.println(tekst);
        Noblista noblista = new Noblista(tekst);
        noblista.print();
    }
}
