package designPatterns.visitor.cyclicVisitor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class DoubleExpression extends Expression {
    private Double value;
    
    @Override
    void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
