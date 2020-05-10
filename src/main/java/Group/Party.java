package Group;

import People.Dwarf;
import People.Knight;
import People.Player;

import java.util.ArrayList;

public class Party {

    private ArrayList<Player> party;
    private int treasure;

    public Party() {
        this.party = new ArrayList<Player>();
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

}
