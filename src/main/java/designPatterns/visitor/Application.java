package designPatterns.visitor;

import designPatterns.visitor.cyclicVisitor.*;

public class Application {
    public static void main(String args[]){
        Visitor visitor = new PrintVisitor();
        
        Expression additionExpression = new AdditionExpression(
                new AdditionExpression(
                        new DoubleExpression(1.0),
                        new DoubleExpression(2.0)
                ),
                new DoubleExpression(4.9)
        );
        
        Expression expression = new DoubleExpression(3.0);
        // ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
        String a = "g1 act car";
        String b = "a8 act zoo";
    
        String key1 = a.substring(0,a.indexOf(' '));
        String key2 = b.substring(0,b.indexOf(' '));
    
        String rem1 = a.substring(a.indexOf(' ')+1);
        String rem2 = b.substring(b.indexOf(' ')+1);
    
        if(rem1.compareTo(rem2) == 0)
            System.out.println(" key compare: "+key1.compareTo(key2));
    
        System.out.println(" Rem compare: "+rem1.compareTo(rem2));
        
        System.out.println(a.compareTo(b));
    }
}
