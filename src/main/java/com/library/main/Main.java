package com.library.main;

import com.library.elements.Archivio;
import com.library.elements.Libro;
import com.library.elements.Rivista;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Archivio archivio = new Archivio();

        while (true) {
            System.out.println("\nBenvenuto nel sistema di gestione dell'archivio!");
            System.out.println("Cosa vuoi fare?");
            System.out.println("1. Aggiungi un libro o una rivista");
            System.out.println("2. Ricerca per ISBN");
            System.out.println("3. Ricerca per anno di pubblicazione");
            System.out.println("4. Ricerca per autore");
            System.out.println("5. Aggiorna un elemento esistente");
            System.out.println("6. Elimina un elemento per ISBN");
            System.out.println("7. Visualizza le statistiche");
            System.out.println("8. Esci");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    archivio.createElement(scanner);
                    break;
                case 2:
                    System.out.println("Inserisci l'ISBN dell'elemento da cercare:");
                    String isbn = scanner.nextLine();
                    Libro libroTrovato = archivio.findByISBN(isbn);
                    if (libroTrovato != null) {
                        System.out.println("Elemento trovato: " + libroTrovato);
                    } else {
                        System.out.println("Elemento con ISBN " + isbn + " non trovato.");
                    }
                    break;
                case 3:
                    System.out.println("Inserisci l'anno di pubblicazione da cercare:");
                    String anno = scanner.nextLine();
                    archivio.findByYear(anno);
                    break;
                case 4:
                    System.out.println("Inserisci l'autore da cercare:");
                    String autore = scanner.nextLine();
                    archivio.findByAuthor(autore);
                    break;
                case 5:
                    System.out.println("Inserisci l'ISBN dell'elemento da aggiornare:");
                    String isbnUpdate = scanner.nextLine();
                    archivio.updateByISBN(scanner, isbnUpdate);
                    break;
                case 6:
                    System.out.println("Inserisci l'ISBN dell'elemento da eliminare:");
                    String isbnDelete = scanner.nextLine();
                    archivio.deleteByISBN(isbnDelete);
                    break;
                case 7:
                    archivio.showStatistics();
                    break;
                case 8:
                    System.out.println("Arrivederci!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Scelta non valida. Per favore, scegli un'opzione valida.");
                    break;
            }
        }
    }
}