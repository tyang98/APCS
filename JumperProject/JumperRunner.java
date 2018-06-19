import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Bug;

/**
 * Tests the Jumper class
 * @author Tony Yang
 * @version 4.6.18
 */
public class JumperRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.add(new Jumper());
        world.add(new Flower());
        world.add(new Rock());
        world.add(new Bug());
        world.show();
    }
}
