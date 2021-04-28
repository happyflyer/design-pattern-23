package org.example.design_pattern_23.command.example3;

/**
 * @author lifei
 */
public abstract class Command {
    private Peddler peddler;

    public Command(Peddler peddler) {
        this.peddler = peddler;
    }

    public Peddler getPeddler() {
        return peddler;
    }

    public void setPeddler(Peddler peddler) {
        this.peddler = peddler;
    }

    /**
     * sell
     */
    public abstract void sell();
}
