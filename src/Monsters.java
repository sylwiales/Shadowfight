import java.util.Random;
public class Monsters {
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
                System.out.println(Colour.YELLOW + this.getName() + " jest słaby na obrażenia " + attackType.getName() + "! Otrzymuje podwójne obrażenia!" + Colour.RESET);
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

    public static final Monster maksio = new Monster("Maksio", 40, 20, Data.AttackType.PIERCING ,"Maksio dialogue", Art.MAKSIO_ART) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.getDamage(), null);
        }

        @Override
        public void takeHit(int damage, Data.AttackType attackType) {
            boolean isWeak = (attackType == this.getWeakness());
            int finalDamage = isWeak ? damage * 2 : damage;

            if (isWeak) {
                System.out.println(Colour.YELLOW + this.getName() + " jest słaby na  " + attackType + "! Otrzymuje podwójne obrażenia!" + Colour.RESET);
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

    public static final Monster ghosts = new Monster("duszki", 40, 20, Data.AttackType.MAGIC,"boo!", Art.GHOST_ART) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.getDamage(), null);
        }

        @Override
        public void takeHit(int damage, Data.AttackType attackType) {
            boolean isWeak = (attackType == this.getWeakness());
            int finalDamage = isWeak ? damage * 2 : 0;

            if (isWeak) {
                System.out.println(Colour.YELLOW + this.getName() + " jest słaby na obrażenia " + attackType.getName() + "! Otrzymuje podwójne obrażenia!" + Colour.RESET);

            }
            else{
                System.out.println("Atak przenika przez " + Colour.YELLOW + this.getName() + Colour.RESET + "! Co się dzieje!");
            }

            this.setHealth(this.getHealth() - finalDamage);

            if(this.getHealth() <= 0) {
                System.out.println(Colour.GREEN_BRIGHT + this.getName() + " pokonany!" + Colour.RESET);
            }
        }
    };

    public static final Monster wizard = new Monster("GM", 40, 20, Data.AttackType.SLASHING,"Czy 19 trafia?", Art.WIZARD_ART) {

        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.getDamage(), Data.AttackType.MAGIC);
        }

        @Override
        public void takeHit(int damage, Data.AttackType attackType) {
            boolean isWeak = (attackType == this.getWeakness());
            int finalDamage = isWeak ? damage * 2 : damage;

            if (isWeak) {
                System.out.println(Colour.YELLOW + this.getName() + " jest słaby na obrażenia" + attackType + "! Otrzymuje podwójne obrażenia!" + Colour.RESET);
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