package Enemy;

import Skills.ICast;

public abstract class Spellcaster extends Enemy{

    private ICast spell;

    public Spellcaster(String type, int hp, int damage, int wallet, ICast spell) {
        super(type, hp, damage, wallet);
        this.spell = spell;
    }

    public ICast getSpell() {
        return spell;
    }

    @Override
    public int attack() {
        int total = super.attack() + this.spell.cast();
        return total;
    }
}

