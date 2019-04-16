package handle;

import console.TriangleReader;
import console.Writer;
import lists.FiguresList;

public class TrianglesHandle {
    private TriangleReader triangleReader;
    private Writer writer;

    public TrianglesHandle(TriangleReader triangleReader, Writer writer) {
        this.triangleReader = triangleReader;
        this.writer = writer;
    }

    public void run() {
        FiguresList figuresList = new FiguresList();
        do {
            figuresList.addFigure(triangleReader.readTriangle());
        } while (triangleReader.isOneMoreTriangle());
        figuresList.sortBySquareDesc();
        writer.print(figuresList);
    }
}
