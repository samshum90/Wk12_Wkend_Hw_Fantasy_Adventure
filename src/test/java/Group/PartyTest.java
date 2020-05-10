package Group;

import Equipment.Club;
import Equipment.Sword;
import People.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PartyTest {

    Party party;
    Sword sword;
    Club club;
    Barbarian player1;
    Dwarf player2;
    Knight player3;
    Wizard player4;
    Warlock player5;
    Necromancer player6;
    Cleric player7;

    @Before
    public void before(){
        player1 =  new Barbarian( "Grom", 70, 10, 20);
        player2 =  new Dwarf( "Grom", 70, 10, 20);
        player3 =  new Knight( "Grom", 70, 10, 20);
        player4 =  new Wizard( "Grom", 70, 10, 20, 20);
        player5 =  new Warlock( "Grom", 70, 10, 20, 20);
        player6 =  new Necromancer( "Grom", 70, 10, 20, 20);
        player7 =  new Cleric( "Grom", 70, 10, 20, 20);
        sword = new Sword( 20, 2);
        club = new Club( 30, 2);
        party = new Party();
    }

    @Test
    public void partyStartsEmpty(){
        assertEquals(0, party.getPartyCount());
    }

    @Test
    public void canGetTreasure(){
        assertEquals(0, party.getTreasure());
    }

    @Test
    public void canAddPlayer(){
            party.addPlayer(player1);
        assertEquals(1, party.getPartyCount());
    }

    @Test
    public void canAddTreasure(){
        party.addTreasure( 10 );
        assertEquals(10, party.getTreasure());
    }


}
