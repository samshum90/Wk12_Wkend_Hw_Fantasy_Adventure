//package Room;
//
//import Class.Barbarian;
//import Enemy.Enemy;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//
//public class RoomTest {
//
//    Room room;
//    Barbarian player1;
//    Enemy orc;
//
//    @Before
//    public void before(){
//        room = new Room( "Catacombs", 50 );
//        player1 =  new Barbarian( "Grom", 70, 5);
//        orc =  new Enemy( 60,"Orc", "Club");
//    }
//
//    @Test
//    public void canGetName(){
//        assertEquals( "Catacombs", room.getName());
//    }
//
//    @Test
//    public void canGetTreasure(){
//        assertEquals( 50, room.getTreasure());
//    }
//
//    @Test
//    public void canGetPlayersCount(){
//        assertEquals( 0, room.getPlayersCount());
//    }
//
//    @Test
//    public void canGetEnemyCount(){
//        assertEquals( 0, room.getEnemiesCount());
//    }
//
//    @Test
//    public void canAddPlayers(){
//        room.addPlayer(player1);
//        assertEquals( 1, room.getPlayersCount());
//    }
//
//    @Test
//    public void canAddEnemy(){
//        room.addEnemy(orc);
//        assertEquals( 1, room.getEnemiesCount());
//    }
//
////    @Test
////    public void canPlayerAttack(){
////        room.addPlayer(player1);
////        room.addEnemy(orc);
////        int attackAmount = player1.attack();
////        orc.takeDamage(attackAmount);
////        assertEquals( 1, orc.getHp());
////    }
//}
