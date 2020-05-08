package Skills;

public class Heal implements IHeal {

    private int amount;
    private int mpCost;

    public Heal(int amount, int mpCost) {
        this.amount = amount;
        this.mpCost = mpCost;
    }
    public int heal() {
        return this.amount;
    }
}
