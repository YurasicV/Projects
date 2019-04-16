package figures;

/*
Abstract figure
 */
public abstract class Figure {
    private String name;

    Figure(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[" + name + "]: " + getSquare() + " cm2" ;
    }

    public abstract double getSquare();
}
