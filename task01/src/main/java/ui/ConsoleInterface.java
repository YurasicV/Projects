package ui;

public class ConsoleInterface implements UserInterface {
    @Override
    public void print(String string) {
        System.out.print(string);
    }
}
