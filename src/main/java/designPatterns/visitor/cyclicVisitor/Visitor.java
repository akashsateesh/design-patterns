package designPatterns.visitor.cyclicVisitor;

public interface Visitor {
    
    void visit(DoubleExpression doubleExpression);
    void visit(AdditionExpression additionExpression);
    void visit(SubtractionExpression subtractionExpression);
    
}
