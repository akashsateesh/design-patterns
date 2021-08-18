package designPatterns.cor;

public class DoubleAttackModifier extends CreatureModifier {
    public DoubleAttackModifier(Creature creature, Game game) {
        super(creature, game);
        
        game.events.subscribe(q -> {
            if(q.getCreature().getName().equals(creature.getName())
                && q.getOperation().equals(Operation.ATTACK)
            ){
                q.result *= 2;
            }
        });
        
        
    }
    
    
}
