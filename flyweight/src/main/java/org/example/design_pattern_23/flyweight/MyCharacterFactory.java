package org.example.design_pattern_23.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lifei
 */
public class MyCharacterFactory {
    private final Map<Character, MyCharacter> pool;

    public MyCharacterFactory() {
        this.pool = new HashMap<>();
    }

    public MyCharacter getMyCharacter(Character character) {
        MyCharacter myChar = this.pool.get(character);
        if (myChar == null) {
            myChar = new MyCharacter(character);
            this.pool.put(character, myChar);
        }
        return myChar;
    }
}
