package builder;

import parameters.ParameterConversionException;
import parameters.ParameterList;
import parameters.ParameterData;

public class ChessBoardParameterData extends ParameterData {
    private int rows;
    private int cols;

    ChessBoardParameterData(ParameterList parameterList) {
        super(parameterList);
    }

    @Override
    protected void convert() throws ParameterConversionException {
        convertSize();
    }

    int getRows() {
        return rows;
    }

    int getCols() {
        return cols;
    }

    private void convertSize() throws ParameterConversionException {
        final int PARAM_ROWS_INDEX = 0;
        final int PARAM_COLS_INDEX = 1;
        try {
            rows = Integer.valueOf(getParameter(PARAM_ROWS_INDEX).toString());
            cols = Integer.valueOf(getParameter(PARAM_COLS_INDEX).toString());
        } catch (Exception e) {
            throw new ParameterConversionException("Invalid number of rows/cols!");
        }
        if (rows <= 0 || cols <= 0) {
            throw new ParameterConversionException("Non-positive number of rows/cols");
        }
    }
}
