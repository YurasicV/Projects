import handler.TriangleReader;
import handler.FiguresHandler;
import ui.ConsoleInterface;

public class TrianglesApp {
    public static void main(String[] args) {
        ConsoleInterface console = new ConsoleInterface();
        TriangleReader triangleReader = new TriangleReader(console);

        FiguresHandler figuresHandler = new FiguresHandler(triangleReader, console);
        figuresHandler.run();
    }
}
