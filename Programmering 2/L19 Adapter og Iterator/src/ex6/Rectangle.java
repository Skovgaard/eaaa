package ex6;

public class Rectangle extends Figure {

    public Rectangle(String name) {
        super(name);
    }

    @Override
    public void draw() {
        System.out.println("Name: " + getName() + " class: " + getClass().getSimpleName());
    }
}
