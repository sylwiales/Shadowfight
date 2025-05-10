public abstract class Monster implements Fighter {
    private int health;
    private final int damage;
    private final String dialogue;

    public Monster(int health, int damage, String dialogue) {
        this.health = health;
        this.damage = damage;
        this.dialogue = dialogue;
    }
    public int getHealth() {
        return this.health;
    }
    public int getDamage() { return this.damage;}

    public void setHealth(int health) {
        this.health = health;
    }

    public void sayDialogue() {System.out.println(this.dialogue);}
}


