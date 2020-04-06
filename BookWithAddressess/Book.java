package com.company;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Book {
    private String line="";
    List<Person> Book = new LinkedList<>();
    BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));

    void add() {
        Person P = new Person();
        System.out.println("Dane beda pobierane w nastepujacej kolejności: imię, nazwisko, nr telefonu, ulica, nr domu, nr mieszkania, kod oraz urzad pocztowy.");
        System.out.println("Jesli chcesz pominąć którąś z informacji, wpisz -.");
        try {
            System.out.println("Podaj imie: ");
            line = inbr.readLine();
            P.setName(line);

            System.out.println("Podaj nazwisko: ");
            line = inbr.readLine();
            P.setSurname(line);

            System.out.println("Podaj numer telefonu: ");
            line = inbr.readLine();
            P.setPhone(line);

            System.out.println("Podaj ulice: ");
            line = inbr.readLine();
            P.setStreet(line);

            System.out.println("Podaj numer domu: ");
            line = inbr.readLine();
            P.setHouseNr(line);

            System.out.println("Podaj numer mieszkania: ");
            line = inbr.readLine();
            P.setFlatNr(line);

            System.out.println("Podaj kod pocztowy: ");
            line = inbr.readLine();
            P.setPostCode(line);

            System.out.println("Podaj urzad pocztowy:");
            line = inbr.readLine();
            P.setPostOffice(line);
         } catch (IOException e) {
             System.out.println("Blad odczytu.");
         }
         Book.add(P);
         line = "";
     }


    void remove() {
         Reader r = new BufferedReader(new InputStreamReader(System.in));
         StreamTokenizer inp = new StreamTokenizer(r);
         try {
             System.out.println("Podaj numer w ksiazce adresowej (liczbe calkowita) osoby, ktora chcesz usunac ze spisu: ");
             while(inp.nextToken() != StreamTokenizer.TT_NUMBER || ((int) inp.nval) < 1 || ((int) inp.nval) > Book.size()) {
                 System.out.println("To nie jest liczba calkowita z ksiazki adresowej. Sprobuj jeszcze raz: ");
             }
             Book.remove((int) inp.nval - 1);
         } catch (IOException e) {
             System.out.println("Blad odczytu.");
         }
     }


     void modify() {
         Reader r = new BufferedReader(new InputStreamReader(System.in));
         StreamTokenizer inp = new StreamTokenizer(r);
         Reader d = new BufferedReader(new InputStreamReader(System.in));
         StreamTokenizer ind = new StreamTokenizer(d);
         boolean done = false;
         try {
             System.out.println("Podaj numer w ksiazce adresowej (liczbe calkowita) osoby, ktorej wpis chcesz zmodyfikowac: ");
             while(inp.nextToken() != StreamTokenizer.TT_NUMBER || ((int) inp.nval) < 1 || ((int) inp.nval) > Book.size()) {
                 System.out.println("To nie jest liczba calkowita z ksiazki adresowej. Sprobuj jeszcze raz: ");
             }
             int a = (int) inp.nval - 1;
             while(!done) {
                 System.out.println("Jakie zmiany chcesz wprowadzic?");
                 System.out.println("1 -> Chce zmienic imie.");
                 System.out.println("2 -> Chce zmienic nazwisko.");
                 System.out.println("3 -> Chce zmienic numer telefonu.");
                 System.out.println("4 -> Chce zmienic ulice.");
                 System.out.println("5 -> Chce zmienic numer domu.");
                 System.out.println("6 -> Chce zmienic numer mieszkania.");
                 System.out.println("7 -> Chce zmienic kod pocztowy.");
                 System.out.println("8 -> Chce zmienic urzad pocztowy.");
                 System.out.println("Inny dowolny znak -> koniec zmian.");
                 if (ind.nextToken() != StreamTokenizer.TT_NUMBER) { break; }
                 switch((int) ind.nval)
                 {
                     case 1:
                         System.out.println("Podaj imie: ");
                         line = inbr.readLine();
                         Book.get(a).setName(line);
                         break;
                     case 2:
                         System.out.println("Podaj nazwisko: ");
                         line = inbr.readLine();
                         Book.get(a).setSurname(line);
                         break;
                     case 3:
                         System.out.println("Podaj numer telefonu: ");
                         line = inbr.readLine();
                         Book.get(a).setPhone(line);
                         break;
                     case 4:
                         System.out.println("Podaj ulice: ");
                         line = inbr.readLine();
                         Book.get(a).setStreet(line);
                         break;
                     case 5:
                         System.out.println("Podaj numer domu: ");
                         line = inbr.readLine();
                         Book.get(a).setHouseNr(line);
                         break;
                     case 6:
                         System.out.println("Podaj numer mieszkania: ");
                         line = inbr.readLine();
                         Book.get(a).setFlatNr(line);
                         break;
                     case 7:
                         System.out.println("Podaj kod pocztowy: ");
                         line = inbr.readLine();
                         Book.get(a).setPostCode(line);
                         break;
                     case 8:
                         System.out.println("Podaj urzad pocztowy: ");
                         line = inbr.readLine();
                         Book.get(a).setPostOffice(line);
                         break;
                     default:
                         done = true;
                         break;
                 }
             }
         } catch (IOException e) {
             System.out.println("Blad odczytu.");
         }
     }


    void displayBook() {
        System.out.println("   Nr   Imie   Nazwisko   Telefon   Ulica   Nr domu   Nr mieszkania   Kod pocztowy   Urzad pocztowy");
        for(Person P: Book) {
            System.out.println("   "+(Book.indexOf(P)+1)+"    "+P.getName()+"   "+P.getSurname()+"   "+P.getPhone()+"   "+P.getStreet()+"   "+P.getHouseNr()+"   "+P.getFlatNr()+"   "+P.getPostCode()+"   "+P.getPostOffice());
        }
    }


    void save(){
        File plik = new File("dane.txt");
         try {
             PrintWriter zapis = new PrintWriter("dane.txt");
             for(Person P: Book){
             zapis.println((Book.indexOf(P)+1)+" "+P.getName()+" "+P.getSurname()+" "+P.getPhone()+" "+P.getStreet()+" "+P.getHouseNr()+" "+P.getFlatNr()+" "+P.getPostCode()+" "+P.getPostOffice());
            }
            zapis.close();
         } catch(FileNotFoundException e) {
             System.err.println("Nie znaleziono pliku.");
             System.exit(-1);
         }
    }

    void load() {
        try {
            Scanner odczyt = new Scanner(new File("dane.txt"));
            String text = odczyt.nextLine();
            while (text != null) {
                String words[]= text.split(" ");
                Person S = new Person(words[1], words[2], words[3], words[4], words[5], words[6], words[7], words[8]);
                Book.add(S);
                text = odczyt.nextLine();
            }
        } catch(FileNotFoundException e) {
            System.err.println("Nie znaleziono pliku.");
            System.exit(-1);
        } catch(NoSuchElementException s) {
            System.out.print("");
        }
    }


    void sort() {
        if (Book.size() > 0) {
            Collections.sort(Book, new Comparator<Person>() {
                @Override
                public int compare(final Person object1, final Person object2) {
                    if (object1.getSurname().equals(object2.getSurname()))
                        return  object1.getName().compareTo(object2.getName());
                    else
                        return object1.getSurname().compareTo(object2.getSurname());
                   }
               });
           }
    }


    void searchBySurname() {
        try {
            BufferedReader inn = new BufferedReader(new InputStreamReader(System.in));
            boolean flagone = true, flagtwo = true;
            System.out.println("Kogo chcesz wyszukac? Podaj nazwisko: ");
            line = inn.readLine();
            for (Person P: Book) {
                if (line.equals(P.getSurname())) {
                    if (flagone) { System.out.println("   Nr   Imie   Nazwisko   Telefon   Ulica   Nr domu   Nr mieszkania   Kod pocztowy   Urzad pocztowy"); flagone = false; }
                    System.out.println("   " + (Book.indexOf(P) + 1) + "    " + P.getName() + "   " + P.getSurname() + "   " + P.getPhone() + "   " + P.getStreet() + "   " + P.getHouseNr() + "   " + P.getFlatNr() + "   " + P.getPostCode() + "   " + P.getPostOffice());
                    flagtwo = false;
                }
            }
            if (flagtwo) System.out.println("Nie ma takiego nazwiska. Przykro.");
        } catch(IOException e) {
            System.err.println("Dramat.");
        }
    }

}

