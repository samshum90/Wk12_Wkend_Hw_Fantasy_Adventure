package Creature;

public abstract class Creature {

    private String type;
    private int damage;
    private int defense;

    public Creature(String type, int damage, int defense) {
        this.type = type;
        this.damage = damage;
        this.defense = defense;
    }

    public String getType(){ return this.type; }

    public int getDamage() {
        return damage;
    }

    public int getDefense() {
        return defense;
    }
}
