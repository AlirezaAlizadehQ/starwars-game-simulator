package starwars;

import edu.monash.fit2099.simulator.space.Direction;
import edu.monash.fit2099.simulator.space.Location;
import edu.monash.fit2099.simulator.userInterface.MessageRenderer;
import starwars.entities.actors.actions.Attack;

import java.util.ArrayList;

public  class SWDroid extends SWActor {

    private String name;

    private SWActor owner;

    private String symbol;

    private int hitPoints;
    /**
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

    private ArrayList<Direction> direction = new ArrayList<>();

    public SWDroid(Team team, String name,
                   int hitpoints, MessageRenderer m, SWWorld world) {
        // SWDroid constructor matching its super class
        super(team, hitpoints, m, world);
        this.name = name;
        this.owner = null;
        this.hitPoints = hitpoints;

    }

    public SWActor getOwner(){
        return this.owner;
    }

    public void setOwner(SWActor actor){
        if (this.hasOwner()){
            this.owner = actor;
        }
    }

    public boolean hasOwner(){
        return this.owner != null;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }


    @Override
    public void setSymbol(String s) {
        symbol = s;
    }

    /**
     * Retrieves the <code>owner</code>'s position in the grid
     *
     * @return A <code>Location</code> of  the <code>owner</code>'s position in the grid
     */
    public final Location ownerPosition ()
    {
        Location ownerCurrentPosition = null;
        if (this.owner != null)
        {
            ownerCurrentPosition = world.find(this.owner);
        }
        return ownerCurrentPosition;
    }

    public final boolean isImmobile() {
        return this.getHitpoints() < 0;
    }

    /**
     * Decreases the <code>SWActor</code>'s hp when their in badlands
     * return: None
     */
    public final void badLandsEffect()
    {
        if (this.world.getEntityManager().whereIs(this).getSymbol() == 'b'){
            messageRenderer.render(this.getShortDescription() + " Bro, I cant " +
                    "take it anymore.");
            this.takeDamage(5);
            this.isImmobile();
        }
    }

    /**
     * Describes the <code>isImmobile</code>'s position in the grid and it's <code>hitpoints</code>
     * @return A string of the <code>isImmobile</code>'s position in the grid and it's <code>hitpoints</code>
     */
    protected String describeLocation() {
        return this.getShortDescription() + " [" +
                this.getHitpoints() + "] is at " +
                this.world.getEntityManager().whereIs(this).getShortDescription();
    }

    /**
     * Describes the <code>Droid</code>'s <code>name</code>
     * @return A string of the <code>Drid</code>'s <code>name</code>
     */
    @Override
    public String getShortDescription() {
        return "Droid: " + name;
    }

    /**
     * Describes the <code>Droid</code>'s <code>name</code>
     * @return A string of the <code>Droid</code>'s <code>name</code>
     */
    @Override
    public String getLongDescription() {
        return getShortDescription();
    }

    @Override
    public void act() {
        if (this.isImmobile()){
            return;
        }
        say(describeLocation());
    }
}
