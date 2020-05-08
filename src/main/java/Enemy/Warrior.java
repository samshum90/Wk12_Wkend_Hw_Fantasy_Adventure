package Enemy;

import Equipment.IWeapon;

public abstract class Warrior extends Enemy{

    private IWeapon weapon;

    public Warrior(String name, String type, int hp) {
        super(name, type, hp);
        this.weapon = null;
    }

    public IWeapon getWeapon() {
        return weapon;
    }
}
