package designPatterns.visitor.cyclicVisitor;

public class SubtractionExpression extends Expression {
    
    public DoubleExpression getD1() {
        return d1;
    }
    
    public void setD1(DoubleExpression d1) {
        this.d1 = d1;
    }
    
    public DoubleExpression getD2() {
        return d2;
    }
    
    public void setD2(DoubleExpression d2) {
        this.d2 = d2;
    }
    
    private DoubleExpression d1;
    private DoubleExpression d2;
    
    public SubtractionExpression(DoubleExpression d1,DoubleExpression d2){
        this.d1 = d1;
        this.d2 = d2;
    }
    
    @Override
    void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
