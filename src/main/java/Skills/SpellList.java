package Skills;

import java.util.ArrayList;

public class SpellList {


    private ArrayList<ICast> spellList;

    public SpellList() {
        this.spellList = new ArrayList<ICast>();
        Blizzard blizzard = new Blizzard(5, 4, "All");
        this.spellList.add( blizzard);
        FireBall fireBall = new FireBall( 10, 4, "Single");
        this.spellList.add( fireBall);
        LightningStrike lightningStrike = new LightningStrike( 7, 4, "Three");
        this.spellList.add( lightningStrike);
    }

    public ArrayList<ICast> getSpellList() {
        return spellList;
    }

    public int getSpellListCount() {
        return spellList.size();
    }

    public void showSpellList(){
        int counter = 0;
        for(ICast spell: this.spellList){
            String getClass = String.valueOf(spell.getClass());
            String shortClass = getClass.substring(13);
            System.out.println(String.format("%s. %s Damage: %s, MP Cost: %s, Target: %s ",counter, shortClass, spell.cast(), spell.getMpCost(), spell.getTarget()));
            counter += 1;
        }
    }
    public ICast spellWithIndex(int i){
        return this.spellList.get(i);
    }
}