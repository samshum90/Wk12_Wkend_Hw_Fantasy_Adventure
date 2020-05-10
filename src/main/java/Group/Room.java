package Group;

import Enemy.Easy.Skeleton;
import Enemy.Easy.Troll;
import Enemy.Easy.Wolf;
import Enemy.Enemy;
import Equipment.Club;
import Equipment.IWeapon;

import java.util.ArrayList;
import java.util.Random;

public class Room {

    private int roomNum;
    private int Treasure;
    private Enemy enemy;
    private ArrayList<Enemy> enemies;
    private boolean complete;


    public Room(int roomNum, int treasure) {
        this.roomNum = roomNum;
        this.Treasure = treasure;
        this.enemies = new ArrayList<Enemy>();
        this.complete = false;
    }

    public int getRoomNum() {
        return this.roomNum;
    }

    public int getTreasure() {
        return Treasure;
    }

    public int getEnemiesCount() {
        return enemies.size();
    }

    public boolean getComplete() {
        return complete;
    }

    public void completed() {
        this.complete = true;
    }



    public void addEnemy(Enemy enemy) {
        this.enemies.add(enemy);
    }

    private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public void generateEasyEnemy(int j) {
        int numOfEnemies = j + 5;
        while (numOfEnemies != getEnemiesCount()) {
            for (int i = 0; i < getRandomNumberInRange(0, j); i++) {
                int l = getRandomNumberInRange(1, 10);
                Skeleton skeleton = new Skeleton( "Skeleton", l, l, l);
                addEnemy(skeleton);
            }
            for (int i = 0; i < getRandomNumberInRange(0, j); i++) {
                int l = getRandomNumberInRange(1, j*5);
                Wolf wolf = new Wolf( "Wolf", l+10, l, l);
                addEnemy(wolf);
            }
            for (int i = 0; i < getRandomNumberInRange(0, j); i++) {
                int l = getRandomNumberInRange(1, j*5);
                IWeapon club = new Club( l, l );
                Troll troll = new Troll( "Troll", l+5, l, l, club);
                addEnemy(troll);
            }
        }
    }

    public String showEnemyInfo(int i) {
        return this.enemies.get(i).enemyInfo();
    }

    public void enemyInfo(Room room) {
        String starterRoomOutput = String.format("Room %s has %s Enemies:", getRoomNum(), getEnemiesCount());
        System.out.println(starterRoomOutput);

        for (int i = 0; i < getEnemiesCount(); i++) {
            System.out.println(String.format( "%s. %s",i, showEnemyInfo(i)));
        }
    }


}