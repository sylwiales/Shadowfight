package characters;
import utils.Data;

public interface Fighter {
    void attack(Fighter victim);
    void takeHit(int damage, Data.AttackType attackType);
}
