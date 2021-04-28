package org.example.design_pattern_23.flyweight;

import org.junit.Test;

public class MyCharacter1Test {
    @Test
    public void test() {
        MyCharacter myChar1 = new MyCharacter('a');
        MyCharacter myChar2 = new MyCharacter('b');
        MyCharacter myChar3 = new MyCharacter('a');
        MyCharacter myChar4 = new MyCharacter('d');
        myChar1.display();
        myChar2.display();
        myChar3.display();
        myChar4.display();
        System.out.println(myChar1 == myChar3);
    }
}
