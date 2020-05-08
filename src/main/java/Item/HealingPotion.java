package Item;

import Skills.IHeal;

public class HealingPotion implements IHeal, ICarry {

    private int amount;
    private int weight;

    public HealingPotion(int amount, int mpCost) {
        this.amount = amount;
        this.weight = mpCost;
    }
    public int heal() {
        return this.amount;
    }

    public int getWeight() {
        return this.weight;
    }
}