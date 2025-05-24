import java.util.Random;
import java.util.Scanner;

public class Game {
    private Scanner sc;
    private Random rand;
    private final Monster[] monsters;
    private Companion[] party;
    private int activeMonster;
    private final String[] availableCompanions = {"Natinel", "Klara", "Czerkow", "Witold", "Zaphiel"};

    public Game() {
        sc = new Scanner(System.in);
        rand = new Random();

        // Inicjalizacja potworów
        int monstersAmount = 7;
        monsters = new Monster[monstersAmount];
        monsters[0] = Monsters.skeleton;
        monsters[1] = Monsters.ben;
        monsters[2] = Monsters.griffin;
        monsters[3] = Monsters.maksio;
        monsters[4] = Monsters.ghosts;
        monsters[5] = Monsters.wizard;
        monsters[6] = Monsters.dragon;

        activeMonster = 0;
    }

    public void gatherTeam() {
        System.out.println(Utility.displayHeader("ZBIERANIE DRUŻYNY"));
        System.out.println("Wybierz 3 towarzyszy (wprowadź numery 1-5):");

        // Wyświetl dostępne postacie z ich statystykami
        for (int i = 0; i < availableCompanions.length; i++) {
            Companion temp = new Companion(availableCompanions[i]);
            System.out.printf("%d. %s - Siła: %d, Zdrowie: %d%n",
                    i + 1,
                    temp.getName(),
                    temp.getStrength(),
                    temp.getMaxHealth());
        }

        party = new Companion[3];

        for (int i = 0; i < 3; i++) {
            System.out.printf("\nWybierz towarzysza %d/%d: ", i + 1, 3);
            int choice = Utility.getValidInput(5) - 1;

            // Sprawdź czy postać już nie została wybrana
            boolean alreadyChosen = false;
            for (Companion companion : party) {
                if (companion != null && companion.getName().equals(availableCompanions[choice])) {
                    alreadyChosen = true;
                    break;
                }
            }

            if (alreadyChosen) {
                System.out.println("Ta postać jest już w twojej drużynie! Wybierz inną.");
                i--; // Powtórz wybór
                continue;
            }

            // Tworzymy nowego towarzysza z losowymi statystykami
            party[i] = new Companion(availableCompanions[choice]);
            System.out.println("Dodano " + party[i].getName() + " do drużyny!");
        }

        System.out.println("\nTwoja drużyna:");
        for (Companion companion : party) {
            System.out.println(companion.displayInfo());
        }

        System.out.println("\nNaciśnij Enter, aby kontynuować...");
        sc.nextLine(); // Czekamy na Enter
        Utility.clearScreen();
    }

    public void startHunt() {
        if (party == null || party.length == 0) {
            System.out.println("Najpierw musisz zebrać drużynę!");
            return;
        }

        Monster currentMonster = monsters[activeMonster];

        // Wyświetlenie dialogu potwora tylko w pierwszej turze
        System.out.println(Colour.PURPLE_BRIGHT + "Potwór mówi: " + Colour.RESET + currentMonster.sayDialogue());
        System.out.println();

        boolean isPartyWinner = false;
        int monsterMaxHealth = currentMonster.getHealth();

        while (true) {
            // Wyświetlanie informacji o potworze
            currentMonster.displayMonsterInfo(monsterMaxHealth);

            // Wyświetlanie informacji o drużynie
            System.out.println(Utility.displayHeader("WYBIERZ POSTAĆ"));
            for (int i = 0; i < party.length; i++) {
                System.out.println((i + 1) + ".\t" + party[i].displayInfo());
            }

            int activePartyIndex = Utility.getValidInput(party.length) - 1;
            Companion activeCompanion = party[activePartyIndex];

            while (activeCompanion.getCurrentHealth() <= 0) {
                System.out.println(activeCompanion.getName() + " nie żyje");
                System.out.println("Wybierz inną postać");
                activePartyIndex = Utility.getValidInput(party.length) - 1;
                activeCompanion = party[activePartyIndex];
            }

            System.out.println(Utility.displayHeader(activeCompanion.getName().toUpperCase()));
            System.out.println("1. ATAK\t2. ULECZ SIĘ");

            int option = Utility.getValidInput(2);
            Utility.clearScreen();

            if (option == 1) {
                activeCompanion.attack(currentMonster);
            } else if (option == 2) {
                int healAmount = 10;
                System.out.println(activeCompanion.getName().toUpperCase() + " dodaje " + healAmount + " punktów życia");
                activeCompanion.setHealth(Math.min(
                        activeCompanion.getCurrentHealth() + healAmount,
                        activeCompanion.getMaxHealth()));
            }


            // Sprawdź czy potwór żyje po ataku
            if (currentMonster.getHealth() > 0) {
                currentMonster.attack(activeCompanion);
            }

            // Sprawdzenie warunków zakończenia walki
            if (checkBattleEnd(currentMonster)) {
                isPartyWinner = currentMonster.getHealth() <= 0;
                break;
            }
        }

        if (isPartyWinner) {
            // Leczenie drużyny po wygranej walce
            for (Companion companion : party) {
                companion.setHealth(companion.getMaxHealth());
            }

            // Next potwór na liście
            activeMonster++;

            if (activeMonster >= monsters.length) {
                System.out.println(Colour.YELLOW_BRIGHT + "Gratulacje, wszystkie potwory nie żyją!" + Colour.RESET);
            }
        } else {
            System.out.println(Colour.RED_BRIGHT + "Twoja drużyna została pokonana ;(" + Colour.RESET);
        }
    }

    private boolean checkBattleEnd(Monster currentMonster) {
        // Sprawdź czy potwór nie żyje
        if (currentMonster.getHealth() <= 0) {
            return true;
        }

        // Sprawdź czy cała drużyna nie żyje
        boolean allDead = true;
        for (Companion companion : party) {
            if (companion.getCurrentHealth() > 0) {
                allDead = false;
                break;
            }
        }

        return allDead;
    }
}

