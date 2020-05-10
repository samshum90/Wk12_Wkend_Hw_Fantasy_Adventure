package People;

import Creature.Creature;
import Creature.Skeleton;

public class Necromancer extends Spellcaster implements ISummon {

    private Creature creature;

    public Necromancer(String name, int hp, int mp, int wallet, int carryCapacity) {
        super(name, hp, mp, wallet, carryCapacity);
        this.creature = null;
    }

    public void summon(Creature creature) {
        this.creature = creature;
    }

    ;

    public void unsummon() {
        this.creature = null;
    };

    public void summon() {
        Skeleton skele = new Skeleton("Skeleton",20, 10);
        this.creature = skele;
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