package org.example.design_pattern_23.state.example2;

/**
 * @author lifei
 */
public class Person {
    private int hour;
    private State state;

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void doSomething() {
        if (hour == 7) {
            state = new State7();
        } else if (hour == 12) {
            state = new State12();
        } else if (hour == 18) {
            state = new State18();
        } else {
            state = new NoState();
        }
        state.doOneThing();
    }
}
