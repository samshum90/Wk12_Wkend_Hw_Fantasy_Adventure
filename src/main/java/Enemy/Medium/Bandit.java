package Enemy.Medium;

import Enemy.Warrior;
import Equipment.IWeapon;

public class Bandit extends Warrior {
    public Bandit(String type, int hp, int damage, int wallet, IWeapon weapon) {
        super(type, hp, damage, wallet, weapon);
    }
}
