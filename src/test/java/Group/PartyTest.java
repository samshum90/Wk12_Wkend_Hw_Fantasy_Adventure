package Group;

import Equipment.Club;
import Equipment.IWeapon;
import Equipment.Sword;
import Item.HealingPotion;
import Item.ICarry;
import People.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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
    HealingPotion healingPotion;

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
        healingPotion = new HealingPotion( 10, 1);
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

    @Test
    public void inventoryStartsEmpty(){
        assertEquals(0, party.getInventoryCount());
    }

    @Test
    public void canGetInventoryCapacity(){
        party.addPlayer(player1);
        assertEquals(20, party.getInventoryCapacity());
    }

    @Test
    public void canHpCheck(){
        party.addPlayer(player1);
        party.addPlayer(player2);
        player1.takeDamage(80);
        party.HpCheck();
        assertEquals(1, party.getPartyCount());
    }

    @Test
    public void canCreateWeaponInventory(){
        party.addInventory( sword );
        party.addInventory( club );
        party.addInventory( healingPotion );
        ArrayList<IWeapon> weapons = party.createWeaponInventory();
        assertEquals( 2, weapons.size() );
    }

    @Test
    public void canShowWeaponInventory(){
        party.addInventory( sword );
        party.addInventory( club );
        party.addInventory( healingPotion );
        ArrayList<IWeapon> weapons = party.createWeaponInventory();
        party.showWeaponInventory();
        assertEquals( 2, weapons.size() );
    }


}
