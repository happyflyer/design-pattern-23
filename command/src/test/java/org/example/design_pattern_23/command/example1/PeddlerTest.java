package org.example.design_pattern_23.command.example1;

import org.junit.Test;

public class PeddlerTest {
    @Test
    public void test() {
        Peddler peddler = new Peddler();
        peddler.sellApple();
        peddler.sellBanana();
    }
}
