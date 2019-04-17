import console.TriangleReader;
import console.Writer;
import handle.FiguresHandle;

public class TrianglesApp {
    public static void main(String[] args) {
        Writer writer = new Writer();
        TriangleReader triangleReader = new TriangleReader(writer);
        FiguresHandle figuresHandle = new FiguresHandle(triangleReader, writer);
        figuresHandle.run();
    }
}
