package game;

import art.Art;
import characters.*;
import utils.*;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Monster> monsters;
    private int activeMonster;
    private List<Companion> party;
    private final List<Companion> availableCompanions;

    public Game() {
        // Inicjalizacja potworów
        monsters = new ArrayList<>();
        monsters.add(Monsters.skeleton);
        monsters.add(Monsters.ghosts);
        monsters.add(Monsters.maksio);
        monsters.add(Monsters.wizard);
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
        Utility.displayHeader("ZBIERZ DRUŻYNĘ");
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

            System.out.println(Colour.BLUE_BRIGHT + selected.getName() + " dołącza do drużyny!" + Colour.RESET);
        }

        Utility.displayHeader("DRUŻYNA");
        for (Companion companion : party) {
            System.out.println(companion.displayInfo());
        }

        Utility.pressEnter();
    }

    public void startHunt() {
        if (party == null || party.isEmpty()) {
            Utility.displayHeader(Colour.RED + "Przed wyruszeniem w drogę należy zebrać drużynę." + Colour.RESET);
            return;
        }
        if (activeMonster >= monsters.size()) {
            System.out.println(Colour.GREEN_BRIGHT + "Gratulacje, wszystkie potwory nie żyją!" + Colour.RESET);
        }

        Monster currentMonster = monsters.get(activeMonster);
        boolean isPartyWinner;
        int monsterMaxHealth = currentMonster.getHealth();

        // Wyświetlenie dialogu potwora tylko w pierwszej turze
        Utility.displayHeader(Colour.PURPLE_BRIGHT + "Potwór mówi: " + Colour.RESET + currentMonster.getDialogue());
        System.out.println();

        while (true) {
            int option;
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

                Utility.displayHeader(Colour.BLUE_BRIGHT + activeCompanion.getName() + Colour.RESET);
                System.out.println("1. ATAKUJ\n2. LECZ\n3. COFNIJ");

                option = Utility.getValidInput(3);
                Utility.clearScreen();

                if (option == 1) {
                    activeCompanion.attack(currentMonster);
                } else if (option == 2) {
                    if(activeCompanion.getAttackType() == Data.AttackType.MAGIC){
                        currentMonster.displayMonsterInfo(monsterMaxHealth);
                        Utility.displayHeader( "WYBIERZ CEL LECZENIA");
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

        Utility.pressEnter();

        if (isPartyWinner) {
            // Next potwór na liście
            activeMonster++;

            if (activeMonster >= monsters.size()) {
                System.out.println(Colour.GREEN_BRIGHT + "Gratulacje, wszystkie potwory nie żyją!" + Colour.RESET);
            }
        } else {
            Utility.clearScreen();
            Utility.printCenteredText(Art.GAME_OVER);
            Utility.pressEnter();
            currentMonster.setHealth(monsterMaxHealth);
        }

        for (Companion companion : party) {
            companion.setHealth(companion.getMaxHealth());
            companion.setParalyzedTurnsRemaining(0);
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

