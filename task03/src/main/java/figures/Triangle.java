package figures;

import static java.lang.Math.sqrt;

/*
Class of Triangle
 */
public class Triangle extends Figure {
    private double sizeA;
    private double sizeB;
    private double sizeC;

    public Triangle(String name, double sizeA, double sizeB, double sizeC) {
        super(name);
        this.sizeA = sizeA;
        this.sizeB = sizeB;
        this.sizeC = sizeC;
    }

    @Override
    public double getSquare() {
        double valueP = (sizeA + sizeB + sizeC) / 2;
        double valueMultiply = valueP * (valueP - sizeA) *
                (valueP - sizeB) * (valueP - sizeC);
        return (valueMultiply > 0) ? sqrt(valueMultiply) : 0;
    }

    public static boolean isExists(double sizeA, double sizeB, double sizeC) {
        return ((sizeA + sizeB) > sizeC) &&
                ((sizeA + sizeC) > sizeB) &&
                ((sizeB + sizeC) > sizeA);
    }
}
