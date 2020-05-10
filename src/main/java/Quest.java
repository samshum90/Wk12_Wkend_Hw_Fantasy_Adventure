import Enemy.Enemy;
import Equipment.*;
import Group.Party;
import Group.Room;
import People.*;
import Skills.ICast;
import Skills.SpellList;

import java.sql.SQLOutput;
import java.util.Scanner;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.Random;

public class Quest {

    Scanner scanner = new Scanner(System.in);
    private ArrayList<Room> rooms;
    private Party party;
    private SpellList spellList;

    public Quest(){
        this.rooms = new ArrayList<Room>();
        this.party = new Party();
        this.spellList = new SpellList();
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
            room.generateEasyEnemy( i );
            addRoom( room );
            System.out.println(String.format("Room %s created", i));
        }
    }

    public void startQuest() {
        for (Room room : this.rooms) {
            while( !room.getComplete()){

                battle( room );
                battleOutcome( room );
                this.party.addTreasure( room.getTreasure());
            }
        }
    }

    private void battleOutcome(Room room) {
        if( room.getEnemiesCount() == 0){
            room.completed();
            System.out.println(String.format("Room %s Completed", room.getRoomNum()));
        }
    }

    public void battle( Room room) {
         while(room.getEnemiesCount() != 0 ){
             if (this.party.getPartyCount() == 0){
                 System.out.println("Game Over");
                 System.exit(0);
             }
            String starterRoomOutput = String.format("Room %s has %s Enemies:", room.getRoomNum(), room.getEnemiesCount());
            System.out.println(starterRoomOutput);
            room.enemyInfo();
               partyOptions(room);
            room.enemyHpCheck( this.party);
               enemyResponse(room);
            party.HpCheck();
        }
    }

    public void partyOptions(Room room) {
        for (Player player : this.party.getParty()) {
            String classToString = String.format("%s", player.getClass());
            String shortenClass = classToString.substring(13);

            System.out.println(String.format("%s %s pick a move:", shortenClass, player.getName()));
            System.out.println("1.Attack");
            System.out.println("2.Equip Weapon");
            if (shortenClass.equals("Barbarian") || shortenClass.equals("Dwarf") || shortenClass.equals("Knight")) {
                System.out.println("3.Equip Secondary");
            } else if (shortenClass.equals("Wizard") || shortenClass.equals("Warlock") || shortenClass.equals("Necromancer")) {
                System.out.println("3.Cast Spell");
                System.out.println("4.Summon");
            } else if (shortenClass.equals("Cleric")){
                System.out.println("3.Cast Heal");
            }
            playerResponse(room, shortenClass, player);
        }
    }

    public void playerResponse( Room room, String shortenClass, Player player ) {

        String response = scanner.next();
        if (response.toLowerCase().equals("attack") || response.toLowerCase().equals("1")) {
            System.out.println(String.format("%s %s choose a enemy number to attack:", shortenClass, player.getName()));
            room.enemyInfo();
            Enemy enemy = selectEnemy(room );
            playerAttack( player, enemy );
        } else if (response.toLowerCase().equals("Equip Weapon") || response.toLowerCase().equals("2")) {
            party.showWeaponInventory();
            System.out.println(String.format("%s %s choose a weapon number to equip:", shortenClass, player.getName()));
            IWeapon weapon = selectWeapon();
            player.equipWeapon(weapon);
        }else if ((shortenClass.equals("Barbarian") || shortenClass.equals("Dwarf") || shortenClass.equals("Knight")) && (response.toLowerCase().equals("Equip Secondary") || response.toLowerCase().equals("3"))) {
            party.showWeaponInventory();
            System.out.println(String.format("%s %s choose a secondary number to equip:", shortenClass, player.getName()));
            IWeapon weapon = selectWeapon();
            ((Warrior) player).equipSecondary(weapon);
        }else {
            boolean b = shortenClass.equals("Wizard") || shortenClass.equals("Warlock") || shortenClass.equals("Necromancer");
            if (b && (response.toLowerCase().equals("Cast Spell") || response.toLowerCase().equals("3"))){
                spellList.showSpellList();
                System.out.println(String.format("%s %s choose a Spell number to cast:", shortenClass, player.getName()));
                ICast spell = selectSpell();
                castSpell(player, spell, room);
            }else if (b && (response.toLowerCase().equals("Summon") || response.toLowerCase().equals("4"))){
                ((ISummon)player).summon();
                System.out.println(String.format("%s %s has summoned %s", shortenClass, player.getName(), ((ISummon)player).getCreature().getType()));
            }else if ((shortenClass.equals("Cleric") && (response.toLowerCase().equals("Cast Heal") || response.toLowerCase().equals("3")))){
//                showHealSpells();
//                heal();
            }else{
                System.out.println("Input was not recognised please try again");
                playerResponse( room, shortenClass, player );
            }
        }
    }

    public Enemy selectEnemy( Room room ){
        int index = Integer.parseInt(scanner.next());
        if( index > room.getEnemiesCount() - 1){
            System.out.println("Input was not recognised please try again");
            selectEnemy( room );
        }
        Enemy enemy = room.getEnemyByIndex( index);

        return enemy;
    }

    private void playerAttack(Player player, Enemy enemy) {
        int damage = player.attack();
        enemy.takeDamage(damage);
    }

    private void enemyResponse( Room room) {
        int counter = 0;
        for (Enemy enemy : room.getEnemies()) {
            int randomInt = getRandomNumberInRange(0, party.getPartyCount() - 1);
            Player player = party.getPlayerByIndex(randomInt);
            int damage = enemy.attack();
            player.takeDamage(damage);
            System.out.println(String.format("%s. %s has attacked %s and has dealt %s damage", counter, enemy.getType(), player.getName(), damage));
            counter += 1;
        }
    }

    private IWeapon selectWeapon() {
        int index = Integer.parseInt(scanner.next());
        System.out.println(index);
        ArrayList<IWeapon> weapons = party.createWeaponInventory();
        if( index > weapons.size() - 1){
            System.out.println("Input was not recognised please try again");
            selectWeapon();
        }
        IWeapon weapon = weapons.get(index);
        return weapon;
    }

    private ICast selectSpell() {
        int index = Integer.parseInt(scanner.next());
        System.out.println(index);
        if( index > spellList.getSpellListCount() - 1){
            System.out.println("Input was not recognised please try again");
            selectSpell();
        }
        ICast spell = spellList.spellWithIndex(index);
        return spell;
    }

    private void castSpell(Player player, ICast spell, Room room) {
        String classToString = String.format("%s", player.getClass());
        String shortenClass = classToString.substring(13);
        String getClass = String.valueOf(spell.getClass());
        String shortClass = getClass.substring(13);
        if( spell.getTarget().equals("All")){
            ((Spellcaster)player).equipSpell(spell);
            int damage = ((Spellcaster)player).cast();
            allEnemyDamage( damage, room);
            System.out.println(String.format("%s %s cast %s on all enemies", shortenClass, player.getName(), shortClass));
        } else if (spell.getTarget().equals("Three")){
            ((Spellcaster)player).equipSpell(spell);
            int damage = ((Spellcaster)player).cast();
            room.enemyInfo();
            selectAndAttackThreeEnemies( damage, room );
            System.out.println(String.format("%s %s cast %s!", shortenClass, player.getName(), shortClass));
        } else {
            ((Spellcaster)player).equipSpell(spell);
            int damage = ((Spellcaster)player).cast();
            room.enemyInfo();
            Enemy enemy = selectEnemy( room );
            enemy.takeDamage(damage);
            System.out.println(String.format("%s %s cast %s on %s", shortenClass, player.getName(), shortClass, enemy.getType()));
        }
    }

    private void allEnemyDamage(int damage, Room room) {
        for( Enemy enemy: room.getEnemies()){
            enemy.takeDamage(damage);
        }
    }

    public void selectAndAttackThreeEnemies( int damage, Room room ){
        int index = Integer.parseInt(scanner.next());
        if( index > room.getEnemiesCount() - 1){
            System.out.println("Input was not recognised please try again");
            selectAndAttackThreeEnemies(damage, room );
        }
        Enemy enemy1 = room.getEnemyByIndex( index );
        enemy1.takeDamage(damage);
        Enemy enemy2 = room.getEnemyByIndex( index + 1);
        enemy2.takeDamage(damage);
        Enemy enemy3 = room.getEnemyByIndex( index - 1);
        enemy3.takeDamage(damage);
    }


    public void conclusion( int numOfRoom) {
        System.out.println(String.format("Congratulations you have completed %s rooms!!", numOfRoom));
        System.out.println(String.format("Your score was: %s ", party.getTreasure()));

    }
}
