package Item;

import Skills.IHeal;

public class HealingHerb implements ICarry {

    private int amount;
    private int weight;

    public HealingHerb(int amount, int weight) {
        this.amount = amount;
        this.weight = weight;
    }
    public int heal() {
        return this.amount;
    }

    public int getWeight() {
        return this.weight;
    }
}
