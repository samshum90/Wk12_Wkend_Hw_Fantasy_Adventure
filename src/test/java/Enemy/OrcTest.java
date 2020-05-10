package Enemy;

import Enemy.Hard.Orc;
import Equipment.Club;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrcTest {

    Orc orc;
    Club club;

    @Before
    public void before(){
        club = new Club( 10, 2);
        orc =  new Orc( "Orc",30, 30, 10, club);
    }

    @Test
    public void canGetHP(){
        assertEquals( 30, orc.getHp());
    }

    @Test
    public void canGetType(){
        assertEquals( "Orc", orc.getType());
    }

    @Test
    public void canGetdamage(){
        assertEquals( 30, orc.attack());
    }
    @Test
    public void canGetWallet(){
        assertEquals( 10, orc.getWallet());
    }

    @Test
    public void canGetWeapon(){
        assertEquals( club, orc.getWeapon());
    }

    @Test
    public void canTakeDamage(){
        orc.takeDamage(20);
        assertEquals( 10, orc.getHp());
    }

    @Test
    public void canAttack(){
        assertEquals( 10, orc.attack());
    }

    @Test
    public void canGetInfo(){
        assertEquals( "Orc HP:30 Damage:30 Gold:10", orc.enemyInfo());
    }
}
