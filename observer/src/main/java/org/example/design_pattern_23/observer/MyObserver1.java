package org.example.design_pattern_23.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author lifei
 */
public class MyObserver1 implements Observer {
    private final String name;

    public MyObserver1(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(this.name + "：对象发生变化");
    }
}
