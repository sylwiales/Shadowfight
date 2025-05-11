public class Companion implements Fighter {
    private final String name;
    private final int strength;
    private final int maxHealth;
    private int currentHealth;

    Companion(String name, int strength, int maxHealth) {
        this.name = name;
        this.strength = strength;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
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
