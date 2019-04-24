package handler;

import figures.Triangle;
import parameters.ParameterList;
import parameters.Validator;

public class TriangleValidator extends Validator {
    private String name;
    private double sizeA;
    private double sizeB;
    private double sizeC;

    TriangleValidator(ParameterList parameterList) {
        super(parameterList);
    }

    @Override
    public void validate() {
        valid = isValidName() && isValidSizes();
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

    private boolean isValidName() {
        final int PARAM_INDEX = 0;
        message = "";
        try {
            name = getParameter(PARAM_INDEX).toString();
        } catch (Exception e) {
            message = "Invalid triangle name!";
            return false;
        }
        if (name.isEmpty()) {
            message = "Triangle name mustn't be empty!";
            return false;
        }
        return true;
    }

    private boolean isValidSizes() {
        final int PARAM_SIZEA_INDEX = 1;
        final int PARAM_SIZEB_INDEX = 2;
        final int PARAM_SIZEC_INDEX = 3;
        message = "";
        try {
            sizeA = Double.valueOf(getParameter(PARAM_SIZEA_INDEX).toString());
            sizeB = Double.valueOf(getParameter(PARAM_SIZEB_INDEX).toString());
            sizeC = Double.valueOf(getParameter(PARAM_SIZEC_INDEX).toString());
        } catch (Exception e) {
            message = "Triangle sizes are not specified!";
            return false;
        }
        if (!Triangle.isExists(sizeA, sizeB, sizeC)) {
            message = "Triangle doesn't exist!";
            return false;
        }
        return true;
    }
}
