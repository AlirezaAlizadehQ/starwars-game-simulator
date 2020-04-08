package starwars.entities.actors.actions;

import edu.monash.fit2099.simulator.userInterface.MessageRenderer;
import starwars.SWActionInterface;
import starwars.SWActor;
import starwars.SWAffordance;
import starwars.SWEntityInterface;

public class Training extends SWAffordance implements SWActionInterface {
    /**
     * @author: 24150096
     * Constructor for the <code>SWAffordance</code>.
     * This would initialize the <code>MessageRenderer</code> and the target for this <code>SWAffordance</code>.
     *
     * @param theTarget a sub class of <code>SWEntityInterface</code> on which the action needs to be performed on
     * @param m         the <code>messageRenderer</code> to display messages for this <code>SWAffordance</code>.
     */
    public Training(SWEntityInterface theTarget, MessageRenderer m) {
        super(theTarget, m);
    }

    @Override
    public String getDescription() {
        return target.getShortDescription() +
                "ready for training";
    }

    @Override
    public boolean canDo(SWActor a) {
        return a.getForce() == SWActor.Force.NOTTRAINED;
    }

    @Override
    public void act(SWActor a) {
        a.setForce(SWActor.Force.TRAINED);
    }
}
