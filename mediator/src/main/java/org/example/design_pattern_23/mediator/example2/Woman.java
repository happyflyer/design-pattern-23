package org.example.design_pattern_23.mediator.example2;

/**
 * @author lifei
 */
public class Woman extends Person {
    public Woman(String name, int condition, Mediator mediator) {
        super(name, condition, mediator);
    }

    @Override
    public void getPartner(Person person) {
        this.getMediator().setWoman(this);
        this.getMediator().setMan(null);
        this.getMediator().getPartner(person);
    }
}
