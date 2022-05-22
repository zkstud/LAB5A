package pl.lublin.wsei.java.test;

import pl.lublin.wsei.java.Noblista;
import pl.lublin.wsei.java.ListNoblista;

public class TestNoblistaList {
    public static void main(String[] args) {
        ListNoblista list = new ListNoblista("C:\\Users\\ZAKHAR\\IdeaProjects\\LAB5A\\nobel_prize_by_winner.csv");
        for (Noblista n: list.noblisci) n.print();
    }
}
