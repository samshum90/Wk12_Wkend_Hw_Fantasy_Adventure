package Equipment;

import Item.ICarry;

public class Wand implements ICarry, IWeapon {

    private int damage;
    private int weight;

    public Wand(int damage, int weight ) {
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
