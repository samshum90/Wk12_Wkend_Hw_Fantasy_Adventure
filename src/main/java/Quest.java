import Equipment.*;
import Group.Party;
import Group.Room;
import People.*;

import java.util.ArrayList;
import java.util.Random;

public class Quest {

    private ArrayList<Room> rooms;
    private Party party;

    public Quest(){
        this.rooms = new ArrayList<Room>();
        this.party = new Party();
    }

    public int getPartyCount() {
        return this.party.getPartyCount();
    }

    public void addPlayer(Player player){
        this.party.addPlayer( player );
    }

    public int getRoomCount() {
        return this.rooms.size();
    }

    public void addRoom(Room room){
        this.rooms.add( room );
    }
    private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public Player createBarbarian(String playerName){
        int damage = getRandomNumberInRange(10, 30);
        Player player = new Barbarian(playerName, 80, 10, 20);
        Club club = new Club( damage, 4);
        player.equipWeapon( club );
        return player;
    }
    public Player createDwarf(String playerName){
        int damage = getRandomNumberInRange(10, 30);
        Player player = new Dwarf(playerName, 70, 20, 25);
        Axe axe = new Axe( damage, 4);
        player.equipWeapon( axe );
        return player;
    }

    public Player createKnight(String playerName){
        int damage = getRandomNumberInRange(10, 20);
        Player player = new Knight(playerName, 70, 10, 20);
        Sword sword = new Sword( damage, 2);
        player.equipWeapon( sword );
        return player;
    }

    public Player createCleric(String playerName){
        int damage = getRandomNumberInRange(1, 10);
        Player player = new Cleric(playerName, 30, 20, 10, 25);
        Sword sword = new Sword( damage, 2);
        player.equipWeapon( sword );
        return player;
    }

    public Player createWizard(String playerName){
        int damage = getRandomNumberInRange(1, 20);
        Player player = new Wizard(playerName, 50, 20, 10, 15);
        Wand wand = new Wand( damage, 2);
        player.equipWeapon( wand );
        return player;
    }

    public Player createWarlock(String playerName){
        int damage = getRandomNumberInRange(10, 30);
        Player player = new Warlock(playerName, 50, 20, 10, 15);
        Staff staff = new Staff( damage, 4);
        player.equipWeapon( staff );
        return player;
    }

    public Player createNecromancer(String playerName){
        int damage = getRandomNumberInRange(1, 20);
        Player player = new Necromancer(playerName, 50, 20, 10, 15);
        SpellBook spellBook = new SpellBook( damage, 2);
        player.equipWeapon( spellBook );
        return player;
    }

    public void prepareQuest( int roomNumber){
        for (int i = 0; i < roomNumber; i++) {
            int treasure = i * 10;
            Room room = new Room( i, treasure);
            room.generateEasyEnemy( roomNumber );
            addRoom( room );

        }
    }

}
