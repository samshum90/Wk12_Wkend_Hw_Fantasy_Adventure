package Enemy;

import Skills.ICast;

public abstract class Spellcaster extends Enemy{
    private ICast spell;

    public Spellcaster(String name, String type, int hp) {
        super(name, type, hp);
        this.spell = null;
    }
}
