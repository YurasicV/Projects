package parameters;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParameterListTest {
    private ParameterList parameterList;

    @Before
    public void setUp() {
        parameterList = new ParameterList(new String[] {"p1", "p2", "p3"});
    }

    @After
    public void tearDown() {
        parameterList = null;
    }

    @Test
    public void countSomeParameters() {
        assertEquals(3, parameterList.count());
    }

    @Test
    public void countNoneParameters() {
        assertEquals(0, new ParameterList(new String[] {}).count());
    }

    @Test
    public void getExistingElement() {
        assertEquals(new Parameter("p2").toString(),parameterList.get(1).toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getNonExistingElement() {
        parameterList.get(5);
    }
}