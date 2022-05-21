package pl.lublin.wsei.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class NoblistaList {
    public ArrayList<Noblista> noblisci;

    public NoblistaList(String noblFileName){
        noblisci = new ArrayList<>();
        String contents;
        try{
            contents = new String(Files.readAllBytes(Paths.get(noblFileName)));
        } catch (IOException e) {
            System.out.println("Blad wczytywania pliku nobel_prize_by_winner.csv => " + e.getLocalizedMessage());
            e.printStackTrace();
            contents = "";
        }

        String[] items = contents.split("\\r\\n"); //SPLIT-rozdelitel strok //brak rozlacza
        for (int i = 0; i < items.length; i++) {
            noblisci.add(new Noblista(items[i]));
        }
    }
}
