package ex6;

public class Ellipse extends Figure {

    public Ellipse(String name) {
        super(name);
    }

    @Override
    public void draw() {
        System.out.println("Name: " + getName() + " class: " + getClass().getSimpleName());
    }
}
