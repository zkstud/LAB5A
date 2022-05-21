package pl.lublin.wsei.java.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestFileRead {
    public static void main(String[] args) {
        try{
        String contents = new String(Files.readAllBytes(Paths.get("C:\\Users\\ZAKHAR\\IdeaProjects\\LAB5A\\nobel_prize_by_winner.csv")));
        System.out.println("ZAWARTOSC PLIKU nobel_prize_by_winner.csv");
        System.out.println(contents);
        }catch (IOException e){
            System.out.println("Blad wczytywania pliku nobel_prize_by_winner.csv =>" + e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
