package handler;

import parameters.ParameterList;
import parameters.Validator;

public class FileHandlerValidator extends Validator {
    private String fileName;
    private String search;
    private String replace;

    FileHandlerValidator(ParameterList parameterList) {
        super(parameterList);
    }

    @Override
    public void validate() {
        valid = isValidFileName() && isValidSearch() && isValidReplace();
    }

    String getFileName() {
        return fileName;
    }

    String getSearch() {
        return search;
    }

    String getReplace() {
        return replace;
    }

    private boolean isValidFileName() {
        final int PARAM_INDEX = 0;
        message = "";
        try {
            fileName = getParameter(PARAM_INDEX).toString();
        } catch (Exception e) {
            message = "Invalid file name!";
            return false;
        }
        if (fileName.isEmpty()) {
            message = "No file specified";
            return false;
        }
        return true;
    }

    private boolean isValidSearch() {
        final int PARAM_INDEX = 1;
        message = "";
        try {
            search = getParameter(PARAM_INDEX).toString();
        } catch (Exception e) {
            message = "Invalid search string!";
            return false;
        }
        if (search.isEmpty()) {
            message = "No search string specified";
            return false;
        }
        return true;
    }

    private boolean isValidReplace() {
        final int PARAM_INDEX = 2;
        message = "";
        try {
            replace = getParameter(PARAM_INDEX).toString();
        } catch (Exception e) {
            replace = "";
        }
        return true;
    }
}
