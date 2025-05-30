package utils;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Utility {
    public static final String BORDER = "+==========================================================================+";
    public static final int BORDER_LENGTH = BORDER.length();
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Metoda pobiera od użytkownika int w podanym zakresie a nastepnie go zwraca
     * jeżeli warunki się zgadzają.
     * @param maxRange Maksymalna liczba możliwa do podania
     * @return input użytkownika
     */
    public static int getValidInput(int maxRange) {

        while (true) {
            try {
                int input = scanner.nextInt();
                if (input >= 1 && input <= maxRange) {
                    return input;
                } else {
                    System.out.println("Niepoprawna opcja. Wybierz liczbę od 1 do " + maxRange + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Niepoprawna opcja. Wprowadź liczbę całkowitą.");
                scanner.next();
            }
        }
    }

    /**
     * Metoda czyszcząca ekran konsoli, nie działa w IDE.
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Metoda jako argument przyjmuje tekst który centruje i wyświetla nad BORDER
     * @param text tekst do wyświetlenia
     */
    public static void displayHeader(String text) {
        int textLength = text.replaceAll("\u001B\\[[;\\d]*m", "").length();

        // Oblicz lewą i prawą przestrzeń
        int totalSpaces = BORDER_LENGTH - textLength;
        int spaces = totalSpaces / 2;

        String centeredText = " ".repeat(spaces) + text + " ".repeat(spaces);

        System.out.println(centeredText);
        System.out.println(BORDER);
    }

    /**
     * Metoda jako argument przyjmuje tablice stringów którą centruje do BORDER i ją wyświetla linijka po linijce
     * @param lines tekst do wyświetlenia
     */
    public static void printCenteredText(String[] lines) {
        int padding;
        for (String line : lines) {
            padding = (Utility.BORDER_LENGTH - line.length()) / 2;
            System.out.printf("%" + (padding + line.length()) + "s%n", line);
        }
    }

    /**
     * Metoda czeka na wciśnięcie enter następinie czysci konsole.
     */
    public static void pressEnter(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nNaciśnij Enter, aby kontynuować...");
        sc.nextLine();
        Utility.clearScreen();
    }
}