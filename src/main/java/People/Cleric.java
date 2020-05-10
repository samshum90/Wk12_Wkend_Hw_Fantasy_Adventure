package People;

import Equipment.IHealTool;
import Equipment.Rod;
import Item.ICarry;
import Skills.ICast;
import Skills.IHeal;

public class Cleric extends Player{

    private int mp;
    private IHealTool tool;

    public Cleric(String name, int hp, int mp, int wallet, int carryCapacity) {
        super(name, hp, wallet, carryCapacity);
        this.mp = mp;
        this.tool = null;
    }

    public IHealTool getTool() {
        return tool;
    }

    public int getMp() {
        return mp;
    }

    public int toolHeal(){
        return this.getTool().heal();
    }

    @Override
    public int attack() {
        return super.attack() - 17;
    }

    public void equipTool(IHealTool tool) {
        this.tool = tool;
    }

    public void unequipTool(ICarry tool) {
        this.tool = null;
        addBag( tool );
    }
}
