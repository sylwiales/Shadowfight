public abstract class Monster implements Fighter {
    private int health;
    private final int damage;

    public Monster(int health, int damage) {
        this.health = health;
        this.damage = damage;
    }
    public int getHealth() {
        return this.health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getDamage() {
        return this.damage;
    }
}


