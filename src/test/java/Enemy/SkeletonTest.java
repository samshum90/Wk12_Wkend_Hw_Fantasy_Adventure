package Enemy;

import Enemy.Easy.Skeleton;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SkeletonTest {

    Skeleton skeleton;

    @Before
    public void before(){
        skeleton =  new Skeleton( "skeleton",30, 30, 10);
    }
    @Test
    public void canGetHP(){
        assertEquals( 30, skeleton.getHp());
    }
    @Test
    public void canGetType(){
        assertEquals( "skeleton", skeleton.getType());
    }
    @Test
    public void canGetdamage(){
        assertEquals( 30, skeleton.attack());
    }
    @Test
    public void canGetWallet(){
        assertEquals( 10, skeleton.getWallet());
    }
    @Test
    public void canTakeDamage(){
        skeleton.takeDamage(20);
        assertEquals( 10, skeleton.getHp());
    }
    @Test
    public void canAttack(){
        assertEquals( 30, skeleton.attack());
    }
    @Test
    public void canGetInfo(){
        assertEquals( "skeleton HP:30 Damage:30 Gold:10", skeleton.enemyInfo());
    }
}

