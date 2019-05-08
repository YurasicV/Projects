package ui;

public class ConsoleInterface implements UserInterface {
    @Override
    public void print(Object object) {
        System.out.println(object);
    }
}
