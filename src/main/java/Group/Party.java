package Group;

import Enemy.Enemy;
import Equipment.IWeapon;
import Equipment.Weapon;
import Item.ICarry;
import People.Dwarf;
import People.Knight;
import People.Player;

import java.util.ArrayList;

public class Party {

    private ArrayList<Player> party;
    private ArrayList<ICarry> inventory;
    private int treasure;

    public Party() {
        this.party = new ArrayList<Player>();
        this.inventory = new ArrayList<ICarry>();
        this.treasure = 0;
    }

    public ArrayList<Player> getParty() {
        return party;
    }

    public int getPartyCount() {
        return party.size();
    }

    public int getTreasure() {
        return treasure;
    }

    public void addTreasure(int i) {
        int initialAmount = this.treasure;
        int newAmount = initialAmount + i;
        this.treasure = newAmount;
    }
    public void addPlayer(Player player) {
        this.party.add( player );
    }

    private void removePlayer(Player player) {
        this.party.remove( player );
    }

    public ArrayList<ICarry> getInventory() {
        return this.inventory;
    }

    public int getInventoryCount() {
        return inventory.size();
    }

    public void addInventory( ICarry item ){
        this.inventory.add( item );
    }

    public void removeInventory( ICarry item ){
        this.inventory.remove( item );
    }

    public int getInventoryCapacity(){
        int total = 0;
        for(Player player: this.party){
            total += player.getCarryCapacity();
        }
        return total;
    }

    public Player getPlayerByIndex(int i) {
        return this.party.get(i);
    }

    public void HpCheck() {
            for (Player player: this.party) {
                String classToString = String.format("%s", player.getClass());
                String shortenClass = classToString.substring(13);

                if(player.getHp() <= 0){
                    System.out.println(String.format("%s %s has died", shortenClass, player.getName()));
                    removePlayer( player );
                }
                if (getPartyCount() == 0){
                    System.out.println("Game Over");
                    System.exit(0);
                }
            }
        }

    public ArrayList<IWeapon> createWeaponInventory() {
        ArrayList<IWeapon> weapons = new ArrayList<IWeapon>();
        for( ICarry item: this.inventory){
            if( item instanceof IWeapon){
                weapons.add((IWeapon) item);
            }
        }
        return weapons;
    }

    public void showWeaponInventory(){
        ArrayList<IWeapon> weapons = createWeaponInventory();
        int counter = 0;
        for(IWeapon weapon: weapons){
            String getClass = String.valueOf(weapon.getClass());
            String shortClass = getClass.substring(16);
            System.out.println(String.format("%s. %s Damage: %s",counter, shortClass, weapon.getDamage()));
            counter += 1;
        }
    }
}
