package pl.lublin.wsei.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ListNoblista {
    public ArrayList<Noblista> noblisci = new ArrayList<>();

    public ListNoblista(String noblFileName){
//        noblisci = new ArrayList<>();
        String contents;
        try{
            contents = new String(Files.readAllBytes(Paths.get(noblFileName)));
        } catch (IOException e) {
            System.out.println("Blad wczytywania pliku nobel_prize_by_winner.csv => " + e.getLocalizedMessage());
            e.printStackTrace();
            contents = "";
        }

        String[] items = contents.split("\\r\\n");
        for (int i = 0; i < items.length; i++) {
            noblisci.add(new Noblista(items[i]));
        }
    }

    public ArrayList<Noblista> getNoblisci() {
        return noblisci;
    }

    public void setNoblisci(ArrayList<Noblista> noblisci) {
        this.noblisci = noblisci;
    }
}
