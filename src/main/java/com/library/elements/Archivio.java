package com.library.elements;
import java.util.*;

public class Archivio {
    private Map<String, Libro> elementi = new HashMap<>();
    private String confirm;
    private int choice;


    public void createElement(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Cosa vorresti creare? 1. Libro       2. Rivista");
                choice = scanner.nextInt();
                if (choice == 1 || choice == 2) {
                    break;
                } else {
                    System.out.println("Scelta non valida. Inserisci 1 per Libro o 2 per Rivista.");
                }
            } catch (Exception e) {
                System.out.println("Input non valido. Inserisci un numero (1 o 2).");
                scanner.next();
            }
        }
        switch (choice) {
            case 1:
                Libro libro = new Libro();
                libro.createBook(scanner);
                if (!elementi.containsKey(libro.ISBN)) {
                    elementi.put(libro.ISBN, libro);
                    System.out.println("Libro aggiunto alla lista!");
                } else {
                    System.out.println("Questo libro è già presente nella lista.");
                }
                break;
            case 2:
                Rivista rivista = new Rivista();
                rivista.createBook(scanner);
                if (!elementi.containsKey(rivista.ISBN)) {
                    elementi.put(rivista.ISBN, rivista);
                    System.out.println("Rivista aggiunta alla lista!");
                } else {
                    System.out.println("Questa rivista è già presente nella lista.");
                }
                break;
        }

    }

    public Libro findByISBN(String isbn) {
        return elementi.get(isbn);
    }

    public void deleteByISBN(String isbn) {
        if (elementi.containsKey(isbn)) {
            elementi.remove(isbn);
            System.out.println("Elemento con ISBN " + isbn + " è stato rimosso.");
        } else {
            System.out.println("Elemento con ISBN " + isbn + " non trovato.");
        }
    }

    public void findByYear(String year) {
        List<Libro> risultati = new ArrayList<>();

        for (Libro elemento : elementi.values()) {
            if (elemento.getBookYear().equals(year)) {
                risultati.add(elemento);
            }
        }

        if (risultati.isEmpty()) {
            System.out.println("Nessun elemento trovato per l'anno " + year);
        } else {
            System.out.println("Elementi trovati per l'anno " + year + ":");
            for (Libro elemento : risultati) {
                System.out.println(elemento);
            }
        }
    }

    public void findByAuthor(String author) {
        List<Libro> risultati = new ArrayList<>();

        for (Libro elemento : elementi.values()) {
            if (elemento.getBookArtist().equalsIgnoreCase(author)) {
                risultati.add(elemento);
            }
        }

        if (risultati.isEmpty()) {
            System.out.println("Nessun elemento trovato per l'autore " + author);
        } else {
            System.out.println("Elementi trovati per l'autore " + author + ":");
            for (Libro elemento : risultati) {
                System.out.println(elemento);
            }
        }
    }

    public void updateByISBN(Scanner scanner, String isbn) {
        Libro elemento = elementi.get(isbn);

        if (elemento != null) {
            System.out.println("Elemento trovato: " + elemento);

            // Chiedi all'utente cosa desidera aggiornare
            System.out.println("Cosa vuoi aggiornare?");
            System.out.println("1. Titolo");
            System.out.println("2. Autore");
            System.out.println("3. Anno di pubblicazione");
            System.out.println("4. Numero di pagine");
            System.out.println("5. ISBN");

            int updateChoice = scanner.nextInt();
            scanner.nextLine(); // Consumiamo il newline

            switch (updateChoice) {
                case 1:
                    System.out.println("Inserisci il nuovo titolo:");
                    elemento.setBookTitle(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Inserisci il nuovo autore:");
                    elemento.setBookArtist(scanner.nextLine());
                    break;
                case 3:
                    System.out.println("Inserisci il nuovo anno di pubblicazione:");
                    elemento.setBookYear(scanner.nextLine());
                    break;
                case 4:
                    System.out.println("Inserisci il nuovo numero di pagine:");
                    elemento.setBookPages(scanner.nextLine());
                    break;
                case 5:
                    System.out.println("Inserisci il nuovo ISBN:");
                    String newISBN = scanner.nextLine();
                    // Rimuovere l'elemento precedente e aggiornarlo con un nuovo ISBN
                    elementi.remove(isbn);
                    elemento.setISBN(newISBN);
                    elementi.put(newISBN, elemento);
                    break;
                default:
                    System.out.println("Scelta non valida.");
                    break;
            }
            System.out.println("Elemento aggiornato: " + elemento);
        } else {
            System.out.println("Elemento con ISBN " + isbn + " non trovato.");
        }
    }

    public void showStatistics() {
        int numLibri = 0;
        int numRiviste = 0;
        int totalPages = 0;
        int maxPages = 0;
        Libro maxPagesElement = null;

        for (Libro elemento : elementi.values()) {
            if (elemento instanceof Libro) {
                numLibri++;
            } else if (elemento instanceof Rivista) {
                numRiviste++;
            }

            int pages = Integer.parseInt(elemento.getBookPages());

            totalPages += pages;
            if (pages > maxPages) {
                maxPages = pages;
                maxPagesElement = elemento;
            }
        }

        double averagePages = totalPages / (double) elementi.size();

        System.out.println("Statistiche dell'Archivio:");
        System.out.println("Numero di libri: " + numLibri);
        System.out.println("Numero di riviste: " + numRiviste);
        if (maxPagesElement != null) {
            System.out.println("Elemento con il maggior numero di pagine: " + maxPagesElement.getBookTitle() +
                    " con " + maxPages + " pagine.");
        }
        System.out.println("Media delle pagine: " + averagePages);
    }

}