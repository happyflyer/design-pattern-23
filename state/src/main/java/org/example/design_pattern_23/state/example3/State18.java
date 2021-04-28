package org.example.design_pattern_23.state.example3;

/**
 * @author lifei
 */
public class State18 extends State {
    @Override
    public void doOneThing(Person person) {
        if (person.getHour() == 18) {
            System.out.println("吃晚饭");
        } else {
            person.setState(new NoState());
            person.doSomething();
        }
    }
}
