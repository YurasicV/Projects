package nested;

import static java.lang.Math.*;

public class Envelope implements Nested {
    private int number;
    private double sizeA;
    private double sizeB;

    public Envelope(int number, double sizeA, double sizeB) {
        this.number = number;
        this.sizeA = sizeA;
        this.sizeB = sizeB;
    }

    public double getSizeA() {
        return this.sizeA;
    }

    public double getSizeB() {
        return this.sizeB;
    }

    @Override
    public String toString() {
        return "Envelope " + this.number;
    }

    @Override
    public boolean isNestedTo(Nested nested) {
        if (nested instanceof Envelope) {
            double sizeA = ((Envelope) nested).getSizeA();
            double sizeB = ((Envelope) nested).getSizeB();
            return isNestedInSize(sizeA, sizeB) || isNestedInRotation(sizeA, sizeB);
        } else {
            return false;
        }
    }

    private boolean isNestedInSize(double sizeA, double sizeB) {
        return ((this.sizeA < sizeA) && (this.sizeB < sizeB)) ||
                ((this.sizeB < sizeA) && (this.sizeA < sizeB));
    }

    private boolean isNestedInRotation(double sizeA, double sizeB) {
        double alpha;
        double denominator =  this.sizeA * this.sizeA + this.sizeB * this.sizeB;
        if (denominator == 0) {
            return false;
        }
        alpha = asin((sizeA * this.sizeB -
                this.sizeA * sqrt(denominator - sizeA * sizeA))
                / denominator);
        return  sizeB >= this.sizeA * sin(alpha) + this.sizeB * cos(alpha);
    }
}
