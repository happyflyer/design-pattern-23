package org.example.design_pattern_23.command.example3;

/**
 * @author lifei
 */
public class AppleCommand extends Command {
    public AppleCommand(Peddler peddler) {
        super(peddler);
    }

    @Override
    public void sell() {
        this.getPeddler().sellApple();
    }
}
