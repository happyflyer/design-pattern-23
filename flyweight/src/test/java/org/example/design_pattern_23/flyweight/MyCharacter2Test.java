package org.example.design_pattern_23.flyweight;

import org.junit.Test;

public class MyCharacter2Test {
    @Test
    public void test() {
        MyCharacterFactory factory = new MyCharacterFactory();
        MyCharacter myChar1 = factory.getMyCharacter('a');
        MyCharacter myChar2 = factory.getMyCharacter('b');
        MyCharacter myChar3 = factory.getMyCharacter('a');
        MyCharacter myChar4 = factory.getMyCharacter('d');
        myChar1.display();
        myChar2.display();
        myChar3.display();
        myChar4.display();
        System.out.println(myChar1 == myChar3);
    }
}
