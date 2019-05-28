package app.command.doaction;

public class DoActionInvoker {
    private DoRunActionCommand doRunActionCommand;
    private DoStopActionCommand doStopActionCommand;
    private DoResultActionCommand doResultActionCommand;

    public DoActionInvoker(DoRunActionCommand doRunActionCommand,
                           DoStopActionCommand doStopActionCommand,
                           DoResultActionCommand doResultActionCommand) {
        this.doRunActionCommand = doRunActionCommand;
        this.doStopActionCommand = doStopActionCommand;
        this.doResultActionCommand = doResultActionCommand;
    }

    public void invokeRunAction() {
        doRunActionCommand.execute();
    }

    public void invokeStopAction() {
        doStopActionCommand.execute();
    }

    public void invokeResultAction() {
        doResultActionCommand.execute();
    }
}
