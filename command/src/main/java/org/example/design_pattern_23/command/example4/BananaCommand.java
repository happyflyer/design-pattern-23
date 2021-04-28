package org.example.design_pattern_23.command.example4;

/**
 * @author lifei
 */
public class BananaCommand extends Command {
    public BananaCommand(Peddler peddler) {
        super(peddler);
    }

    @Override
    public void sell() {
        this.getPeddler().sellBanana();
    }
}
