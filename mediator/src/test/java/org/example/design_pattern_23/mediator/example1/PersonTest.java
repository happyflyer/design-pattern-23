package org.example.design_pattern_23.mediator.example1;

import org.junit.Test;

public class PersonTest {
    @Test
    public void test() {
        Person zhangsan = new Man("张三", 5);
        Person lisi = new Man("李四", 6);
        Person xiaofang = new Woman("小芳", 6);
        zhangsan.getPartner(xiaofang);
        lisi.getPartner(xiaofang);
        zhangsan.getPartner(lisi);
    }
}
