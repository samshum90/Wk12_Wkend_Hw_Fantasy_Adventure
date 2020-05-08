package Creature;

public abstract class Creature {

    private int damage;
    private int defense;

    public Creature(int damage, int defense) {
        this.damage = damage;
        this.defense = defense;
    }

    public int getDamage() {
        return damage;
    }

    public int getDefense() {
        return defense;
    }
}
