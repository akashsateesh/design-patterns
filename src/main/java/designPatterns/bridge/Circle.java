package designPatterns.bridge;

public class Circle extends Shape {
    public Circle(Render render) {
        super(render);
    }
    
    @Override
    public void draw() {
        
    }
    
}
