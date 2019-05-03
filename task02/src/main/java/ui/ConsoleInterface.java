package ui;

import java.util.Scanner;

public class ConsoleInterface implements UserInterface {
    private final Scanner in;

    public ConsoleInterface() {
        in = new Scanner(System.in);
    }

    @Override
    public void print(String string) {
        System.out.print(string);
    }

    @Override
    public boolean isContinued() {
        print("\nDo you want to continue? (Yes/No) : ");
        String strAnswer = in.next().toUpperCase();
        return strAnswer.equals("Y") || strAnswer.equals("YES");
    }

    @Override
    public double readPositiveDouble(String label) {
        double size = 0;
        boolean readError = true;
        print(label);
        while (readError) {
            readError = false;
            try {
                size = in.nextDouble();
            } catch (Exception e) {
                readError = true;
                print("Invalid number! Try again : ");
                in.next();
                continue;
            }
            if (size <= 0) {
                readError = true;
                print("Not a positive number! Try again : ");
            }
        }
        return size;
    }
}
