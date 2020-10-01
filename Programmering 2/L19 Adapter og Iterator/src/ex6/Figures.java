package ex6;

import java.util.ArrayList;
import java.util.List;

public class Figures extends Figure {

    private List<Figure> figures = new ArrayList<>();

    public Figures(String name) {
        super(name);
    }

    public void add(Figure figure) {
        figures.add(figure);
    }

    @Override
    public void draw() {
        System.out.println("Name: " + getName() + " class: " + getClass().getSimpleName() + " {");
        for (Figure figure : figures) {
            figure.draw();
        }
        System.out.println("}");
    }
}
