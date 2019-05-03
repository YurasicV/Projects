package handler;

import parameters.ParameterConversionException;
import parameters.ParameterData;
import parameters.ParameterList;

public class FileHandlerParameterData extends ParameterData {
    private String fileName;
    private String search;
    private String replace;

    FileHandlerParameterData(ParameterList parameterList) {
        super(parameterList);
    }

    @Override
    protected void convert() throws ParameterConversionException {
        converFileName();
        convertSearch();
        convertReplace();
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

    private void converFileName() throws ParameterConversionException {
        final int PARAM_INDEX = 0;
        try {
            fileName = getParameter(PARAM_INDEX).toString();
        } catch (Exception e) {
            throw new ParameterConversionException("Invalid file name!");
        }
        if (fileName.isEmpty()) {
            throw new ParameterConversionException("No file specified");
        }
    }

    private void convertSearch() throws ParameterConversionException {
        final int PARAM_INDEX = 1;
        try {
            search = getParameter(PARAM_INDEX).toString();
        } catch (Exception e) {
            throw new ParameterConversionException("Invalid search string!");
        }
        if (search.isEmpty()) {
            throw new ParameterConversionException("No search string specified");
        }
    }

    private void convertReplace() {
        final int PARAM_INDEX = 2;
        try {
            replace = getParameter(PARAM_INDEX).toString();
        } catch (Exception e) {
            replace = "";
        }
    }
}
