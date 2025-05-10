public class Monsters {
    public static int monsterHealth = 110;
    public static int getMonsterHealth() {
        return monsterHealth;
    }

    public static final Monster andariel = new Monster(10, 70) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.getDamage());
        }

        @Override
        public void takeHit(int damage) {
            System.out.println(Colour.PURPLE_BRIGHT + "Andariel" + Colour.RESET + " traci " + Colour.RED + damage + Colour.RESET + " punktów życia.");
            monsterHealth -= Math.min(damage, this.getHealth());
            this.setHealth(this.getHealth() - damage);

            if(this.getHealth() <= 0) {
                System.out.println(Colour.GREEN_BRIGHT + "Andariel pokonany!" + Colour.RESET);
            }
        }
    };
    public static final Monster blacksmith = new Monster(100, 25) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.getDamage());
        }

        @Override
        public void takeHit(int damage) {
            if(damage != 0)
                damage += 5;

            System.out.println(Colour.PURPLE_BRIGHT + "Blacksmith " + Colour.RESET + "otrzymuje " + Colour.RED + damage  + Colour.RESET +" punktów obrażeń.");

            monsterHealth -= Math.min(damage, this.getHealth());
            this.setHealth(this.getHealth() - (damage));

            if(this.getHealth() <= 0) {
                System.out.println(Colour.GREEN_BRIGHT + "Blacksmith pokonany!" + Colour.RESET);
            }
        }
    };
}