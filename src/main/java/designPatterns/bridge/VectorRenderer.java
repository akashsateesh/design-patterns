package designPatterns.bridge;

public class VectorRenderer implements Render {
    @Override
    public void renderCircle(float radius) {
        System.out.println("Circle render "+ " : "+radius);
    }
}
