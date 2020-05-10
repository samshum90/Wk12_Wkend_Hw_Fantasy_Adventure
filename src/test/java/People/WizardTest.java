package People;

import Creature.Owl;
import Equipment.IWeapon;
import Equipment.Staff;
import People.Wizard;
import Skills.Blizzard;
import Skills.FireBall;
import org.junit.Before;
import org.junit.Test;

import javax.swing.plaf.basic.BasicListUI;

import static org.junit.Assert.assertEquals;

public class WizardTest {

    Wizard player1;
    Owl owl;
    Staff staff;
    FireBall fireBall;
    Blizzard blizzard;

    @Before
    public void before(){
        player1 = new Wizard( "Holdolf the Hazy", 40, 40, 15, 20);
        staff = new Staff( 22, 4);
        owl = new Owl( "Owl",5, 5 );
        fireBall = new FireBall( 20, 2, "Single");
        blizzard = new Blizzard( 10, 2, "All");
    }

    @Test
    public void canGetName(){
        assertEquals( "Holdolf the Hazy", player1.getName());
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
        player1.addBag(staff);
        assertEquals( 1, player1.getBagCount());
    }

    @Test
    public void canGetWeapon(){
        assertEquals( null, player1.getWeapon());
    }

    @Test
    public void canequipWeapon(){
        player1.equipWeapon(staff);
        assertEquals( staff, player1.getWeapon());
    }

    @Test
    public void canUnequipWeapon() {
        player1.equipWeapon(staff);
        player1.unequipWeapon( staff );
        assertEquals(null, player1.getWeapon());
        assertEquals(1, player1.getBagCount());
    }

    @Test
    public void canAttack(){
        player1.equipWeapon( staff );
        assertEquals(22, player1.attack());
    }

    @Test
    public void canAttackWithCreature(){
        player1.equipWeapon( staff );
        player1.summon(owl);
        assertEquals(27, player1.attack());
    }

    @Test
    public void canSummon(){
        player1.summon(owl);
        assertEquals( owl, player1.getCreature());
    }

    @Test
    public void canUnsummon(){
        player1.summon(owl);
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

    @Test
    public void canPlayerCast(){
        player1.equipSpell( fireBall );
        assertEquals( 20, player1.cast());
    }

    @Test
    public void canPlayerCastWithCreature(){
        player1.equipSpell( fireBall );
        player1.summon( owl );
        assertEquals( 25, player1.cast());
    }

    @Test
    public void canReduceMP(){
        player1.equipSpell( fireBall );
        player1.reduceMp();
        assertEquals( 38, player1.getMp());
    }

    @Test
    public void canCastWithReduceMP(){
        player1.equipSpell( fireBall );
        assertEquals( 20, player1.castSpell());
        assertEquals( 38, player1.getMp());
    }
    @Test
    public void canCastWithReduceMPWithCreature(){
        player1.equipSpell( fireBall );
        player1.summon( owl );
        assertEquals( 25, player1.castSpell());
        assertEquals( 38, player1.getMp());
    }
}
