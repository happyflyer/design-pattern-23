package org.example.design_pattern_23.command.example3;

/**
 * @author lifei
 */
public class Waiter {
    private Command command;

    public Waiter() {
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void sell() {
        this.command.sell();
    }
}
