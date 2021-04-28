package org.example.design_pattern_23.command.example3;

import org.junit.Test;

public class PeddlerTest {
    @Test
    public void test() {
        Peddler peddler = new Peddler();
        Command appleCommand = new AppleCommand(peddler);
        Command bananaCommand = new BananaCommand(peddler);
        Waiter waiter = new Waiter();
        waiter.setCommand(appleCommand);
        waiter.sell();
        waiter.setCommand(bananaCommand);
        waiter.sell();
    }
}
