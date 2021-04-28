package org.example.design_pattern_23.command.example4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lifei
 */
public class Waiter {
    private final List<Command> commands;

    public Waiter() {
        commands = new ArrayList<>();
    }

    public void addOrder(Command command) {
        this.commands.add(command);
    }

    public void removeOrder(Command command) {
        this.commands.remove(command);
    }

    public void sell() {
        for (Command command : commands) {
            command.sell();
        }
    }
}
