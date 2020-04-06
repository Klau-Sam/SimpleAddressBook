package com.company;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
	// write your code here
        boolean start = true;
        Book Add = new Book();
        Reader k = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer ink = new StreamTokenizer(k);
        System.out.println("Witaj w ksiazce adresowej. Czym chcialbys sie dzisiaj zajac?");
        Add.load();
        Add.sort();
        try {
            while(start) {
                System.out.println("1 -> Chce wyswietlic wszystkie wpisy.");
                System.out.println("2 -> Chce dodac wpis.");
                System.out.println("3 -> Chce zmodyfikowac wpis.");
                System.out.println("4 -> Chce usunac wpis.");
                System.out.println("5 -> Chce wyszukac kogos po nazwisku.");
                System.out.println("Inny dowolny znak -> koniec zabawy.");
                if (ink.nextToken() != StreamTokenizer.TT_NUMBER) { Add.save(); System.out.println("Twoja ksiazka adresowa zostala automatycznie zapisana w pliku. Papa!"); break; }
                switch((int) ink.nval)
                {
                    case 1:
                        Add.displayBook();
                        System.out.println("");
                        System.out.println("Coś jeszcze?");
                        break;
                    case 2:
                        Add.add();
                        Add.sort();
                        System.out.println("");
                        System.out.println("Coś jeszcze?");
                        break;
                    case 3:
                        Add.displayBook();
                        System.out.println("");
                        Add.modify();
                        Add.sort();
                        System.out.println("Wpis zmodyfikowany.");
                        System.out.println("");
                        System.out.println("Coś jeszcze?");
                        break;
                    case 4:
                        Add.displayBook();
                        System.out.println("");
                        Add.remove();
                        System.out.println("Wpis usunięty.");
                        System.out.println("");
                        System.out.println("Coś jeszcze?");
                        break;
                    case 5:
                        Add.searchBySurname();
                        System.out.println("");
                        System.out.println("Coś jeszcze?");
                        break;
                    default:
                        Add.save();
                        System.out.println("Twoja ksiazka adresowa zostala automatycznie zapisana w pliku. Papa!");
                        start = false;
                        break;
                }
            }
        } catch(IOException e) {
            System.out.println("Blad odczytu.");
        }

    }
}
