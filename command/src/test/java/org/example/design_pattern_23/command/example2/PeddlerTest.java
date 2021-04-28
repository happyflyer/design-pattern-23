package org.example.design_pattern_23.command.example2;

import org.junit.Test;

public class PeddlerTest {
    @Test
    public void test() {
        Peddler peddler = new Peddler();
        Command appleCommand = new AppleCommand(peddler);
        Command bananaCommand = new BananaCommand(peddler);
        appleCommand.sell();
        bananaCommand.sell();
    }
}
