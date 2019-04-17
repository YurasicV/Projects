package console;

import figures.Figure;
import figures.Triangle;
import parameters.ParameterList;

public class TriangleReader extends FigureReader {
    public TriangleReader(Writer writer) {
        super(writer);
    }

    public Figure read() {
        ParameterList parameterList;
        boolean readError;
        String name = "";
        double sizeA = 0;
        double sizeB = 0;
        double sizeC = 0;
        do {
            readError = false;
            writer.print("\nEnter a triangle in the format <name,a,b,c>: ");
            parameterList = new ParameterList(in.nextLine(), ",");
            try {
                name = parameterList.getNextParameter().toString();
                sizeA = parameterList.getNextParameter().toDouble();
                sizeB = parameterList.getNextParameter().toDouble();
                sizeC = parameterList.getNextParameter().toDouble();
            } catch (Exception e) {
                readError = true;
                writer.print("Data doesn't match the format! Try again...");
                continue;
            }
            if (!Triangle.isExists(sizeA, sizeB, sizeC)) {
                readError = true;
                writer.print("Triangle doesn't exist! Try again...");
            }
        } while (readError);
        return new Triangle(name, sizeA, sizeB, sizeC);
    }
}
