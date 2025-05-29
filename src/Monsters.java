import java.util.Random;
public class Monsters {
    private Random rand = new Random();
    public static final Monster skeleton = new Monster("Cukan",40, 20, Data.AttackType.BLUDGEONING,"Prachuje wam kości >:)", Art.SKELETON_ART) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.getDamage(), null);
        }

        @Override
        public void takeHit(int damage, Data.AttackType attackType) {
            boolean isWeak = (attackType == this.getWeakness());
            int finalDamage = isWeak ? damage * 2 : damage;

            if (isWeak) {
                System.out.println(Colour.YELLOW + this.getName() + Colour.RESET + " jest wrażliwy na obrażenia " + attackType.getName() + "! Otrzymuje " + finalDamage + " punktów obrażeń!");
            }
            else{
                System.out.println(Colour.YELLOW + this.getName() + Colour.RESET + " otrzymuje " + finalDamage + " punktów obrażeń!");
            }

            this.setHealth(this.getHealth() - finalDamage);

            if(this.getHealth() <= 0) {
                System.out.println(Colour.GREEN_BRIGHT + this.getName() + " pokonany!" + Colour.RESET);
            }
        }
    };

    public static final Monster ghosts = new Monster("duszki", 100, 20, Data.AttackType.MAGIC,"boo!", Art.GHOST_ART) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.getDamage(), null);
        }

        @Override
        public void takeHit(int damage, Data.AttackType attackType) {
            boolean isWeak = (attackType == this.getWeakness());
            int finalDamage = isWeak ? damage * 2 : 0;

            if (isWeak) {
                System.out.println(Colour.YELLOW + this.getName() + Colour.RESET + " są wrażliwe na obrażenia " + attackType.getName() + "! Otrzymują " + finalDamage + " punktów obrażeń!");
            }
            else{
                System.out.println("Atak przenika przez " + Colour.YELLOW + this.getName() + Colour.RESET + "! Co się dzieje!");
            }

            this.setHealth(this.getHealth() - finalDamage);

            if(this.getHealth() <= 0) {
                System.out.println(Colour.GREEN_BRIGHT + this.getName() + " pokonane!" + Colour.RESET);
            }
        }
    };

    public static final Monster maksio = new Monster("Maksio", 20, 100, Data.AttackType.PIERCING ,"Maksio dialogue", Art.MAKSIO_ART) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.getDamage(),  Data.AttackType.MAGIC);
        }

        @Override
        public void takeHit(int damage, Data.AttackType attackType) {
            boolean isWeak = (attackType == this.getWeakness());
            int finalDamage = isWeak ? damage * 2 : damage;

            if (isWeak) {
                System.out.println(Colour.YELLOW + this.getName() + Colour.RESET + " jest wrażliwy na obrażenia " + attackType.getName() + "! Otrzymuje " + finalDamage + " punktów obrażeń!");
            }
            else{
                System.out.println(Colour.YELLOW + this.getName() + " otrzymuje " + finalDamage + " punktów obrażeń!" + Colour.RESET);
            }

            this.setHealth(this.getHealth() - finalDamage);

            if(this.getHealth() <= 0) {
                System.out.println(Colour.GREEN_BRIGHT + this.getName() + " pokonany!" + Colour.RESET);
            }
        }
    };

    public static final Monster wizard = new Monster("GM", 100, 30, Data.AttackType.SLASHING,"Czy 19 trafia?", Art.WIZARD_ART) {

        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.getDamage(), Data.AttackType.MAGIC);
        }

        @Override
        public void takeHit(int damage, Data.AttackType attackType) {
            boolean isWeak = (attackType == this.getWeakness());
            int finalDamage = isWeak ? damage * 2 : damage;

            if (isWeak) {
                System.out.println(Colour.YELLOW + this.getName() + Colour.RESET + " jest wrażliwy na obrażenia " + attackType.getName() + "! Otrzymuje " + finalDamage + " punktów obrażeń!");
                System.out.println("GM przewidział taki przebieg wydarzeń, już nie jest wrażliwy na obrażenia " + attackType);

            }
            else{
                System.out.println(Colour.YELLOW + this.getName() + " otrzymuje " + finalDamage + " punktów obrażeń!" + Colour.RESET);
            }

            this.setHealth(this.getHealth() - finalDamage);

            if(this.getHealth() <= 0) {
                System.out.println(Colour.GREEN_BRIGHT + this.getName() + " pokonany!" + Colour.RESET);
            }
        }
    };
}