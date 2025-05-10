public class Companion implements Fighter {
    private final String name;
    private final int strength;
    private int health;

    Companion(String name, int strength, int health) {
        this.name = name;
        this.strength = strength;
        this.health = health;
    }
    public String getName() {return this.name;}
    public int getStrength() {return this.strength;}
    public int getHealth() {return this.health;}

    public void sayHello() {
        System.out.println("Witaj podróżniku. Nazywam się " + Colour.BLUE_BRIGHT + this.getName() + Colour.RESET);
    }
    public void setHealth(int health) {this.health = health;}

    @Override
    public void attack(Fighter victim) {
        int dmg = (int)((100 - this.getStrength() * 0.5) / 10);
        victim.takeHit(dmg);
    }

    @Override
    public void takeHit(int dmg) {
        System.out.println(Colour.BLUE_BOLD + this.getName() + Colour.RESET + " otrzymuje " + Colour.RED + dmg + Colour.RESET + " punktów obrażeń.");

        this.setHealth(this.getHealth() - dmg);
        if(this.getHealth() <= 0){
            System.out.println(Colour.RED + this.getName() + " umiera!" + Colour.RESET);
        }
    }
}
