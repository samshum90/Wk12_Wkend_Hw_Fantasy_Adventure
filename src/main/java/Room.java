import Enemy.Enemy;
import People.Player;

import java.util.ArrayList;

public class Room {

    private String name;
    private int Treasure;
    private ArrayList<Player> players;
    private ArrayList<Enemy> enemies;

    public Room(String name, int treasure) {
        this.name = name;
        this.Treasure = treasure;
        this.players = new ArrayList<Player>();
        this.enemies = new ArrayList<Enemy>();
    }

    public String getName() {
        return name;
    }

    public int getTreasure() {
        return Treasure;
    }

    public int getPlayersCount() {
        return players.size();
    }

    public int getEnemiesCount() {
        return enemies.size();
    }

    public void addPlayer(Player player){
        this.players.add( player );
    }

    public void addEnemy(Enemy enemy){
        this.enemies.add( enemy );
    }
}