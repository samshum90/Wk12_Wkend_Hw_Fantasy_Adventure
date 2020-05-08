package People;

import Equipment.IWeapon;
import Item.ICarry;
import People.Warrior;

import java.util.ArrayList;

public class Knight extends Warrior {

    public Knight(String name, int hp, int wallet, int carryCapacity) {
        super(name, hp, wallet, carryCapacity);
    }

}