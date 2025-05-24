public class Monsters {
    
    public static final Monster skeleton = new Monster("Cukan",10, 20, "Prachuje wam kości >:)", Art.SKELETON_ART) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.getDamage());
        }

        @Override
        public void takeHit(int damage) {
            System.out.println(Colour.PURPLE_BRIGHT + this.getName() + Colour.RESET + " traci " + Colour.RED + damage + Colour.RESET + " punktów życia.");
            this.setHealth(this.getHealth() - damage);

            if(this.getHealth() <= 0) {
                System.out.println(Colour.GREEN_BRIGHT + this.getName() + " pokonany!" + Colour.RESET);
            }
        }
    };

    public static final Monster ben = new Monster("Ben?",10, 20, "Ben?", Art.BEN_ART) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.getDamage());
        }

        @Override
        public void takeHit(int damage) {
            System.out.println(Colour.PURPLE_BRIGHT + this.getName() + Colour.RESET + " traci " + Colour.RED + damage + Colour.RESET + " punktów życia.");
            this.setHealth(this.getHealth() - damage);

            if(this.getHealth() <= 0) {
                System.out.println(Colour.GREEN_BRIGHT + this.getName() + " pokonany!" + Colour.RESET);
            }
        }
    };

    public static final Monster dragon = new Monster("Dziki smok",10, 20, "Dragon dialogue", Art.DRAGON_ART) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.getDamage());
        }

        @Override
        public void takeHit(int damage) {
            System.out.println(Colour.PURPLE_BRIGHT + this.getName() + Colour.RESET + " traci " + Colour.RED + damage + Colour.RESET + " punktów życia.");
            this.setHealth(this.getHealth() - damage);

            if(this.getHealth() <= 0) {
                System.out.println(Colour.GREEN_BRIGHT + this.getName() + " pokonany!" + Colour.RESET);
            }
        }
    };

    public static final Monster griffin = new Monster("Gryf", 10, 20, "Griffin dialogue", Art.GRIFFIN_ART) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.getDamage());
        }

        @Override
        public void takeHit(int damage) {
            System.out.println(Colour.PURPLE_BRIGHT + this.getName() + Colour.RESET + " traci " + Colour.RED + damage + Colour.RESET + " punktów życia.");
            this.setHealth(this.getHealth() - damage);

            if(this.getHealth() <= 0) {
                System.out.println(Colour.GREEN_BRIGHT + this.getName() + " pokonany!" + Colour.RESET);
            }
        }
    };

    public static final Monster maksio = new Monster("Maksio", 10, 20, "Maksio dialogue", Art.MAKSIO_ART) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.getDamage());
        }

        @Override
        public void takeHit(int damage) {
            System.out.println(Colour.PURPLE_BRIGHT + this.getName() + Colour.RESET + " traci " + Colour.RED + damage + Colour.RESET + " punktów życia.");
            this.setHealth(this.getHealth() - damage);

            if(this.getHealth() <= 0) {
                System.out.println(Colour.GREEN_BRIGHT + this.getName() + " pokonany!" + Colour.RESET);
            }
        }
    };

    public static final Monster ghosts = new Monster("Ghost team", 10, 20, "Ghosts dialogue", Art.GHOSTS_ART) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.getDamage());
        }

        @Override
        public void takeHit(int damage) {
            System.out.println(Colour.PURPLE_BRIGHT + this.getName() + Colour.RESET + " traci " + Colour.RED + damage + Colour.RESET + " punktów życia.");
            this.setHealth(this.getHealth() - damage);

            if(this.getHealth() <= 0) {
                System.out.println(Colour.GREEN_BRIGHT + this.getName() + " pokonany!" + Colour.RESET);
            }
        }
    };

    public static final Monster wizard = new Monster("GM", 10, 20, "Wizard dialogue", Art.WIZARD_ART) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.getDamage());
        }

        @Override
        public void takeHit(int damage) {
            System.out.println(Colour.PURPLE_BRIGHT + this.getName() + Colour.RESET + " traci " + Colour.RED + damage + Colour.RESET + " punktów życia.");
            this.setHealth(this.getHealth() - damage);

            if(this.getHealth() <= 0) {
                System.out.println(Colour.GREEN_BRIGHT + this.getName() + " pokonany!" + Colour.RESET);
            }
        }
    };
}