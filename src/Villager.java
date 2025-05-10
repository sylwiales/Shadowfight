public class Villager implements Fighter {
    private final String name;
    private final int age;
    private int health;

    Villager(String name, int age) {
        this.name = name;
        this.age = age;
        this.health = 100;
    }
    public String getName() {
        return this.name;
    }
    public int getAge() {return this.age;}
    public int getHealth(){
        return this.health;
    }

    public void sayHello() {
        System.out.println("Witaj podróżniku. Nazywam się " + Colour.BLUE_BRIGHT + this.getName() + Colour.RESET + ". Mam " + this.getAge() + " lat.");
    }
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void attack(Fighter victim) {
        int damage = (int)((100 - this.getAge() * 0.5) / 10);
        victim.takeHit(damage);
    }

    @Override
    public void takeHit(int damage) {
        System.out.println(Colour.BLUE_BOLD + this.getName() + Colour.RESET + " otrzymuje " + Colour.RED + damage + Colour.RESET + " punktów obrażeń.");
        this.setHealth(this.getHealth() - damage);
        if(this.getHealth() <= 0){
            System.out.println(Colour.RED + this.getName() + " umiera!" + Colour.RESET);
        }
    }
}
