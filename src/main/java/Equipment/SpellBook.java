package Equipment;

import Item.ICarry;

public class SpellBook implements IWeapon, ICarry {
    private int damage;
    private int weight;

    public SpellBook(int damage, int weight ) {
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
