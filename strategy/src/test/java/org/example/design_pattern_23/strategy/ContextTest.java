package org.example.design_pattern_23.strategy;

import org.junit.Test;

public class ContextTest {
    @Test
    public void test() {
        Context context1 = new Context(new Md5Strategy());
        context1.encrypt();
        Context context2 = new Context(new RsaStrategy());
        context2.encrypt();
    }
}
