package Enemy;

import Equipment.Club;
import Equipment.IWeapon;

public abstract class Warrior extends Enemy{

    private IWeapon weapon;

    public Warrior(String type, int hp, int damage, int wallet, IWeapon weapon) {
        super(type, hp, damage, wallet);
        this.weapon = weapon;
    }


    public IWeapon getWeapon() {
        return weapon;
    }

    @Override
    public int attack() {
        int total = super.attack() + this.weapon.getDamage();
        return total;
    }

}
