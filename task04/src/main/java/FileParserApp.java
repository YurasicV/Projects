import console.Writer;
import handler.FileHandler;
import parameters.ParameterList;
import parser.FileParser;

/*
Class demonstrates functionality of file parser
 */
public class FileParserApp {
    public static void main(String[] args) {
        FileParser fileParser = new FileParser(new ParameterList(args),
                new FileHandler(), new Writer());
        fileParser.run();
    }
}
