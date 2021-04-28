package org.example.design_pattern_23.state.example3;

/**
 * @author lifei
 */
public class Person {
    private int hour;
    private State state;

    public Person() {
        this.state = new State7();
    }

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
        this.state.doOneThing(this);
        this.state = new State7();
    }
}
