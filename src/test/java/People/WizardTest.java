//package Class;
//
//import Class.Creature;
//import Class.Wizard;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//
//public class WizardTest {
//
//
//    Wizard player1;
//    Creature creature;
//
//    @Before
//    public void before(){
//        creature = new Creature( 50, "Troll", 20);
//        player1 =  new Wizard( "Holdorf", 40, 15, creature );
//    }
//
//    @Test
//    public void canGetName(){
//        assertEquals( "Holdorf", player1.getName());
//    }
//
//    @Test
//    public void canGetHP(){
//        assertEquals( 40, player1.getHp());
//    }
//
//    @Test
//    public void canGetWallet(){
//        assertEquals( 15, player1.getWallet());
//    }
//
//    @Test
//    public void canGetArmour(){
//        assertEquals( creature, player1.getCreature());
//    }
//
//    @Test
//    public void canGetEquipmentCount(){
//        assertEquals( 0, player1.getEquipmentCount());
//    }
//
//    @Test
//    public void canGetToolCount(){
//        assertEquals( 0, player1.getToolCount());
//    }
//}
