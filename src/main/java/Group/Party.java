package Group;

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

    public void addPlayer(Player player) {
        this.party.add( player );
    }
}
