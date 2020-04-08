package starwars.entities;

import edu.monash.fit2099.simulator.userInterface.MessageRenderer;
import starwars.Capability;
import starwars.SWEntity;
import starwars.entities.actors.actions.Take;

public class Grenade extends SWEntity {
    private int hitPoints = 20;

    public Grenade(MessageRenderer m) {
        super(m);
        this.shortDescription = "a grenade";
        this.longDescription = "a grenade. be careful!";
        this.hitpoints = hitPoints;
        this.addAffordance(new Take(this, m));//add the take affordance so that the Grenade can be taken by SWActors
        this.capabilities.add(Capability.WEAPON);// it's a weapon.
    }

    /**
     * Grenades are destructible, once they are thrown, they are destroyed
     * @param damage - the amount of damage that would be deducted
     */
    @Override
    public void takeDamage(int damage) {
        this.hitpoints = damage;
    }


    /**
     * A symbol that is used to represent the Grenade on a text based user interface
     *
     * @return 	A String containing a single character.
     * @see 	{@link starwars.SWEntityInterface#getSymbol()}
     */
    @Override
    public String getSymbol() {
        return "G";
    }


}
