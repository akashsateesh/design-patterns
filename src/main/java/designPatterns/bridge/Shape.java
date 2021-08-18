package designPatterns.bridge;

public abstract class Shape {
    
    protected Render render;
    
    public Shape(Render render){
        this.render = render;
    }
    
    public abstract void draw();
    
}
