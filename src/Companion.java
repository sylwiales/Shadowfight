import java.util.Random;

public class Companion implements Fighter {
    private final String name;
    private final int strength;
    private final int maxHealth;
    private final Data.AttackType attackType;
    private int currentHealth;

    private int paralyzedTurnsRemaining = 0;
    private Random rand = new Random();

    Companion(String name, int strength, int maxHealth, Data.AttackType attackType) {
        this.name = name;
        this.strength = strength;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.attackType = attackType;
    }

    public String getName() {return this.name;}
    public int getStrength() {return this.strength;}
    public int getMaxHealth() {return this.maxHealth;}
    public int getCurrentHealth() {return this.currentHealth;}
    public Data.AttackType getAttackType() {return this.attackType;}

    public boolean isParalyzed() {
        return paralyzedTurnsRemaining > 0;
    }
    public void setParalyzedTurnsRemaining(int turnsRemaining) {
        if( turnsRemaining == 0 ) {
            paralyzedTurnsRemaining = 0;
        }
        else{
            paralyzedTurnsRemaining -= turnsRemaining;
        }
    }

    public void setHealth(int health) {this.currentHealth = health;}

    public String displayInfo(){
        return  (isParalyzed() ? Colour.YELLOW : "")
                + getName() + "\t\t" + Colour.RESET
                + Colour.RED + getCurrentHealth() + Colour.RESET + "/" + getMaxHealth()
                + "\tSiła: " + getStrength()
                + "\tObrażenia: " + getAttackType().getName();
    }

    public void heal(){
        if(this.isParalyzed()){
            System.out.println(Colour.YELLOW +  this.getName() + Colour.RESET + " nie może się leczyć przez paraliż! Pozostało tur: " + this.paralyzedTurnsRemaining);
        }
        else{
            this.setHealth(this.currentHealth + 10);
            System.out.println(this.getName() + " odzyskuje 10 punktów życia");
        }
    }

    public void heal(Companion companion) {
        if(this.isParalyzed()){
            System.out.println(this.getName() + " nie może leczyć przez paraliż! Pozostało tur: " + this.paralyzedTurnsRemaining);
            return;
        }
        if(companion.isParalyzed()){
            companion.setParalyzedTurnsRemaining(0);
            System.out.println(this.getName() + " kończy paraliż " + companion.getName());
        }
        else{
            companion.setHealth(companion.getMaxHealth());
            System.out.println(companion.getName() + " odzyskuje maksymalne punkty życia");
        }
    }

    @Override
    public void attack(Fighter victim) {
        if (isParalyzed()) {
            System.out.println(Colour.YELLOW + this.getName() + Colour.RESET +
                    " nie może atakować przez paraliż! Pozostało tur: " + this.paralyzedTurnsRemaining);
            return;
        }

        int dmg = rand.nextInt(1,20) + this.getStrength();
        victim.takeHit(dmg, this.attackType);
    }


    @Override
    public void takeHit(int dmg, Data.AttackType attackType) {
        System.out.println(Colour.BLUE_BOLD + this.getName() + Colour.RESET + " otrzymuje " + Colour.RED + dmg + Colour.RESET + " punktów obrażeń.");

        if(attackType == Data.AttackType.MAGIC && rand.nextInt(1,20) > 15) {
            System.out.println("Obecność magii paraliżuje " + this.getName() + ". Nie może atakować przez 3 tury.");
            paralyzedTurnsRemaining = 3;
        }

        this.setHealth(this.getCurrentHealth() - dmg);
        if(this.getCurrentHealth() <= 0){
            System.out.println(Colour.RED + this.getName() + " umiera!" + Colour.RESET);
            this.setHealth(0);
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
