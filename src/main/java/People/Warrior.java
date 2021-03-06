package People;

import Equipment.IWeapon;
import Item.ICarry;

public abstract class Warrior extends Player{

    private IWeapon secondary;

    public Warrior(String name, int hp, int wallet, int carryCapacity) {
        super(name, hp, wallet, carryCapacity);
        this.secondary = null;
    }

    public IWeapon getSecondary() {
        return this.secondary;
    }

    public void equipSecondary(IWeapon weapon){
        this.secondary = weapon;
    }

    public void unequipSecondary(ICarry weapon) {
        this.secondary = null;
        addBag( weapon );
    }

    public int getSecondayDamage(){
        return this.secondary.getDamage();
    }

    public int attack(){
        int total = 0;
        if(this.getWeapon() != null){
            total += this.getWeapon().getDamage();
        }
        if(this.secondary != null){
            total += this.secondary.getDamage();
        }
        return total;
    }
}
