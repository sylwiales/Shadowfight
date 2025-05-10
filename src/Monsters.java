public class Monsters {
    
    public static final Monster skeleton = new Monster(10, 70, "Prachuje ci kości >:)") {
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
        public void showArt(){
            System.out.println("""
              .-.
             (o.o)
              |=|
             __|__
           //.=|=.\\\\
          // .=|=. \\\\
          \\\\ .=|=. //
           \\\\(_=_)//
            (:| |:)
             || ||
             () ()
             || ||
             || ||
            ==' '==
        """);
        }
    };
}