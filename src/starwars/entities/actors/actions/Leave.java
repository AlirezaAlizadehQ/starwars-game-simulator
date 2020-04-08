package starwars.entities.actors.actions;

import edu.monash.fit2099.simulator.matter.EntityManager;
import edu.monash.fit2099.simulator.userInterface.MessageRenderer;
import starwars.*;

public class Leave extends SWAffordance {
    public Leave(SWEntityInterface theTarget, MessageRenderer m){
        super(theTarget, m);
        priority = 1;
    }

    /**
     * This method must always return True
     *
     * @author 24150096
     * @param a the SWActor
     * @return true
     */
    @Override
    public boolean canDo(SWActor a) {
        return a.getItemCarried()!=null && a.getItemCarried().equals(target);
    }

    /**
     * Performs the Leave action.
     *
     * it places the carried item by actor, at his location
     *
     * @author 24150096
     * @param a the SWActor
     */
    @Override
    public void act(SWActor a) {
        if (a.getItemCarried() == null){
            a.say("I am not holding anything bro, method should not be called"); // method should not be called
        }
        else{
            if(target instanceof SWEntityInterface){
                EntityManager<SWEntityInterface, SWLocation> entityManager = SWAction.getEntitymanager();
                entityManager.setLocation((SWEntityInterface)target, entityManager.whereIs(a));
                a.setItemCarried(null);
                target.removeAffordance(this);
                target.addAffordance(new Take((SWEntityInterface)target, this.messageRenderer));
            }
        }

    }

    @Override
    public String getDescription() {
        return "leave " + target.getShortDescription();// desc of dropped off item
    }
}
