package Group;

import Enemy.Easy.Skeleton;
import Enemy.Easy.Troll;
import Enemy.Easy.Wolf;
import Enemy.Enemy;
import Equipment.Club;
import Equipment.IWeapon;

import java.util.ArrayList;
import java.util.Arrays;
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

    public ArrayList<Enemy> getEnemies() {
        return enemies;
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

    public void removeEnemy(Enemy enemy){
        this.enemies.remove(enemy);
    }

    private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public void generateEasyEnemy(int o) {
        int j = o + 1;
        int numOfEnemies = j + 3;
        while ( getEnemiesCount() < numOfEnemies) {
            int a = getRandomNumberInRange(0, j);
            System.out.println(a);
            for (int i = 0; i < a; i++) {
                int l = getRandomNumberInRange(1, 10);
                Skeleton skeleton = new Skeleton( "Skeleton", l, l, l);
                addEnemy(skeleton);
            }
            int b = getRandomNumberInRange(0, j);
            System.out.println(b);
            for (int i = 0; i < b; i++) {
                int l = getRandomNumberInRange(1, j*5);
                Wolf wolf = new Wolf( "Wolf", l+10, l, l);
                addEnemy(wolf);
            }
            int c = getRandomNumberInRange(0, j);
            System.out.println(c);
            for (int i = 0; i < c; i++) {
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

    public void enemyInfo() {
        for (int i = 0; i < getEnemiesCount(); i++) {
            System.out.println(String.format( "%s. %s",i, showEnemyInfo(i)));
        }
    }

    public Enemy getEnemyByIndex(int i) {
        return this.enemies.get(i);
    }

    public void enemyHpCheck( Party party ){
        for (int i = 0; i < getEnemiesCount(); i++) {
            Enemy enemy = getEnemyByIndex(i);
            if(enemy.getHp() <= 0){
                System.out.println(String.format("%s. %s has died", i, enemy.getType()));
                party.addTreasure(enemy.getWallet());
                removeEnemy(enemy);
            }
        }
    }
}