public class ExtraordinaryVillager extends Villager{
    public enum Skill {
        IDENTIFY("I will identify items for you at no charge."),
        SHELTER("I can offer you poor shelter.");

        private final String description;

        Skill(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    private final Skill skill;

    ExtraordinaryVillager(String name, int age, Skill skill) {
        super(name, age);
        this.skill = skill;
        this.setHealth(1);
    }

    public void sayHello(){
        System.out.println("Witaj podróżniku. Nazywam się " + Colour.BLUE_BRIGHT + this.getName() + Colour.RESET + ". Mam " + this.getAge() + " lat. " + skill.getDescription());
    }
    @Override
    public void attack(Fighter victim) {
        victim.takeHit(0);
    }
}
