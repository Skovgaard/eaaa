package ex6;

public class Triangle extends Figure {

    public Triangle(String name) {
        super(name);
    }

    @Override
    public void draw() {
        System.out.println("Name: " + getName() + " class: " + getClass().getSimpleName());
    }
}
