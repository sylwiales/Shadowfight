public abstract class Monster implements Fighter {
    private final String name;
    private int health;
    private final int damage;
    private Data.AttackType weakness;
    private final String dialogue;
    private final String[] art;

    public Monster(String name, int health, int damage, Data.AttackType weakness, String dialogue, String[] art) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.weakness = weakness;
        this.dialogue = dialogue;
        this.art = art;
    }
    public int getHealth() {
        return this.health;
    }
    public int getDamage() { return this.damage;}
    public String getName() { return this.name;}
    public String getDialogue() { return this.dialogue;}
    public Data.AttackType getWeakness() { return this.weakness;}
    public void setHealth(int health) {
        this.health = health;
    }
    public void showArt() {Utility.printCenteredText(this.art);}
    public void setWeakness(Data.AttackType weakness){this.weakness = weakness;}

    public void displayMonsterInfo(int monsterMaxHealth) {
        int currentHp = this.getHealth();

        int barLength = Utility.BORDER_LENGTH - 2;
        int filled = (int) ((double) currentHp / monsterMaxHealth * barLength);
        this.showArt();
        String healthBar = "[" + Colour.RED + "#".repeat(filled) + Colour.RESET +
                "-".repeat(barLength - filled) + "]";

        Utility.displayHeader(Colour.PURPLE_BRIGHT + this.getName() + Colour.RESET);
        System.out.println(healthBar);
        System.out.println();
    }
}


