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
     * Metoda jako argument przyjmuje tekst do którego dodaje pauzy potrzebne do osiągnięcia
     * określonej długości stringa. Następnie zwraca gotowego stringa.
     * @param text
     * @return string z potrzebną ilością pauz
     */
    public static void displayHeader(String text) {
        int textLength = text.length();

        // Oblicz lewą i prawą przestrzeń
        int totalSpaces = BORDER_LENGTH - textLength;
        int spaces = totalSpaces / 2;

        String centeredText = " ".repeat(spaces) + text + " ".repeat(spaces);

        System.out.println(centeredText);
        System.out.println(BORDER);

    }

    public static void printCenteredText(String[] lines) {
        int padding;
        for (String line : lines) {
            padding = (Utility.BORDER_LENGTH - line.length()) / 2;
            System.out.printf("%" + (padding + line.length()) + "s%n", line);
        }
    }
}