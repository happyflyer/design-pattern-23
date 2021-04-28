package org.example.design_pattern_23.command.example4;

import org.junit.Test;

public class PeddlerTest {
    @Test
    public void test() {
        Peddler peddler = new Peddler();
        Command appleCommand = new AppleCommand(peddler);
        Command bananaCommand = new BananaCommand(peddler);
        Waiter waiter = new Waiter();
        waiter.addOrder(appleCommand);
        waiter.sell();
        System.out.println("==========");
        waiter.addOrder(bananaCommand);
        waiter.sell();
        System.out.println("==========");
        waiter.removeOrder(appleCommand);
        waiter.sell();
    }
}
