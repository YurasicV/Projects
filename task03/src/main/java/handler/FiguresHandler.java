package handler;

import figures.FiguresList;
import ui.UserInterface;

public class FiguresHandler {
    private FigureReader figureReader;
    private UserInterface ui;

    public FiguresHandler(FigureReader figureReader, UserInterface ui) {
        this.figureReader = figureReader;
        this.ui = ui;
    }

    public void run() {
        FiguresList figuresList = new FiguresList();
        do {
            figuresList.addFigure(figureReader.read());
        } while (ui.isContinued());
        figuresList.sortBySquareDesc();
        ui.print(figuresList.toString());
    }
}
