package ui;

import java.util.Scanner;

public class ConsoleInterface implements UserInterface {
    private Scanner in;

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
        String strAnswer = in.nextLine().toUpperCase();
        return strAnswer.equals("Y") || strAnswer.equals("YES");
    }

    @Override
    public String readLine(String label) {
        print(label);
        return in.nextLine();
    }
}
