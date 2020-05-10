package People;

import Equipment.Rod;
import Equipment.Sword;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClericTest {

    Cleric player1;
    Rod rod;
    Sword sword;

    @Before
    public void before(){
        player1 = new Cleric( "Sid", 20,  20, 15, 20);
        rod = new Rod( 5 , 2, 20);
        sword = new Sword(20,2);
    }

    @Test
    public void canGetName(){
        assertEquals( "Sid", player1.getName());
    }

    @Test
    public void canGetHP(){
        assertEquals( 20, player1.getHp());
    }

    @Test
    public void canGetMP(){
        assertEquals( 20, player1.getMp());
    }

    @Test
    public void canGetWallet(){
        assertEquals( 15, player1.getWallet());
    }

    @Test
    public void canGetCarryCapacity(){
        assertEquals( 15, player1.getWallet());
    }

    @Test
    public void canGetBagCount(){
        assertEquals( 0, player1.getBagCount());
    }

    @Test
    public void canAddToBag(){
        player1.addBag(rod);
        assertEquals( 1, player1.getBagCount());
    }

    @Test
    public void canGetWeapon(){
        assertEquals( null, player1.getWeapon());
    }

    @Test
    public void canequipWeapon(){
        player1.equipWeapon(rod);
        assertEquals( rod, player1.getWeapon());
    }

    @Test
    public void canUnequipWeapon() {
        player1.equipWeapon(rod);
        player1.unequipWeapon( rod );
        assertEquals(null, player1.getWeapon());
        assertEquals(1, player1.getBagCount());
    }

    @Test
    public void canAttack(){
        player1.equipWeapon( sword );
        assertEquals(3, player1.attack());
    }

    @Test
    public void canToolHeal(){
        player1.equipTool( rod );
        assertEquals(20, player1.toolHeal());
        assertEquals( rod, player1.getTool());
    }

    @Test
    public void canUnequipTool(){
        player1.equipTool( rod );
        player1.unequipTool( rod );
        assertEquals( null, player1.getTool());
    }
}