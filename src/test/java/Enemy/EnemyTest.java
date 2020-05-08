//package Enemy;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//
//public class EnemyTest {
//
//    Enemy orc;
//
//    @Before
//    public void before(){
//        orc =  new Enemy( 60,"Orc", "Club");
//    }
//
//    @Test
//    public void canGetHP(){
//        assertEquals( 60, orc.getHp());
//    }
//
//    @Test
//    public void canGetName(){
//        assertEquals( "Orc", orc.getType());
//    }
//
//    @Test
//    public void canGetWeapon(){
//        assertEquals( "Club", orc.getWeapon());
//    }
//
//    @Test
//    public void canTakeDamage(){
//        orc.takeDamage(20);
//        assertEquals( 40, orc.getHp());
//    }
//}
