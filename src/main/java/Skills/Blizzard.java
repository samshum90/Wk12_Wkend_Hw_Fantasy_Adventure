package Skills;

public class Blizzard implements ICast{

    private int damage;
    private int mpCost;
    private String target;

    public Blizzard(int damage, int mpCost, String target) {
        this.damage = damage;
        this.mpCost = mpCost;
        this.target = target;
    }

    public String getTarget() {
        return target;
    }

    public int getDamage() {
        return damage;
    }

    public int getMpCost() {
        return mpCost;
    }

    public int cast() {
        return getDamage();
    }
}