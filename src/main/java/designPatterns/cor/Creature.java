package designPatterns.cor;

public abstract class Creature {
    public Game getGame() {
        return game;
    }
    
    public void setGame(Game game) {
        this.game = game;
    }
    
    public int getAttack() {
        Query query = new Query(this,Operation.ATTACK);
        this.game.events.fire(query);
        return attack;
    }
    
    public void setAttack(int attack) {
        this.attack = attack;
    }
    
    public int getDefense() {
        Query query = new Query(this,Operation.DEFENSE);
        this.game.events.fire(query);
        return defense;
    }
    
    public void setDefense(int defense) {
        this.defense = defense;
    }
    
    private Game game;
    private int attack;
    private int defense;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    private String name;
    
    public Creature(Game game, int attack, int defense) {
        this.game = game;
        this.attack = attack;
        this.defense = defense;
    }
}
