package starwars.entities;

import edu.monash.fit2099.simulator.userInterface.MessageRenderer;
import starwars.SWAffordance;
import starwars.SWEntity;
import starwars.entities.actors.actions.Dip;


/**
 * Class to represent a water reservoir.  <code>Reservoirs</code> are currently pretty passive.
 * They can be dipped into to fill fillable entities (such as <code>Canteens</code>.  They
 * are assumed to have infinite capacity.
 * 
 * @author 	Eliz
 * @see 	{@link starwars.entities.Canteen}
 * @see {@link starwars.entites.Fillable}
 * @see {@link starwars.entities.actors.actions.Fill}
 */
public class Reservoir extends SWEntity {

    private int hitPoints;
    private String symbol;

	/**
	 * Constructor for the <code>Reservoir</code> class. This constructor will,
	 * <ul>
	 * 	<li>Initialize the message renderer for the <code>Reservoir</code></li>
	 * 	<li>Set the short description of this <code>Reservoir</code> to "a water reservoir</li>
	 * 	<li>Set the long description of this <code>Reservoir</code> to "a water reservoir..."</li>
	 * 	<li>Add a <code>Dip</code> affordance to this <code>Reservoir</code> so it can be taken</li> 
	 *	<li>Set the symbol of this <code>Reservoir</code> to "T"</li>
	 * </ul>
	 * 
	 * @param 	m <code>MessageRenderer</code> to display messages.
	 * @see 	{@link starwars.entities.actors.actions.Dip}
	 */
	public Reservoir(MessageRenderer m) {
		super(m);
		SWAffordance dip = new Dip(this, m);
		this.addAffordance(dip);	

		this.setLongDescription("a water reservoir.");
		this.setShortDescription("a water reservoir, " +
                "full of cool, clear, refreshing water");
		this.symbol = "W";
		this.hitpoints = 40;
	}

	@Override 
	public String getShortDescription() {
		return shortDescription;
	}
	
	public String getLongDescription() {
		return longDescription;
	}

    /**
     * Grenades are destructible, once they are thrown, they are destroyed
     * @param damage - the amount of damage that would be deducted
     */
    @Override
    public void takeDamage(int damage) {
        this.hitpoints = this.hitPoints -  damage;
        this.checkStatus();
    }

    @Override
    public int getHitpoints() {
        return hitpoints;
    }

    /**
     * to check if the hit points of the
     * reserviours has decreased or not
     *
     */
    public void checkStatus(){
        if(this.getHitpoints() < 20){
            this.setShortDescription("a damaged water reservoir");
            this.setLongDescription("a damaged " +
                    "water reservoir, leaking slowly");
            this.symbol ="V";
        }
        if(this.getHitpoints() <= 0){
            this.symbol = "X";
            this.setShortDescription("the wreck-age " +
                    "of a water reservoir");
            this.setLongDescription("the wreckage of a water " +
                    "reservoir, surrounded by slightly damp soil");
        }
    }

    /**
     * A symbol that is used to represent the Grenade on a text based user interface
     *
     * @return 	A String containing a single character.
     * @see 	{@link starwars.SWEntityInterface#getSymbol()}
     */
    @Override
    public String getSymbol() {
        return this.symbol;
    }


}
