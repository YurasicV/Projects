import console.TriangleReader;
import console.Writer;
import handle.TrianglesHandle;

public class TrianglesApp {
    public static void main(String[] args) {
        Writer writer = new Writer();
        TriangleReader triangleReader = new TriangleReader(writer);
        TrianglesHandle trianglesHandle = new TrianglesHandle(triangleReader, writer);
        trianglesHandle.run();
    }
}
