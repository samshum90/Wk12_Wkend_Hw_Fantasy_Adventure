package Enemy.Hard;

import Enemy.Spellcaster;
import Skills.ICast;

public class Sorcerer extends Spellcaster {

    public Sorcerer(String type, int hp, int damage, int wallet, ICast spell) {
        super(type, hp, damage, wallet, spell);
    }
}
