package starwars.entities.actors.actions;

import edu.monash.fit2099.simulator.matter.EntityManager;
import starwars.SWActor;
import starwars.SWEntityInterface;
import starwars.SWLocation;
import starwars.SWWorld;
import starwars.entities.actors.behaviors.AttackInformation;

import java.util.ArrayList;
import java.util.List;

public class AttackNeighbours {
    public static void
        attack_neighbours(SWActor actor,SWLocation actorLocation
            ,SWWorld world, int damage){
        SWLocation location = world.getEntityManager().whereIs(actor);
        EntityManager<SWEntityInterface, SWLocation> entityManager = world.getEntityManager();
        List<SWEntityInterface> entities = entityManager.contents(location);
        ArrayList<AttackInformation> attackAbles = new ArrayList<>();
        for (SWEntityInterface entity: entities){
            if (entity != actor && entity instanceof SWActor){
                entity.takeDamage(damage);
            }
        }
    }
}
