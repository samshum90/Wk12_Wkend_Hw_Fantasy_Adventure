package Skills;

public class Cura implements IHeal {

    private int amount;
    private int mpCost;
    private String target;

    public Cura(int amount, int mpCost, String target) {
        this.amount = amount;
        this.mpCost = mpCost;
        this.target = target;
    }

    public int getMpCost() {
        return mpCost;
    }

    public String getTarget() {
        return target;
    }

    public int heal() {
        return this.amount;
    }
}