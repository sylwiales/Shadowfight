import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private Scanner sc;
    private Random rand;
    private final Monster[] monsters;
    private int activeMonster;
    private List<Companion> party;
    private final List<Companion> availableCompanions;

    public static int turn = 0;

    public Game() {
        sc = new Scanner(System.in);
        rand = new Random();

        // Inicjalizacja potworów
        int monstersAmount = 4;
        monsters = new Monster[monstersAmount];
        monsters[0] = Monsters.skeleton;
        monsters[1] = Monsters.ghosts;
        monsters[2] = Monsters.maksio;
        monsters[3] = Monsters.wizard;
        activeMonster = 0;

        // Inicjalizacja dostępnych postaci
        availableCompanions = new ArrayList<>();

        for (String companionData : Data.COMPANION_DATA) {
            String[] parts = companionData.split(",");
            String name = parts[0];
            int strength = Integer.parseInt(parts[1]);
            int maxHealth = Integer.parseInt(parts[2]);
            Data.AttackType attackType = Data.AttackType.valueOf(parts[3]);

            availableCompanions.add(new Companion(name, strength, maxHealth, attackType));
        }
    }

    public void gatherTeam() {
        Utility.displayHeader("ZBIERZ DRUŻYNE");
        System.out.println("Wybierz 3 towarzyszy (wprowadź numery 1-" + availableCompanions.size() + "):");

        // Wyświetl dostępnych towarzyszy z numerami
        for (int i = 0; i < availableCompanions.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, availableCompanions.get(i).displayInfo());
        }

        party = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            System.out.printf("%nWybierz towarzysza %d/%d: ", i + 1, 3);
            int choice = Utility.getValidInput(availableCompanions.size()) - 1;

            Companion selected = availableCompanions.get(choice);

            // Sprawdź czy postać już nie została wybrana
            if (party.contains(selected)) {
                System.out.println("Ta postać jest już w twojej drużynie! Wybierz inną.");
                i--; // Powtórz wybór
                continue;
            }

            // Dodaj towarzysza do drużyny
            party.add(availableCompanions.get(choice));

            System.out.println(Colour.GREEN_BRIGHT + selected.getName() + " dołącza do drużyny!" + Colour.RESET);
        }

        Utility.displayHeader("DRUŻYNA");
        for (Companion companion : party) {
            System.out.println(companion.displayInfo());
        }

        System.out.println("\nNaciśnij Enter, aby kontynuować...");
        sc.nextLine(); // Czekamy na Enter
        Utility.clearScreen();
    }

    public void startHunt() {
        if (party == null || party.isEmpty()) {
            System.out.println("Przed wyruszeniem w drogę należy zebrać drużynę.");
            return;
        }

        Monster currentMonster = monsters[activeMonster];

        // Wyświetlenie dialogu potwora tylko w pierwszej turze
        System.out.println(Colour.PURPLE_BRIGHT + "Potwór mówi: " + Colour.RESET + currentMonster.getDialogue());
        System.out.println();

        boolean isPartyWinner = false;
        int monsterMaxHealth = currentMonster.getHealth();

        while (true) {
            int option = 3;
            Companion activeCompanion;

            do{
                // Wyświetlanie informacji o potworze
                currentMonster.displayMonsterInfo(monsterMaxHealth);
                // Wyświetlanie informacji o drużynie
                Utility.displayHeader("WYBIERZ POSTAĆ DO WALKI");
                for (int i = 0; i < party.size(); i++) {
                    System.out.println((i + 1) + ". " + party.get(i).displayInfo());
                }

                int activePartyIndex = Utility.getValidInput(party.size()) - 1;
                activeCompanion = party.get(activePartyIndex);

                while (activeCompanion.getCurrentHealth() <= 0) {
                    System.out.println(activeCompanion.getName() + " nie żyje");
                    System.out.println("Wybierz inną postać");
                    activePartyIndex = Utility.getValidInput(party.size()) - 1;
                    activeCompanion = party.get(activePartyIndex);
                }

                Utility.displayHeader(activeCompanion.getName());
                System.out.println("1. ATAKUJ\n2. LECZ\n3. COFNIJ");

                option = Utility.getValidInput(3);
                Utility.clearScreen();

                if (option == 1) {
                    activeCompanion.attack(currentMonster);
                } else if (option == 2) {
                    if(activeCompanion.getAttackType() == Data.AttackType.MAGIC){
                        currentMonster.displayMonsterInfo(monsterMaxHealth);
                        Utility.displayHeader("WYBIERZ CEL LECZENIA");
                        for (int i = 0; i < party.size(); i++) {
                            System.out.println((i + 1) + ". " + party.get(i).displayInfo());
                        }
                        option = Utility.getValidInput(party.size()) - 1;
                        Utility.clearScreen();
                        activeCompanion.heal(party.get(option));
                    }
                    else{
                        activeCompanion.heal();
                    }
                }
            }while(option == 3);



            if(currentMonster.getHealth() > 0){
                currentMonster.attack(activeCompanion);
            }

            endTurn();
            // Sprawdzenie warunków zakończenia walki
            if (checkBattleEnd(currentMonster)) {
                isPartyWinner = currentMonster.getHealth() <= 0;
                break;
            }
        }

        System.out.println("\nNaciśnij Enter, aby kontynuować...");
        sc.nextLine(); // Czekamy na Enter
        Utility.clearScreen();

        if (isPartyWinner) {
            // Next potwór na liście
            activeMonster++;

            if (activeMonster >= monsters.length) {
                System.out.println(Colour.YELLOW_BRIGHT + "Gratulacje, wszystkie potwory nie żyją!" + Colour.RESET);
            }
        } else {
            System.out.println(Colour.RED_BRIGHT + "Twoja drużyna została pokonana ;(" + Colour.RESET);
            currentMonster.setHealth(monsterMaxHealth);
        }

        for (Companion companion : party) {
            companion.setHealth(companion.getMaxHealth());
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

    public void endTurn(){
        for (Companion companion : party) {
            if(companion.isParalyzed()){
                companion.setParalyzedTurnsRemaining(1);
            }
        }
    }
}

