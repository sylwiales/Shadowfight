package characters;
import utils.*;

import art.Art;

import java.util.Random;

public class Monsters {
    private static final Random rand = new Random();

    public static final Monster skeleton = new Monster("Cukan", 50, 20, Data.AttackType.BLUDGEONING, "Prachuje wam kości >:)", Art.SKELETON_ART) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(rand.nextInt(10, getDamage()), null);
        }

        @Override
        public void takeHit(int damage, Data.AttackType attackType) {
            boolean isWeak = (attackType == getWeakness());
            int finalDamage = isWeak ? damage * 2 : damage;

            if (isWeak) {
                System.out.println(Colour.PURPLE_BRIGHT + getName() + Colour.RESET + " jest wrażliwy na obrażenia " + attackType.getName() + "! Otrzymuje " + Colour.RED + finalDamage + Colour.RESET + " punktów obrażeń!");
            } else {
                System.out.println(Colour.PURPLE_BRIGHT + getName() + Colour.RESET + " otrzymuje " + Colour.RED + finalDamage + Colour.RESET + " punktów obrażeń!");
            }

            setHealth(getHealth() - finalDamage);

            if(getHealth() <= 0) {
                System.out.println(Colour.GREEN_BRIGHT + getName() + " został pokonany!" + Colour.RESET);
            }
        }
    };

    public static final Monster ghosts = new Monster("duszki", 100, 20, Data.AttackType.MAGIC, "boo!", Art.GHOST_ART) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(rand.nextInt(10, getDamage()), Data.AttackType.MAGIC);
        }

        @Override
        public void takeHit(int damage, Data.AttackType attackType) {
            boolean isWeak = (attackType == getWeakness());
            int finalDamage = isWeak ? damage * 2 : 0;

            if (isWeak) {
                System.out.println(Colour.PURPLE_BRIGHT + getName() + Colour.RESET + " są wrażliwe na obrażenia " + attackType.getName() + "! Otrzymują " + Colour.RED + finalDamage + Colour.RESET + " punktów obrażeń!");
            } else {
                System.out.println("Atak przenika przez " + Colour.PURPLE_BRIGHT + getName() + Colour.RESET + "! Co się dzieje!");
            }

            setHealth(getHealth() - finalDamage);

            if(getHealth() <= 0) {
                System.out.println(Colour.GREEN_BRIGHT + getName() + " pokonane!" + Colour.RESET);
            }
        }
    };

    public static final Monster maksio = new Monster("Maksio", 30, 100, Data.AttackType.PIERCING, "woof woof arf", Art.MAKSIO_ART) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(rand.nextInt(10, getDamage()), Data.AttackType.MAGIC);
        }

        @Override
        public void takeHit(int damage, Data.AttackType attackType) {
            boolean isWeak = (attackType == getWeakness());
            int finalDamage = isWeak ? damage * 2 : damage;

            if (isWeak) {
                System.out.println(Colour.PURPLE_BRIGHT + getName() + Colour.RESET + " jest wrażliwy na obrażenia " + attackType.getName() + "! Otrzymuje " + Colour.RED + finalDamage + Colour.RESET + " punktów obrażeń!");
            } else {
                System.out.println(Colour.PURPLE_BRIGHT + getName() + " otrzymuje " + Colour.RED + finalDamage + Colour.RESET + " punktów obrażeń!" + Colour.RESET);
            }

            setHealth(getHealth() - finalDamage);

            if(getHealth() <= 0) {
                System.out.println(Colour.GREEN_BRIGHT + getName() + " pokonany!" + Colour.RESET);
            }
        }
    };

    public static final Monster wizard = new Monster("GM", 100, 30, Data.AttackType.SLASHING, "Czy 19 trafia?", Art.WIZARD_ART) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(rand.nextInt(10, getDamage()), Data.AttackType.MAGIC);
        }

        @Override
        public void takeHit(int damage, Data.AttackType attackType) {
            boolean isWeak = (attackType == getWeakness());
            int finalDamage = isWeak ? damage * 2 : damage;

            if (isWeak) {
                System.out.println(Colour.PURPLE_BRIGHT + getName() + Colour.RESET + " jest wrażliwy na obrażenia " + attackType.getName() + "! Otrzymuje " + Colour.RED + finalDamage + Colour.RESET + " punktów obrażeń!");
                System.out.println(Colour.PURPLE_BRIGHT + getName() + Colour.RESET + " przewidział taki przebieg wydarzeń, już nie jest wrażliwy na obrażenia " + attackType.getName() + "!");
                Data.AttackType[] attackTypes = Data.AttackType.values();
                Data.AttackType selectedType;
                do {
                    selectedType = attackTypes[rand.nextInt(1,4)];
                } while(selectedType == getWeakness());

                setWeakness(selectedType);
            } else {
                System.out.println(Colour.PURPLE_BRIGHT + getName() + Colour.RESET + " otrzymuje " + Colour.RED + finalDamage + Colour.RESET + " punktów obrażeń!" + Colour.RESET);
            }

            setHealth(getHealth() - finalDamage);

            if(getHealth() <= 0) {
                System.out.println(Colour.GREEN_BRIGHT + getName() + " pokonany!" + Colour.RESET);
            }
        }
    };
}