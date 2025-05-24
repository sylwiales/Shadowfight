public abstract class Monster implements Fighter {
    private final String name;
    private int health;
    private final int damage;
    private final String dialogue;
    private final String art;

    public Monster(String name, int health, int damage, String dialogue, String art) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.dialogue = dialogue;
        this.art = art;
    }
    public int getHealth() {
        return this.health;
    }
    public int getDamage() { return this.damage;}
    public String getName() { return this.name;}

    public void setHealth(int health) {
        this.health = health;
    }

    public String sayDialogue() { return this.dialogue;}

    public void showArt() {System.out.println(this.art);};

    public void displayMonsterInfo(int monsterMaxHealth) {
        String monsterName = this.getName();
        int currentHp = this.getHealth();

        int barLength = 20;
        int filled = (int) ((double) currentHp / monsterMaxHealth * barLength);
        this.showArt();
        String healthBar = "[" + Colour.RED + "#".repeat(filled) + Colour.RESET +
                "-".repeat(barLength - filled) + "]";

        System.out.println(Utility.displayHeader(monsterName.toUpperCase()));
        System.out.println("Zdrowie: " + Colour.RED + currentHp + Colour.RESET + "/" + monsterMaxHealth);
        System.out.println(healthBar);
        System.out.println();
    }
}


