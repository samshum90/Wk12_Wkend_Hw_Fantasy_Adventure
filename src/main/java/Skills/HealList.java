package Skills;

import java.util.ArrayList;

public class HealList {

    private ArrayList<IHeal> healList;

    public HealList() {
        this.healList = new ArrayList<IHeal>();
        Heal heal = new Heal( 20, 4, "Single");
        this.healList.add( heal );
        Cure cure = new Cure( 60, 8, "Single");
        this.healList.add( cure);
        Cura cura = new Cura( 20, 8, "All");
        this.healList.add( cura);
    }

    public ArrayList<IHeal> getHealList() {
        return healList;
    }

    public int getHealListCount() {
        return healList.size();
    }

    public void showSpellList(){
        int counter = 0;
        for(IHeal spell: this.healList){
            String getClass = String.valueOf(spell.getClass());
            String shortClass = getClass.substring(13);
            System.out.println(String.format("%s. %s Heal Amount: %s, MP Cost: %s, Target: %s ",counter, shortClass, spell.heal(), spell.getMpCost(), spell.getTarget()));
            counter += 1;
        }
    }
    public IHeal healWithIndex(int i){
        return this.healList.get(i);
    }
}

