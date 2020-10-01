package ex6;

import java.util.ArrayList;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        Triangle triangle = new Triangle("Triangle");
        Rectangle rectangle = new Rectangle("Rectangle");
        Ellipse ellipse = new Ellipse("Ellipse");

        Figures figures = new Figures("House");
        figures.add(triangle);
        figures.add(rectangle);

        List<Figure> figureList = new ArrayList<>();
        figureList.add(triangle);
        figureList.add(rectangle);
        figureList.add(ellipse);

        figureList.add(figures);

        for (Figure figure : figureList) {
            figure.draw();
        }


    }

}
