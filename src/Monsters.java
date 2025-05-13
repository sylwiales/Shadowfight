public class Monsters {
    
    public static final Monster skeleton = new Monster(10, 20, "Prachuje ci kości >:)", Art.SKELETON_ART) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.getDamage());
        }

        @Override
        public void takeHit(int damage) {
            System.out.println(Colour.PURPLE_BRIGHT + "Skeleton" + Colour.RESET + " traci " + Colour.RED + damage + Colour.RESET + " punktów życia.");
            this.setHealth(this.getHealth() - damage);

            if(this.getHealth() <= 0) {
                System.out.println(Colour.GREEN_BRIGHT + "Skeleton pokonany!" + Colour.RESET);
            }
        }
    };

    public static final Monster ben = new Monster(10, 20, "Ben?", Art.BEN_ART) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.getDamage());
        }

        @Override
        public void takeHit(int damage) {
            System.out.println(Colour.PURPLE_BRIGHT + "Ben" + Colour.RESET + " traci " + Colour.RED + damage + Colour.RESET + " punktów życia.");
            this.setHealth(this.getHealth() - damage);

            if(this.getHealth() <= 0) {
                System.out.println(Colour.GREEN_BRIGHT + "Ben pokonany!" + Colour.RESET);
            }
        }
    };

    public static final Monster dragon = new Monster(10, 20, "Dragon dialogue", Art.DRAGON_ART) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.getDamage());
        }

        @Override
        public void takeHit(int damage) {
            System.out.println(Colour.PURPLE_BRIGHT + "Smok" + Colour.RESET + " traci " + Colour.RED + damage + Colour.RESET + " punktów życia.");
            this.setHealth(this.getHealth() - damage);

            if(this.getHealth() <= 0) {
                System.out.println(Colour.GREEN_BRIGHT + "Smok pokonany!" + Colour.RESET);
            }
        }
    };

    public static final Monster griffin = new Monster(10, 20, "Griffin dialogue", Art.GRIFFIN_ART) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.getDamage());
        }

        @Override
        public void takeHit(int damage) {
            System.out.println(Colour.PURPLE_BRIGHT + "Gryf" + Colour.RESET + " traci " + Colour.RED + damage + Colour.RESET + " punktów życia.");
            this.setHealth(this.getHealth() - damage);

            if(this.getHealth() <= 0) {
                System.out.println(Colour.GREEN_BRIGHT + "Gryf pokonany!" + Colour.RESET);
            }
        }
    };

    public static final Monster maksio = new Monster(10, 20, "Maksio dialogue", Art.MAKSIO_ART) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.getDamage());
        }

        @Override
        public void takeHit(int damage) {
            System.out.println(Colour.PURPLE_BRIGHT + "Maksio" + Colour.RESET + " traci " + Colour.RED + damage + Colour.RESET + " punktów życia.");
            this.setHealth(this.getHealth() - damage);

            if(this.getHealth() <= 0) {
                System.out.println(Colour.GREEN_BRIGHT + "Maksio pokonany!" + Colour.RESET);
            }
        }
    };

    public static final Monster ghosts = new Monster(10, 20, "Ghosts dialogue", Art.GHOSTS_ART) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.getDamage());
        }

        @Override
        public void takeHit(int damage) {
            System.out.println(Colour.PURPLE_BRIGHT + "Duchy" + Colour.RESET + " tracą " + Colour.RED + damage + Colour.RESET + " punktów życia.");
            this.setHealth(this.getHealth() - damage);

            if(this.getHealth() <= 0) {
                System.out.println(Colour.GREEN_BRIGHT + "Duchy pokonane!" + Colour.RESET);
            }
        }
    };

    public static final Monster wizard = new Monster(10, 20, "Wizard dialogue", Art.WIZARD_ART) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.getDamage());
        }

        @Override
        public void takeHit(int damage) {
            System.out.println(Colour.PURPLE_BRIGHT + "Czarodziej" + Colour.RESET + " traci " + Colour.RED + damage + Colour.RESET + " punktów życia.");
            this.setHealth(this.getHealth() - damage);

            if(this.getHealth() <= 0) {
                System.out.println(Colour.GREEN_BRIGHT + "Czarodziej pokonany!" + Colour.RESET);
            }
        }
    };
}