package Enemy;

public abstract class Enemy{

    private String type;
    private int hp;
    private int damage;
    private int wallet;

    public Enemy( String type, int hp, int damage,int wallet) {
        this.type = type;
        this.hp = hp;
        this.damage = damage;
        this.wallet = wallet;
    }

    public int getHp() {
        return hp;
    }

    public String getType() {
        return this.type;
    }

    public int getWallet() {
        return this.wallet;
    }

    public int attack(){
        return this.damage;
    }

    public void takeDamage(int i) {
        int currentHp = this.hp;
        int finalHp = currentHp - i;
        this.hp = finalHp;
    }

    public String enemyInfo() {
        return String.format( "%s HP:%s Damage:%s Gold:%s", this.type, this.hp, this.damage, this.wallet );
    }
}
