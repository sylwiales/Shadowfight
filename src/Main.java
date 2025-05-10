import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Villager[] villagers = new Villager[6];
        villagers[0] = new Villager("Kashya", 30);
        villagers[1] = new ExtraordinaryVillager("Akara", 40, ExtraordinaryVillager.Skill.SHELTER);
        villagers[2] = new Villager("Gheed", 50);
        villagers[3] = new ExtraordinaryVillager("Deckard Cain", 85, ExtraordinaryVillager.Skill.IDENTIFY);
        villagers[4] = new Villager("Warriv", 35);
        villagers[5] = new Villager("Flawia", 25);

        for (Villager villager : villagers) {
            villager.sayHello();
        }

        Object objectDeckardCain = villagers[3];
        Object objectAkara = villagers[1]; // nie można teraz używać metod klasy

        int turn = 1;
        int activeVillager;
        int activeMonster;

        Monster[] monsters = new Monster[2];
        monsters[0] = Monsters.andariel;
        monsters[1] = Monsters.blacksmith;


        while(Monsters.getMonsterHealth() > 0){
            System.out.println("------------------------[TURA " + turn++ + " " + (turn % 2 == 0 ? "OSADNICY" : "POTWORY")+"]---------------------------");
            Random rand = new Random();
            do {
                activeVillager = rand.nextInt(6);
            }while(villagers[activeVillager].getHealth() <= 0);



            activeMonster = rand.nextInt(2);
            System.out.println("Monster health:" + monsters[activeMonster].getHealth());

            if(activeMonster == 0 && Monsters.andariel.getHealth() <= 0){
                activeMonster = 1;
            }
            else if(activeMonster == 1 && Monsters.blacksmith.getHealth() <= 0){
                activeMonster = 0;
            }

            System.out.println(Colour.PURPLE_BOLD + "Potwory posiadają " + Monsters.getMonsterHealth() + " punktów życia.");
            System.out.println(Colour.BLUE_BOLD + "Aktualnie walczy osadnik: " + villagers[activeVillager].getName() + Colour.RESET);

            if(turn % 2 != 0){
                //potwory
                System.out.println("Potwór " + Colour.PURPLE_BRIGHT + (activeMonster == 0 ? "Andariel" : "Blacksmith") + Colour.RESET + " atakuje: " + Colour.BLUE_BRIGHT + villagers[activeVillager].getName() + Colour.RESET + "!");
                if(activeVillager == 0){
                    Monsters.andariel.attack(villagers[activeVillager]);
                }
                else{
                    Monsters.blacksmith.attack(villagers[activeVillager]);
                }
            }
            else {
                //villagerzy
                System.out.println("Osadnik " + Colour.BLUE_BRIGHT + villagers[activeVillager].getName() + Colour.RESET + " atakuje: " + Colour.PURPLE_BRIGHT + (activeMonster == 0 ? "Andariel" : "Blacksmith") + Colour.RESET + "!");
                villagers[activeVillager].attack(activeMonster == 0 ? Monsters.andariel : Monsters.blacksmith);
            }
        };
        System.out.println("----------------------------------------------------------------------");
        System.out.println(Colour.GREEN_BOLD_BRIGHT + "Obozowisko ocalone!" + Colour.RESET);

        villagers[3] = (ExtraordinaryVillager) objectDeckardCain;
        villagers[1] = (ExtraordinaryVillager) objectAkara;
    }
}
