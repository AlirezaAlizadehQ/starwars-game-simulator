package starwars.entities.actors.actions;

import edu.monash.fit2099.simulator.userInterface.MessageRenderer;
import starwars.SWActor;
import starwars.SWAffordance;
import starwars.SWDroid;

public class Ownership extends SWAffordance {
    /**
     * constructr for Ownership class
     * which has 2 params, actor type pf SWActo, and
     * m type of MessageRenderer
    @author: 24150096
     */
    public Ownership(SWActor a, MessageRenderer m){
        super(a, m);
    }


    @Override
    public boolean canDo(SWActor a) {
        return ((SWDroid) target).hasOwner()
                && ((SWDroid) target).getHitpoints()>0;
    }

    @Override
    public void act(SWActor a) {
        ((SWDroid)target).setOwner(a);
        a.say(a.getShortDescription() +
                "owns" + " " + target.getShortDescription() );
    }

    @Override
    public String getDescription() {
        return "own" + " " + target.getShortDescription();
    }
}
