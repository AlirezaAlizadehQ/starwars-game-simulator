package starwars.entities.actors.actions;

import edu.monash.fit2099.simulator.matter.Affordance;
import edu.monash.fit2099.simulator.space.Direction;
import edu.monash.fit2099.simulator.space.Location;
import edu.monash.fit2099.simulator.userInterface.MessageRenderer;
import starwars.*;

public class Sandcrawler extends SWAction implements SWEntityInterface {
    /**Direction in which this <code>Sandcrawler</code> action must be performed*/
    Direction whichDirection;

    /**The world in which this <code>Sandcrawler</code> action should occur*/
    SWWorld world;

    /**
     * Constructor for the <code>SWAction</code>.
     * Will initialize the message renderer for this <code>SWAction</code>
     *
     *@param d the <code>Direction</code> in which the Entity is supposed to Sandcrawler
     *@param m <code>MessageRenderer</code> to display messages
     *@param world the world in which the <code>Sandcrawler</code> action needs to happen
     */
    public Sandcrawler(Direction d, MessageRenderer m, SWWorld world) {
        super(m);
        this.whichDirection = d;
        this.world = world;
    }

    public Sandcrawler(Direction[] direction, MessageRenderer iface, SWWorld world) {
        super(iface);
    }

    /**
     * This is a wrapper for getDescription().
     *
     * @author Eliz
     * @return a String describing this <code>Sandcrawler</code>, suitable for display to the user
     */
    @Override
    public String toString() {
        return getDescription();
    }

    /**
     * Returns true, as its a Sandcrawler command family.
     *
     * TODO: This might be replaced with a Capability.
     *
     * @author Eliz
     * @return true
     */
    public boolean isSandcrawlerCommand() {
        return true;
    }

    @Override
    public boolean canDo(SWActor a) {
        return (world.canMove(a, whichDirection)
                && a.getSymbol().equals("B") && !a.isDead()) ;

    }

    @Override
    public void act(SWActor a) {
        if(a.getSymbol().equals("B") && !a.isDead()){
            if (world.canMove(a, whichDirection)){
                world.canMove(a , whichDirection);
            }
        }
    }

    /**
     *Returns the time taken to perform this <code>Sandcrawler</code> action.
     *
     *@return the duration of the <code>Sandcrawler</code> action. Currently hard coded to return 1
     */
    @Override
    public int getDuration() {
        return 1;
    }

    public Direction getWhichDirection(){
        return  whichDirection;
    }

    /**
     * Returns a String describing this <code>Sandcrawler</code>, suitable for display to the user.
     *
     * @author Eliz
     * @return String comprising "Sandcrawler " and the direction.
     */
    @Override
    public String getDescription() {
        return "crawl " + whichDirection.toString();
    }

    @Override
    public String getSymbol() {
        return null;
    }

    @Override
    public void setSymbol(String string) {

    }

    @Override
    public boolean hasCapability(Capability c) {
        return false;
    }

    @Override
    public int getHitpoints() {
        return 0;
    }

    @Override
    public void takeDamage(int damage) {

    }

    @Override
    public String getShortDescription() {
        return null;
    }

    @Override
    public String getLongDescription() {
        return null;
    }

    @Override
    public void setShortDescription(String shortDescription) {

    }

    @Override
    public void setLongDescription(String longDescription) {

    }

    @Override
    public <L extends Location> void tick(L loc) {

    }

    @Override
    public void say(String message) {

    }

    @Override
    public void addAffordance(Affordance a) {

    }

    @Override
    public void removeAffordance(Affordance a) {

    }

    @Override
    public Affordance[] getAffordances() {
        return new Affordance[0];
    }
}
