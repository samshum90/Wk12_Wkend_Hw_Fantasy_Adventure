package People;

import Creature.Creature;
import Skills.ICast;

public abstract class Spellcaster extends Player {

    private int mp;
    private Creature creature;
    private ICast spell;

    public Spellcaster(String name, int hp, int mp, int wallet, int carryCapacity) {
        super(name, hp, wallet, carryCapacity);
        this.mp = mp;
        this.creature = null;
        this.spell = null;
    }

    public int getMp() {
        return mp;
    }
}
