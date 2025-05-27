import java.util.Random;

public class Companion implements Fighter {
    private final String name;
    private final int strength;
    private final int maxHealth;
    private final Data.AttackType attackType;
    private int currentHealth;

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
    public Data.AttackType getAttackType() {
        return this.attackType;
    } ;

    public void setHealth(int health) {this.currentHealth = health;}

    public void sayHello() {
        System.out.println("Witaj podróżniku. Nazywam się " + Colour.BLUE_BRIGHT + this.getName() + Colour.RESET);
    }

    public String displayInfo(){
        return getName() + "\t\t"
                + Colour.RED + getCurrentHealth() + Colour.RESET + "/" + getMaxHealth()
                + "\tSiła: " + getStrength()
                + "\tObrażenia: " + getAttackType().getName();
    }

    @Override
    public void attack(Fighter victim) {
        int dmg = this.getStrength();
        victim.takeHit(dmg, this.attackType);
    }

    @Override
    public void takeHit(int dmg, Data.AttackType attackType) {
        System.out.println(Colour.BLUE_BOLD + this.getName() + Colour.RESET + " otrzymuje " + Colour.RED + dmg + Colour.RESET + " punktów obrażeń.");
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
