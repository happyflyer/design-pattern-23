package org.example.design_pattern_23.mediator.example2;

/**
 * @author lifei
 */
public class Man extends Person {
    public Man(String name, int condition, Mediator mediator) {
        super(name, condition, mediator);
    }

    @Override
    public void getPartner(Person person) {
        this.getMediator().setMan(this);
        this.getMediator().setWoman(null);
        this.getMediator().getPartner(person);
    }
}
