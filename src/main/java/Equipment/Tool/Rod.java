package Equipment.Tool;

import Enemy.Easy.Wolf;
import Equipment.IHealTool;
import Equipment.Weapon;
import Item.ICarry;
import Skills.IHeal;

public class Rod extends Weapon implements IHeal, IHealTool {

    private int damage;
    private int weight;
    private int healAmount;
    private int mpCost;

    public Rod(int damage, int weight, int healAmount, int mpCost ) {
        super(damage, weight);
            this.healAmount = healAmount;
            this.mpCost = mpCost;
        }


        public int getMpCost() {
            return mpCost;
        }

    public String getTarget() {
        return null;
    }

    public int getWeight() {
            return this.weight;
        }

        public int heal() {
            return this.healAmount;
        }
    }



