package Group;

import Creature.Owl;
import Enemy.Easy.Skeleton;
import Enemy.Hard.Orc;
import Equipment.Club;
import Equipment.Staff;
import People.Wizard;
import Skills.Blizzard;
import Skills.FireBall;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoomTest {

    Room room;
    Orc orc;
    Wizard player1;
    Staff staff;
    Owl owl;
    FireBall fireBall;
    Blizzard blizzard;
    Club club;
    Skeleton skeleton;

    @Before
    public void before(){
        player1 = new Wizard( "Holdolf the Hazy", 40, 40, 15, 20);
        staff = new Staff( 5, 4);
        owl = new Owl( 5, 5 );
        fireBall = new FireBall( 20, 2);
        blizzard = new Blizzard( 10, 2);
        room = new Room( 1, 50 );
        club = new Club( 10, 2);
        orc =  new Orc( "Orc",30, 30, 10, club);
        skeleton = new Skeleton( "skeleton", 5, 5, 5);
    }

    @Test
    public void canGetRoomNum(){
        assertEquals( 1, room.getRoomNum());
    }

    @Test
    public void canGetTreasure(){
        assertEquals( 50, room.getTreasure());
    }

    @Test
    public void canGetEnemyCount(){
        assertEquals( 0, room.getEnemiesCount());
    }

    @Test
    public void canGetComplete(){
        assertEquals( false, room.getComplete());
    }
    @Test
    public void canComplete(){
        room.completed();
        assertEquals( true, room.getComplete());
    }

    @Test
    public void canAddEnemy(){
        room.addEnemy(orc);
        assertEquals( 1, room.getEnemiesCount());
    }

    @Test
    public void canAddSkele(){
        room.addEnemy(orc);
        room.addEnemy(skeleton);
        assertEquals( 2, room.getEnemiesCount());
    }

    @Test
    public void canGenerateEnemies(){
        room.generateEasyEnemy( 1 );
        assertEquals( 6, room.getEnemiesCount());
    }

    @Test
    public void canGetEnemyInfo(){
        room.addEnemy(orc);
        assertEquals("Orc HP:30 Damage:30 Gold:10", room.showEnemyInfo(0) );
    }

    @Test
    public void canGenerateEnemyinfo(){
        room.generateEasyEnemy( 1 );
        room.enemyInfo(room);
        assertEquals( 6, room.getEnemiesCount());
    }

}
