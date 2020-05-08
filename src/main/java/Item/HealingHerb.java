package Item;

import Skills.IHeal;

public class HealingHerb implements IHeal, ICarry {

    private int amount;
    private int weight;

    public HealingHerb(int amount, int mpCost) {
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
