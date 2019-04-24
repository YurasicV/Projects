package handler;

import figures.Figure;
import figures.Triangle;
import ui.UserInterface;
import parameters.ParameterList;

public class TriangleReader implements FigureReader {
    private UserInterface ui;

    public TriangleReader(UserInterface ui) {
        this.ui = ui;
    }

    @Override
    public Figure read() {
        ParameterList parameterList;
        boolean readError;
        String name = "";
        double sizeA = 0;
        double sizeB = 0;
        double sizeC = 0;
        do {
            readError = false;
            parameterList = new ParameterList(
                    ui.readLine("\nEnter a triangle in the format <name,a,b,c>: "),
                    ",");
            TriangleValidator validator = new TriangleValidator(parameterList);
            validator.validate();
            if (validator.isValid()) {
                name = validator.getName();
                sizeA = validator.getSizeA();
                sizeB = validator.getSizeB();
                sizeC = validator.getSizeC();
            } else {
                readError = true;
                ui.print(validator.getMessage() + " Try again...");
            }
        } while (readError);
        return new Triangle(name, sizeA, sizeB, sizeC);
    }
}
