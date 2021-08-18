package designPatterns.visitor.cyclicVisitor;

public class PrintVisitor implements Visitor {
    @Override
    public void visit(DoubleExpression doubleExpression) {
        System.out.print(doubleExpression.getValue());
    }
    
    @Override
    public void visit(AdditionExpression additionExpression) {
        System.out.print("(");
        additionExpression.getDoubleExpression1().accept(this);
        System.out.print("+");
        additionExpression.getDoubleExpression2().accept(this);
        System.out.print(")");
    }
    
    @Override
    public void visit(SubtractionExpression subtractionExpression) {
        System.out.print("(");
        subtractionExpression.getD1().accept(this);
        System.out.print("-");
        subtractionExpression.getD2().accept(this);
        System.out.print(")");
    }
}
