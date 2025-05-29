public class Data {
    public enum AttackType {
        SLASHING("sieczne"),
        PIERCING("przebijające"),
        BLUDGEONING("obuchowe"),
        MAGIC("magiczne");

        private final String name;

        AttackType(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }

    public static final String[] COMPANION_DATA = {
            "Natinel,20,30,SLASHING",
            "Klara,20,30,BLUDGEONING",
            "Zaphiel,15,40,MAGIC",
            "Czerkow,20,30,PIERCING",
            "Witold,23,30,PIERCING",
            "Tshiela,20,30,MAGIC"
    };
}
