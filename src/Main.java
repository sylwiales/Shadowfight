import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("MENU");
            System.out.println("1. Idź na misję");
            System.out.println("2. Zakończ grę");

            int option = sc.nextInt();

            switch(option) {
                case 1:
                    clearScreen();
                    System.out.println("misja");
                    break;
                case 2:
                    clearScreen();
                    System.out.println("naura");
                    break;
            }
            break;
        }
    }
}
