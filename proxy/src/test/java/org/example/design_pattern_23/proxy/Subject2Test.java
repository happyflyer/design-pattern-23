package org.example.design_pattern_23.proxy;

import org.junit.Test;

public class Subject2Test {
    @Test
    public void test() {
        Subject proxySubject = new ProxySubject();
        proxySubject.sellBook();
    }
}
