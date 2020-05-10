import Creature.Owl;
import Enemy.Hard.Orc;
import Equipment.Club;
import Equipment.Staff;
import Group.Room;
import People.Wizard;
import Skills.Blizzard;
import Skills.FireBall;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuestTest {

    Room room;
    Orc orc;
    Wizard player1;
    Staff staff;
    Owl owl;
    FireBall fireBall;
    Blizzard blizzard;
    Club club;
    Quest quest;

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
        quest = new Quest();
    }

    @Test
    public void canGetPlayersCount(){
        assertEquals( 0, quest.getPartyCount());
    }

    @Test
    public void canAddPlayers(){
        quest.addPlayer(player1);
        assertEquals( 1, quest.getPartyCount());
    }
    @Test
    public void canGetRoomCount(){
        assertEquals( 0, quest.getRoomCount());
    }

    @Test
    public void canAddRooms(){
        quest.addRoom(room);
        assertEquals( 1, quest.getRoomCount());
    }

    @Test
    public void canPlayerAttack(){
        quest.addPlayer(player1);
        room.addEnemy(orc);
        player1.equipWeapon( staff );
        int attackAmount = player1.attack();
        orc.takeDamage(attackAmount);
        assertEquals( 25, orc.getHp());
    }

    @Test
    public void canPlayerAttackWithCreature(){
        quest.addPlayer(player1);
        room.addEnemy(orc);
        player1.equipWeapon( staff );
        player1.summon( owl );
        int attackAmount = player1.attack();
        orc.takeDamage(attackAmount);
        assertEquals( 20, orc.getHp());
    }

    @Test
    public void canPlayerCast(){
        quest.addPlayer(player1);
        room.addEnemy(orc);
        player1.equipSpell( fireBall );
        int attackAmount = player1.cast();;
        orc.takeDamage(attackAmount);
        assertEquals( 10, orc.getHp());
    }

    @Test
    public void canPlayerCastWithCreature(){
        quest.addPlayer(player1);
        room.addEnemy(orc);
        player1.equipSpell( fireBall );
        player1.summon( owl );
        int attackAmount = player1.cast();;
        orc.takeDamage(attackAmount);
        assertEquals( 5, orc.getHp());
    }

    @Test
    public void canPreQuest(){
            quest.prepareQuest(1);
        assertEquals( 1, quest.getRoomCount());
    }

}
