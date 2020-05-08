package Skills;

public class Blizzard implements ICast{

    private int damage;
    private int mpCost;

    public Blizzard(int damage, int mpCost) {
        this.damage = damage;
        this.mpCost = mpCost;
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