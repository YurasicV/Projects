package figures;

import java.util.LinkedList;

public class FiguresList {
    private LinkedList<Figure> list;

    public FiguresList() {
        list = new LinkedList<>();
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
        list.sort((f1, f2) -> Double.compare(f2.getSquare(), f1.getSquare()));
    }
}
