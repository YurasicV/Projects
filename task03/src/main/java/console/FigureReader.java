package console;

import figures.Figure;
import java.util.Scanner;

public abstract class FigureReader {
    Scanner in;
    Writer writer;

    public FigureReader(Writer writer) {
        this.writer = writer;
        in = new Scanner(System.in);
    }

    public boolean isOneMore() {
        writer.print("\nDo you want to add one more? (Yes/No) : ");
        String strAnswer = in.nextLine().toUpperCase();
        return strAnswer.equals("Y") || strAnswer.equals("YES");
    }

    public abstract Figure read();
}
