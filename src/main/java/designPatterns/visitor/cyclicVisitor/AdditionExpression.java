package designPatterns.visitor.cyclicVisitor;

public class AdditionExpression extends Expression {
    
    public Expression getDoubleExpression1() {
        return doubleExpression1;
    }
    
    public void setDoubleExpression1(DoubleExpression doubleExpression1) {
        this.doubleExpression1 = doubleExpression1;
    }
    
    public Expression getDoubleExpression2() {
        return doubleExpression2;
    }
    
    public void setDoubleExpression2(DoubleExpression doubleExpression2) {
        this.doubleExpression2 = doubleExpression2;
    }
    
    private Expression doubleExpression1;
    private Expression doubleExpression2;
    
    public AdditionExpression(Expression d1,Expression d2){
        doubleExpression1 = d1;
        doubleExpression2 = d2;
    }
    
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
