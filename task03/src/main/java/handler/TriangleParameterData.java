package handler;

import figures.Triangle;
import parameters.ParameterConversionException;
import parameters.ParameterData;
import parameters.ParameterList;

public class TriangleParameterData extends ParameterData {
    private String name;
    private double sizeA;
    private double sizeB;
    private double sizeC;

    TriangleParameterData(ParameterList parameterList) {
        super(parameterList);
    }

    @Override
    protected void convert() throws ParameterConversionException {
        convertName();
        convertSizes();
    }

    String getName() {
        return name;
    }

    double getSizeA() {
        return sizeA;
    }

    double getSizeB() {
        return sizeB;
    }

    double getSizeC() {
        return sizeC;
    }

    private void convertName() throws ParameterConversionException {
        final int PARAM_INDEX = 0;
        try {
            name = getParameter(PARAM_INDEX).toString();
        } catch (Exception e) {
            throw new ParameterConversionException("Invalid triangle name!");
        }
        if (name.isEmpty()) {
            throw new ParameterConversionException("Triangle name mustn't be empty!");
        }
    }

    private void convertSizes() throws ParameterConversionException {
        final int PARAM_SIZEA_INDEX = 1;
        final int PARAM_SIZEB_INDEX = 2;
        final int PARAM_SIZEC_INDEX = 3;
        try {
            sizeA = Double.valueOf(getParameter(PARAM_SIZEA_INDEX).toString());
            sizeB = Double.valueOf(getParameter(PARAM_SIZEB_INDEX).toString());
            sizeC = Double.valueOf(getParameter(PARAM_SIZEC_INDEX).toString());
        } catch (Exception e) {
            throw new ParameterConversionException("Triangle sizes are not specified!");
        }
        if (!Triangle.isExists(sizeA, sizeB, sizeC)) {
            throw new ParameterConversionException("Triangle doesn't exist!");
        }
    }
}
