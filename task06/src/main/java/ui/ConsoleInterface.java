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
    public String readString(String label) {
        String string = "";
        boolean readError = true;
        print(label);
        while (readError) {
            readError = false;
            try {
                string = in.nextLine();
            } catch (Exception e) {
                readError = true;
                print("Invalid string! Try again : ");
                in.next();
                continue;
            }
            if (string.isEmpty()) {
                readError = true;
                print("Empty string! Try again : ");
            }
        }
        return string;
    }
}
