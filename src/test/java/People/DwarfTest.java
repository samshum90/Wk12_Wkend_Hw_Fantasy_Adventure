package People;


import Equipment.Club;
import Equipment.Sword;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DwarfTest {
    Sword sword;
    Club club;
    Dwarf player1;

    @Before
    public void before(){
        player1 =  new Dwarf( "Grimley", 60, 20, 10);
        sword = new Sword( 20, 2);
        club = new Club( 30, 2);
//        healingPotion = new Tool( 30, "Healing");
    }

    @Test
    public void canGetName(){
        assertEquals( "Grimley", player1.getName());
    }

    @Test
    public void canGetHP(){
        assertEquals( 60, player1.getHp());
    }

    @Test
    public void canGetWallet(){
        assertEquals( 20, player1.getWallet());
    }

    @Test
    public void canGetCarryCapacity(){
        assertEquals( 10, player1.getCarryCapacity());
    }

    @Test
    public void canGetWeapon(){
        assertEquals( null, player1.getWeapon());
    }

    @Test
    public void canequipWeapon(){
        player1.equipWeapon(sword);
        assertEquals( sword, player1.getWeapon());
    }

    @Test
    public void canUnequipWeapon(){
        player1.equipWeapon(sword);
        player1.unequipWeapon(sword);
        assertEquals( null, player1.getWeapon());
        assertEquals( 1, player1.getBagCount());
    }
    @Test
    public void canequipSecondary(){
        player1.equipSecondary(club);
        assertEquals( club, player1.getSecondary());
    }

    @Test
    public void canUnequipSecondary(){
        player1.equipSecondary(club);
        player1.unequipSecondary(club);
        assertEquals( null, player1.getWeapon());
        assertEquals( 1, player1.getBagCount());
    }

    @Test
    public void canGetBagCount(){
        assertEquals( 0, player1.getBagCount());
    }

    @Test
    public void canAddToBag(){
        player1.addBag(sword);
        assertEquals( 1, player1.getBagCount());
    }

    @Test
    public void canAttack(){
        player1.equipWeapon(sword);
        assertEquals(20, player1.attack());
    }

    @Test
    public void canGetSecondaryDamage(){
        player1.equipSecondary(club);
        assertEquals( 30 , player1.getSecondayDamage());
    }

    @Test
    public void canDuelAttack(){
        player1.equipWeapon(sword);
        player1.equipSecondary(club);
        assertEquals(50, player1.attack());
    }
}
