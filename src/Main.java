import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int monstersAmount = 7; // Ile potworów jest w tablicy
        Monster[] monsters = new Monster[monstersAmount];
        monsters[0] = Monsters.skeleton;
        monsters[1] = Monsters.ben;
        monsters[2] = Monsters.griffin;
        monsters[3] = Monsters.maksio;
        monsters[4] = Monsters.ghosts;
        monsters[5] = Monsters.wizard;
        monsters[6] = Monsters.dragon;

        int activeMonster = 0;

        Companion[] party = new Companion[2];
        party[0] = new Companion("Natinel", 80,50);
        party[1] = new Companion("Klara", 90,50);

        Utility.clearScreen();

        while(true) {
            System.out.println("MENU");
            System.out.println("1. Idź na misję");
            System.out.println("2. Zakończ grę");

            int option = Utility.getValidInput(2);
            Utility.clearScreen();

            if(option == 1) {
                boolean isPartyWinner = false;

                while(monsters[activeMonster].getHealth() > 0 && (party[0].getCurrentHealth() > 0 || party[1].getCurrentHealth() > 0)){
                    monsters[activeMonster].showArt();

                    System.out.println(Utility.displayHeader("WYBIERZ POSTAĆ"));
                    for(int i = 0; i < party.length; i++) {
                        System.out.println(i + 1 + ".\t" + party[i].displayInfo());
                    }
                    int activeParty = Utility.getValidInput(2) - 1;

                    Utility.clearScreen();
                    System.out.println(Utility.displayHeader(party[activeParty].getName().toUpperCase()));
                    System.out.println("1. ATAK\t2. ULECZ SIĘ");

                    option = Utility.getValidInput(2);
                    if(option == 1) {
                        party[activeParty].attack(monsters[activeMonster]);
                    }
                    else if(option == 2) {
                        System.out.println(party[activeParty].getName().toUpperCase() + "dodaje 10 punktów życia");
                        party[activeParty].setHealth(party[activeParty].getCurrentHealth() + 10);
                    }

                    if(monsters[activeMonster].getHealth() > 0) {
                        monsters[activeMonster].attack(party[activeParty]);
                    }
                    else{
                        isPartyWinner = true;
                    }
                }

                if(isPartyWinner) {
                    System.out.println("To super");
                    for (Companion companion : party) {
                        companion.setHealth(companion.getMaxHealth());
                    }
                    activeMonster++; // Powtór został pokonany, przechodzimy do następnego w tablicy
                    if (!(activeMonster < monstersAmount)) {
                        System.out.println("Gratulacje! Koniec gry");
                        break;
                    }
                }
                else{
                    System.out.println("Skill issue");
                    break;
                }

            }
            else if(option == 2) {
                System.out.println("naura");
                break;
            }

        }
    }
}
