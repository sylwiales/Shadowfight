public abstract class Monster implements Fighter {
    private int health;
    private final int damage;
    private final String dialogue;
    private final String art;

    public Monster(int health, int damage, String dialogue, String art) {
        this.health = health;
        this.damage = damage;
        this.dialogue = dialogue;
        this.art = art;
    }
    public int getHealth() {
        return this.health;
    }
    public int getDamage() { return this.damage;}

    public void setHealth(int health) {
        this.health = health;
    }

    public void sayDialogue() {System.out.println(this.dialogue);}

    public void showArt() {System.out.println(this.art);};
}


