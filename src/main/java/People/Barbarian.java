package People;

import Equipment.IWeapon;
import Item.ICarry;
import People.Warrior;

import java.util.ArrayList;

public class Barbarian extends Warrior {

    public Barbarian(String name, int hp, int wallet, int carryCapacity) {
        super(name, hp, wallet, carryCapacity);
    }

}
