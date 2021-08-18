package designPatterns.cor;

public abstract class CreatureModifier {
    
    public Creature getCreature() {
        return creature;
    }
    
    public void setCreature(Creature creature) {
        this.creature = creature;
    }
    
    public Game getGame() {
        return game;
    }
    
    public void setGame(Game game) {
        this.game = game;
    }
    
    protected Creature creature;
    protected Game game;
    
    
    public CreatureModifier(Creature creature, Game game) {
        this.creature = creature;
        this.game = game;
    }
}
