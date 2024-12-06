package com.library.elements;
import java.util.Scanner;

public class Libro {
    protected String ISBN;
    protected String bookTitle;
    protected String bookPages;
    protected String bookYear;
    protected String bookArtist;
    protected String bookGenre;

    public String getBookYear() {
        return bookYear;
    }

    public String getBookArtist() {
        return bookArtist;
    }

    public String getBookPages() {
        return bookPages;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    protected String getInput(Scanner scanner, String prompt) {
        String input = null;
        while (input == null || input.trim().isEmpty()) {
            System.out.println(prompt);
            input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println("Input non valido. Riprova.");
            }
        }
        return input;
    }

    public void createBook(Scanner scanner) {

        System.out.println("Dammi tutte le informazioni del libro.");

        this.bookArtist = getInput(scanner, "Autore:");
        this.bookTitle = getInput(scanner, "Titolo:");
        this.bookGenre = getInput(scanner, "Genere:");
        this.bookYear = getInput(scanner, "Anno di produzione:");
        this.bookPages = getInput(scanner, "Numero di pagine:");
        this.ISBN = getInput(scanner, "ISBN:");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return ISBN.equals(libro.ISBN);
    }

    @Override
    public int hashCode() {
        return ISBN.hashCode();
    }

    @Override
    public String toString() {
        return "Libro [ISBN=" + ISBN + ", Titolo=" + bookTitle + ", Anno=" + bookYear + ", Autore=" + bookArtist + "]";
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setBookArtist(String bookArtist) {
        this.bookArtist = bookArtist;
    }

    public void setBookYear(String bookYear) {
        this.bookYear = bookYear;
    }

    public void setBookPages(String bookPages) {
        this.bookPages = bookPages;
    }

}