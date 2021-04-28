package org.example.design_pattern_23.facade.example2;

import org.junit.Test;

public class JiJinTest {
    @Test
    public void test() {
        JiJin jiJin = new JiJin();
        jiJin.maiJiJinA();
        System.out.println("==========");
        jiJin.maiJiJinB();
    }
}
