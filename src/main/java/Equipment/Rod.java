package Equipment;

import Item.ICarry;
import Skills.IHeal;

public class Rod implements IWeapon, IHeal, ICarry, IHealTool {

    private int damage;
    private int weight;
    private int healAmount;

    public Rod(int damage, int weight, int healAmount) {
        this.damage = damage;
        this.weight = weight;
        this.healAmount = healAmount;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getWeight() {
        return this.weight;
    }

    public int heal() {
        return this.healAmount;
    }
}
