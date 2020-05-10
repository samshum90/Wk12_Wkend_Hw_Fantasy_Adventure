package People;

import Creature.Creature;
import Skills.Blizzard;
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


    public Creature getCreature(){
        return this.creature;
    }

    public ICast getSpell(){
        return this.spell;
    }

    public void equipSpell( ICast spell){
        this.spell = spell;
    }

    public void unEquipSpell(){
        this.spell = null;
    };

    public void changeSpell(ICast spell){
        unEquipSpell();
        equipSpell( spell );
    };

    public int cast(){
        int total = 0;
        if(this.getSpell() != null){
            total += this.spell.cast();
        }
        if(this.creature != null){
            total += this.creature.getDamage();
        }
        return total;
    }

    public void reduceMp(){
        int initialMp = this.mp;
        int finalMp = initialMp - this.spell.getMpCost();
        this.mp = finalMp;
    };

    public int castSpell(){
        reduceMp();
        return cast();
    }

    public void summon(Creature creature){
        this.creature = creature;
    };

    public void unsummon(){
        this.creature = null;
    };

    public int attack(){
        int total = 0;
        if(this.getWeapon() != null){
            total += this.getWeapon().getDamage();
        }
        if(this.creature != null){
            total += this.creature.getDamage();
        }
        return total;
    }


}
