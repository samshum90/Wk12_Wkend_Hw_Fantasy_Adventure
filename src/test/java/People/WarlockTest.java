package People;


import Creature.Golem;
import Equipment.Wand;
import Skills.Blizzard;
import Skills.FireBall;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WarlockTest {


    Warlock player1;
    Golem golem;
    Wand wand;
    FireBall fireBall;
    Blizzard blizzard;

    @Before
    public void before(){
        player1 = new Warlock( "Mehthesto", 40, 40, 15, 20);
        wand = new Wand( 5 , 2);
        golem = new Golem( "Golem", 5, 5 );
        fireBall = new FireBall( 20, 2, "Single");
        blizzard = new Blizzard( 10, 2, "All");
    }

    @Test
    public void canGetName(){
        assertEquals( "Mehthesto", player1.getName());
    }

    @Test
    public void canGetHP(){
        assertEquals( 40, player1.getHp());
    }

    @Test
    public void canGetMP(){
        assertEquals( 40, player1.getMp());
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
        player1.addBag(wand);
        assertEquals( 1, player1.getBagCount());
    }

    @Test
    public void canGetWeapon(){
        assertEquals( null, player1.getWeapon());
    }

    @Test
    public void canequipWeapon(){
        player1.equipWeapon(wand);
        assertEquals( wand, player1.getWeapon());
    }

    @Test
    public void canUnequipWeapon() {
        player1.equipWeapon(wand);
        player1.unequipWeapon( wand );
        assertEquals(null, player1.getWeapon());
        assertEquals(1, player1.getBagCount());
    }

    @Test
    public void canAttack(){
        player1.equipWeapon( wand );
        assertEquals(5, player1.attack());
    }

    @Test
    public void canAttackWithCreature(){
        player1.equipWeapon( wand );
        player1.summon(golem);
        assertEquals(10, player1.attack());
    }

    @Test
    public void canSummon(){
        player1.summon(golem);
        assertEquals( golem, player1.getCreature());
    }

    @Test
    public void canUnsummon(){
        player1.summon(golem);
        player1.unsummon();
        assertEquals( null, player1.getCreature());
    }

    @Test
    public void canEquipSpell(){
        player1.equipSpell(fireBall);
        assertEquals( fireBall, player1.getSpell());
    }

    @Test
    public void canUnequipSpell(){
        player1.equipSpell(fireBall);
        player1.unEquipSpell();
        assertEquals( null, player1.getSpell());
    }

    @Test
    public void canChangeSpell(){
        player1.equipSpell(fireBall);
        player1.changeSpell(blizzard);
        assertEquals( blizzard, player1.getSpell());
    }


}
