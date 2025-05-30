package characters;

import utils.*;
import java.util.Random;

public class Companion implements Fighter {
    private final String name;
    private final int strength;
    private final int maxHealth;
    private final Data.AttackType attackType;
    private int currentHealth;

    private int paralyzedTurnsRemaining = 0;
    private final Random rand = new Random();

    public Companion(String name, int strength, int maxHealth, Data.AttackType attackType) {
        this.name = name;
        this.strength = strength;
        this.maxHealth = maxHealth;
        currentHealth = maxHealth;
        this.attackType = attackType;
    }

    public String getName() {return name;}
    public int getStrength() {return strength;}
    public int getMaxHealth() {return maxHealth;}
    public int getCurrentHealth() {return currentHealth;}
    public Data.AttackType getAttackType() {return attackType;}
    public void setHealth(int health) {currentHealth = health;}

    public void setParalyzedTurnsRemaining(int turnsRemaining) {
        if(turnsRemaining == 0) {
            paralyzedTurnsRemaining = 0;
        }
        else {
            paralyzedTurnsRemaining -= turnsRemaining;
        }
    }

    public boolean isParalyzed() {return paralyzedTurnsRemaining > 0;}

    public String displayInfo(){
        return  (isParalyzed() ? Colour.YELLOW : Colour.BLUE_BRIGHT)
                + getName() + "\t\t" + Colour.RESET
                + Colour.RED + getCurrentHealth() + Colour.RESET + "/" + Colour.RED  + getMaxHealth() + Colour.RESET
                + "\tSiła: " + getStrength()
                + "\tObrażenia: " + getAttackType().getName();
    }

    public void heal(){
        if(isParalyzed()){
            System.out.println(Colour.YELLOW + getName() + Colour.RESET + " nie może się leczyć przez paraliż! Pozostało tur: " + paralyzedTurnsRemaining);
        }
        else{
            setHealth(currentHealth + 10);
            System.out.println(Colour.BLUE_BRIGHT + getName() + Colour.RESET + " odzyskuje 10 punktów życia");
        }
    }

    public void heal(Companion companion) {
        if(isParalyzed()){
            System.out.println(Colour.YELLOW + getName() + Colour.RESET + " nie może leczyć przez paraliż! Pozostało tur: " + paralyzedTurnsRemaining);
            return;
        }
        if(companion.isParalyzed()){
            companion.setParalyzedTurnsRemaining(0);
            System.out.println(Colour.BLUE_BRIGHT + getName() + Colour.RESET + " kończy paraliż " + companion.getName());
        }
        else{
            companion.setHealth(companion.getMaxHealth());
            System.out.println((companion.isParalyzed() ? Colour.YELLOW : Colour.BLUE_BRIGHT) + companion.getName() + Colour.RESET + " odzyskuje maksymalne punkty życia");
        }
    }

    @Override
    public void attack(Fighter victim) {
        if (isParalyzed()) {
            System.out.println(Colour.YELLOW + getName() + Colour.RESET +
                    " nie może atakować przez paraliż! Pozostało tur: " + paralyzedTurnsRemaining);
            return;
        }

        int dmg = rand.nextInt(5,getStrength());
        victim.takeHit(dmg, attackType);
    }

    @Override
    public void takeHit(int dmg, Data.AttackType attackType) {
        System.out.println(Colour.BLUE_BRIGHT + getName() + Colour.RESET + " otrzymuje " + Colour.RED + dmg + Colour.RESET + " punktów obrażeń.");

        if(attackType == Data.AttackType.MAGIC && rand.nextInt(1,20) > 15) {
            System.out.println("Obecność magii paraliżuje " + Colour.YELLOW + getName() + Colour.RESET + ". Nie może atakować przez 3 tury.");
            paralyzedTurnsRemaining = 3;
        }

        setHealth(getCurrentHealth() - dmg);

        if(getCurrentHealth() <= 0){
            System.out.println(Colour.RED + getName() + " mdleje!" + Colour.RESET);
            setHealth(0);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Companion companion = (Companion) o;
        return name.equals(companion.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}