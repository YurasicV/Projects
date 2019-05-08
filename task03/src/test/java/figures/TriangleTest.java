package figures;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class TriangleTest {
    private String name;
    private double sizeA;
    private double sizeB;
    private double sizeC;
    private double expectedSquare;
    private boolean expectedIsExist;

    public TriangleTest(String name, double sizeA, double sizeB, double sizeC,
                        double expectedSquare, boolean expectedIsExist) {
        this.name = name;
        this.sizeA = sizeA;
        this.sizeB = sizeB;
        this.sizeC = sizeC;
        this.expectedSquare = expectedSquare;
        this.expectedIsExist = expectedIsExist;
    }

    @Parameterized.Parameters(name = "{index}: getSquare({0},{1},{2},{3})={4}")
    public static Iterable<Object[]> dataForTest() {
        return Arrays.asList(new Object[][]{
                {"Triangle 1", 3, 4, 5, 6, true},
                {"Triangle 2", 2, 2, 5, 0, false},
                {"Triangle 3", 5, 12, 13, 30, true},
                {"Triangle 4", 5, 7, 15, 0, false},
        });
    }

    @Test
    public void getSquare() {
        Triangle triangle = new Triangle(name, sizeA, sizeB, sizeC);
        assertEquals(expectedSquare, triangle.getSquare(), 0);
    }

    @Test
    public void isExists() {
        assertEquals(expectedIsExist, Triangle.isExists(sizeA, sizeB, sizeC));
    }
}