package People;

import Equipment.Club;
import Equipment.IWeapon;
import Item.ICarry;

import java.util.ArrayList;

public abstract class Player {

    private String name;
    private int hp;
    private int wallet;
    private int carryCapacity;
    private IWeapon weapon;
    private ArrayList<ICarry> bag;

    public Player(String name, int hp, int wallet, int carryCapacity) {
        this.name = name;
        this.hp = hp;
        this.wallet = wallet;
        this.carryCapacity = carryCapacity;
        this.weapon = null;
        this.bag = new ArrayList<ICarry>();
    }

    public String getName() {
        return this.name;
    }

    public int getHp() {
        return this.hp;
    }

    public int getWallet() {
        return this.wallet;
    }

    public int getCarryCapacity() {
        return this.carryCapacity;
    }

    public IWeapon getWeapon() {
        return this.weapon;
    }

    public int getBagCount() {
        return this.bag.size();
    }

    public void equipWeapon(IWeapon weapon) {
        this.weapon = weapon;
    }

    public void addBag(ICarry item) {
        this.bag.add( item );
    }

    public void unequipWeapon(ICarry weapon) {
            this.weapon = null;
            this.bag.add( weapon );
    }

    public int attack() {
        return this.weapon.getDamage();
    }

}

