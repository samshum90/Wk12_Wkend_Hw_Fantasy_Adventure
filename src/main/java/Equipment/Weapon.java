package Equipment;

import Item.ICarry;

public abstract class Weapon implements ICarry, IWeapon{
    private int damage;
    private int weight;

    public Weapon(int damage, int weight ) {
        this.damage = damage;
        this.weight = weight;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getWeight() {
        return this.weight;
    }
}

