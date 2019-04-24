package builder;

import parameters.ParameterList;
import parameters.Validator;

public class ChessBoardValidator extends Validator {
    private int rows;
    private int cols;

    ChessBoardValidator(ParameterList parameterList) {
        super(parameterList);
    }

    @Override
    public void validate() {
        valid = isValidSize();
    }

    int getRows() {
        return rows;
    }

    int getCols() {
        return cols;
    }

    private boolean isValidSize() {
        final int PARAM_ROWS_INDEX = 0;
        final int PARAM_COLS_INDEX = 1;
        message = "";
        try {
            rows = Integer.valueOf(getParameter(PARAM_ROWS_INDEX).toString());
            cols = Integer.valueOf(getParameter(PARAM_COLS_INDEX).toString());
        } catch (Exception e) {
            message = "Invalid number of rows/cols!";
            return false;
        }
        if (rows <= 0 || cols <= 0) {
            message = "Non-positive number of rows/cols";
            return false;
        }
        return true;
    }
}
