package console;

import figures.Triangle;
import parameters.ParameterList;

import java.util.Scanner;

/*
Class allows to read required data from console
to create Triangle
 */
public class TriangleReader {
    private Scanner in;
    private Writer writer;

    public TriangleReader(Writer writer) {
        this.writer = writer;
        in = new Scanner(System.in);
    }

    public Triangle readTriangle() {
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

    public boolean isOneMoreTriangle() {
        writer.print("\nDo you want to add one more triangle? (Yes/No) : ");
        String strAnswer = in.nextLine().toUpperCase();
        return strAnswer.equals("Y") || strAnswer.equals("YES");
    }
}
