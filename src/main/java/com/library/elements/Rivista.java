package com.library.elements;

import java.util.Scanner;

public class Rivista extends Libro {

    private String periodicita;

    public String getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(String periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public void createBook(Scanner scanner) {
        System.out.println("Dammi tutte le informazioni della rivista.");

        this.bookTitle = getInput(scanner, "Titolo:");
        this.bookYear = getInput(scanner, "Anno di produzione:");
        this.bookPages = getInput(scanner, "Numero di pagine:");
        this.ISBN = getInput(scanner, "ISBN:");

        this.periodicita = getInput(scanner, "Periodicità (mensile, settimanale, ecc.):");
    }

    @Override
    public String toString() {
        return "Rivista [ISBN=" + ISBN + ", Titolo=" + bookTitle + ", Anno=" + bookYear +
                ", Periodicità=" + periodicita + "]";
    }
}