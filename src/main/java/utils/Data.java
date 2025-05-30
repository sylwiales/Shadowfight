package utils;

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
            "Klara,25,30,BLUDGEONING",
            "Zaphiel,15,50,MAGIC",
            "Czerkow,15,45,PIERCING",
            "Witold,25,30,PIERCING",
            "Eudora,25,20,MAGIC",
            "Lilith,20,30,SLASHING",
            "Zerith,20,30,BLUDGEONING"
    };
}
