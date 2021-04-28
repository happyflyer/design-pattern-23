package org.example.design_pattern_23.adapter;

import org.junit.Test;

public class Adapter2Test {
    @Test
    public void test() {
        Adapter2 adapter = new Adapter2(new Current());
        adapter.use18V();
    }
}
