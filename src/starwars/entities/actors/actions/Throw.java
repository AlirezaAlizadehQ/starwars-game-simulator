package starwars.entities.actors.actions;

import edu.monash.fit2099.simulator.matter.EntityManager;
import edu.monash.fit2099.simulator.userInterface.MessageRenderer;
import starwars.*;

import static starwars.entities.actors.actions.AttackNeighbours.attack_neighbours;

public class Throw extends SWAffordance {
    SWWorld world;
    // private int x = 0;
    // private int y = 0;
    SWLocation current_location;
    //List<List<Integer>> neighbour_location;
    //SWLocation neighbour_location ;
    /**
     * Constructor for the <code>SWAffordance</code>.
     * This would initialize the <code>MessageRenderer</code> and the target for this <code>SWAffordance</code>.
     *
     * @param theTarget a sub class of <code>SWEntityInterface</code> on which the action needs to be performed on
     * @param m         the <code>messageRenderer</code> to display messages for this <code>SWAffordance</code>.
     */
    public Throw(SWEntityInterface theTarget, MessageRenderer m) {
        super(theTarget, m);
        priority = 1;
    }

    @Override
    public boolean canDo(SWActor a) {
        return  a.getItemCarried() != null && a.getItemCarried().equals(target)
                && a.getItemCarried().getSymbol().equals("G");
    }

    @Override
    public void act(SWActor a) {
        if (a.getItemCarried() == null){
            a.say("I am not holding anything bro"); // method should not be called
        }
        else{
            if(target instanceof SWEntityInterface){
                EntityManager<SWEntityInterface, SWLocation> entityManager = SWAction.getEntitymanager();
                entityManager.setLocation((SWEntityInterface)target, entityManager.whereIs(a));
                a.setItemCarried(null);
                target.removeAffordance(this);
                ((SWEntityInterface) target).takeDamage(0); // the grenade's health equal to 0, means it is destroyed
                current_location = entityManager.whereIs(a);

                //neighbour_location = (List<List<Integer>>) current_location;
                attack_neighbours(a, current_location, world, 20); // take 20 damage for each entity in the location where grenade is thrown
            }
        }
    }

    @Override
    public String getDescription() {
        return "Throw" + " " +
                target.getShortDescription(); // desc of thrown item
    }
}
