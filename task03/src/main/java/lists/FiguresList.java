package lists;

import figures.Figure;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/*
Class manages a list of Figures
 */
public class FiguresList {
    private LinkedList<Figure> list;

    public FiguresList() {
        list = new LinkedList<Figure>();
    }

    public void addFigure(Figure figure) {
        list.addLast(figure);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("======= List =======\n");
        for (Figure figure: list) {
            stringBuilder.append(figure).append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortBySquareDesc() {
        Collections.sort(list, new Comparator<Figure>() {
            public int compare(Figure f1, Figure f2) {
                return Double.compare(f2.getSquare(), f1.getSquare());
            }
        });

    }

}
