package Equipment;

import Item.ICarry;

public class Staff implements ICarry, IWeapon{

    private int damage;
    private int weight;

    public Staff(int damage, int weight ) {
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
