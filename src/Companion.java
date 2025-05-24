import java.util.Random;

public class Companion implements Fighter {
    private final String name;
    private final int strength;
    private final int maxHealth;
    private int currentHealth;
    private static final Random rand = new Random();

    Companion(String name, int strength, int maxHealth) {
        this.name = name;
        this.strength = strength;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
    }

    // Konstruktor do klejenia losowych postaci nz losowymi statystykami na szybko
    Companion(String name) {
        this.name = name;
        this.strength = 70 + rand.nextInt(31); // 70-100
        this.maxHealth = 40 + rand.nextInt(41); // 40-80
        this.currentHealth = this.maxHealth;
    }

    public String getName() {return this.name;}
    public int getStrength() {return this.strength;}
    public int getMaxHealth() {return this.maxHealth;}
    public int getCurrentHealth() {return this.currentHealth;}

    public void setHealth(int health) {this.currentHealth = health;}

    public void sayHello() {
        System.out.println("Witaj podróżniku. Nazywam się " + Colour.BLUE_BRIGHT + this.getName() + Colour.RESET);
    }

    public String displayInfo(){
        return getName().toUpperCase() + "\t" + Colour.RED + getCurrentHealth() + Colour.RESET + "/" + getMaxHealth();
    }

    @Override
    public void attack(Fighter victim) {
        int dmg = (int)((100 - this.getStrength() * 0.5) / 10);
        victim.takeHit(dmg);
    }

    @Override
    public void takeHit(int dmg) {
        System.out.println(Colour.BLUE_BOLD + this.getName() + Colour.RESET + " otrzymuje " + Colour.RED + dmg + Colour.RESET + " punktów obrażeń.");

        this.setHealth(this.getCurrentHealth() - dmg);
        if(this.getCurrentHealth() <= 0){
            System.out.println(Colour.RED + this.getName() + " umiera!" + Colour.RESET);
        }
    }
}
