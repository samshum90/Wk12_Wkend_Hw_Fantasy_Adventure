package Enemy;

import Item.ICarry;

import java.util.ArrayList;

public abstract class Enemy{

    private String name;
    private String type;
    private int hp;
    private ArrayList<ICarry> inventory;

    public Enemy(String name, String type, int hp ) {
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.inventory = new ArrayList<ICarry>();
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getInventoryCount() {
        return inventory.size();
    }
}
