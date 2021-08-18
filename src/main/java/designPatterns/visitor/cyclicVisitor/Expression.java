package designPatterns.visitor.cyclicVisitor;

public abstract class Expression {
    
    abstract void accept(Visitor visitor); 
    
}
