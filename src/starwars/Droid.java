package starwars;

import edu.monash.fit2099.simulator.space.Direction;
import edu.monash.fit2099.simulator.userInterface.MessageRenderer;
import starwars.entities.actors.actions.Attack;

import java.util.ArrayList;

public abstract class Droid extends SWActor {
    /**
     * the class is abstract because it cannot be
     * instantiated but can be subclassed
     * @author: 24150096
     * @param team      to which this <code>SWActor</code> belongs to
     * @param hitpoints initial hitpoints of this <code>SWActor</code> to start with
     * @param m         message renderer for this <code>SWActor</code> to display messages
     * @param world     the <code>World</code> to which <code>SWActor</code> belongs to
     * @see #team
     * @see #hitpoints
     * @see #world
     * @see Attack
     */

    protected SWActor owner;
    private ArrayList<Direction> direction = new ArrayList<>();

    public Droid(Team team, int hitpoints, MessageRenderer m, SWWorld world) {
        // Droid constructor matching its super class
        super(team, hitpoints, m, world);
    }

    public SWActor getOwner(){
        return owner;
    }

    public void setOwner(SWActor owner_arg){
        owner = owner_arg;
    }

    public boolean hasOwner(){
        return owner != null;
    }



}
