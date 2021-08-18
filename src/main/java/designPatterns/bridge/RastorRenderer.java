package designPatterns.bridge;

public class RastorRenderer implements Render {
    @Override
    public void renderCircle(float radius) {
        System.out.println("Rastor Renderer: "+radius);
    }
}
