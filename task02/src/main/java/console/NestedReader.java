package console;

import nested.Nested;

import java.util.Scanner;

public abstract class NestedReader {
    private Scanner in;
    Writer writer;

    NestedReader(Writer writer) {
        this.writer = writer;
        in = new Scanner(System.in);
    }

    public boolean isOneMore() {
        writer.print("\nDo you want to continue? (Yes/No) : ");
        String strAnswer = in.next().toUpperCase();
        return strAnswer.equals("Y") || strAnswer.equals("YES");
    }

    double readSize(String label) {
        double size = 0;
        boolean readError = true;
        writer.print(label);
        while (readError) {
            readError = false;
            try {
                size = in.nextDouble();
            } catch (Exception e) {
                readError = true;
                writer.print("Invalid number! Try again : ");
                in.next();
                continue;
            }
            if (size <= 0) {
                readError = true;
                writer.print("Not a positive number! Try again : ");
            }
        }
        return size;
    }

    public abstract Nested read(int index);
}
