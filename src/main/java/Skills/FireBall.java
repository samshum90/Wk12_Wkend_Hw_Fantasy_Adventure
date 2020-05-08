package Skills;

public class FireBall implements ICast{

    private int damage;
    private int mpCost;

    public FireBall(int damage, int mpCost) {
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
