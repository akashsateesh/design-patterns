package designPatterns.cor;

public class Query {
    
    public Creature getCreature() {
        return creature;
    }
    
    public void setCreature(Creature creature) {
        this.creature = creature;
    }
    
    public Operation getOperation() {
        return operation;
    }
    
    public void setOperation(Operation operation) {
        this.operation = operation;
    }
    
    private Creature creature;
    private Operation operation;
    public int result;
    
    public Query(Creature creature, Operation operation) {
        this.creature = creature;
        this.operation = operation;
    }
}
