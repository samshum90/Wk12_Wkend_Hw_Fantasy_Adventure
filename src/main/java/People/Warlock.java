package People;

import Creature.Creature;
import Creature.Golem;
import People.Spellcaster;

public class Warlock extends Spellcaster implements ISummon {

    private Creature creature;

    public Warlock(String name, int hp, int mp, int wallet, int carryCapacity) {
        super(name, hp, mp, wallet, carryCapacity);
        this.creature = null;
    }

    public void summon(Creature creature) {
        this.creature = creature;
    }

    ;

    public void unsummon() {
        this.creature = null;
    }

    ;

    public void summon() {
        Golem golem = new Golem( "Golem", 10, 20);
        this.creature = golem;
    }

    public Creature getCreature() {
        return this.creature;
    }

    @Override
    public int attack() {
        int total = 0;
        if (this.getWeapon() != null) {
            total += this.getWeapon().getDamage();
        }
        if (this.creature != null) {
            total += this.creature.getDamage();
        }
        return total;
    }

    @Override
    public int cast() {
        int total = 0;
        if (this.getSpell() != null) {
            total += this.spell.cast();
        }
        if (this.creature != null) {
            total += this.creature.getDamage();
        }
        return total;
    }
}