import java.util.Scanner;
import java.util.InputMismatchException;

public class Utility {
    public static final int LINE_LENGTH = 50;
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
    public static String displayHeader(String text) {
        int paddingNeeded = LINE_LENGTH - text.length();
        if (paddingNeeded <= 0) {
            return text;
        }
        return text + "-".repeat(paddingNeeded);
    }

}