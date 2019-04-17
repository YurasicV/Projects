package handle;

import console.FigureReader;
import console.Writer;
import figures.FiguresList;

public class FiguresHandle {
    private FigureReader figureReader;
    private Writer writer;

    public FiguresHandle(FigureReader figureReader, Writer writer) {
        this.figureReader = figureReader;
        this.writer = writer;
    }

    public void run() {
        FiguresList figuresList = new FiguresList();
        do {
            figuresList.addFigure(figureReader.read());
        } while (figureReader.isOneMore());
        figuresList.sortBySquareDesc();
        writer.print(figuresList);
    }
}
