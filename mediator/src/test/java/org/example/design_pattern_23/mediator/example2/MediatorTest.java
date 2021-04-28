package org.example.design_pattern_23.mediator.example2;

import org.junit.Test;

public class MediatorTest {
    @Test
    public void test() {
        Mediator mediator = new Mediator();
        Person zhangsan = new Man("张三", 5, mediator);
        Person lisi = new Man("李四", 6, mediator);
        Person xiaofang = new Woman("小芳", 6, mediator);
        zhangsan.getPartner(xiaofang);
        lisi.getPartner(xiaofang);
        zhangsan.getPartner(lisi);
    }
}
