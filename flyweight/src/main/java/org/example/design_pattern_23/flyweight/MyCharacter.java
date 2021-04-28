package org.example.design_pattern_23.flyweight;

/**
 * @author lifei
 */
public class MyCharacter {
    private final char myChar;

    public MyCharacter(char myChar) {
        this.myChar = myChar;
    }

    public void display() {
        System.out.println(myChar);
    }
}
