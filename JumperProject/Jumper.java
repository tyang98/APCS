import info.gridworld.actor.Rock;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;

/**
 * Simulates a Jumper
 * @author Tony Yang
 * @version 4.6.18
 */
public class Jumper extends Actor
{
    /**
     * Constructs a red bug.
     */
    public Jumper()
    {
        setColor(Color.GREEN);
    }

    /**
     * Constructs a jumper of a given color.
     * @param jumperColor the color for this jumper
     */
    public Jumper(Color jumperColor)
    {
        setColor(jumperColor);
    }

    /**
     * Moves if it can move, turns otherwise.
     */
    public void act()
    {
        if (canJump())
        {
            jump();
        }
        else
        {
            turn();
        }
    }

    /**
     * Turns the jumper 45 degrees to the right without changing its location.
     */
    public void turn()
    {
        setDirection(getDirection() + Location.HALF_RIGHT);
    }

    /**
     * Allows the jumper to jump forward
     */
    public void jump()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
        {
            return;
        }
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        Location twoNext = next.getAdjacentLocation(getDirection());
        if (gr.isValid(twoNext))
        {
            moveTo(twoNext);
        }
        else
        {
            removeSelfFromGrid();
        }
    }

    /**
     * Tests whether this jumper can jump forward into a location
     * @return true if this jumper can jump.
     */
    public boolean canJump()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
        {
            return false;
        }
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
        {
            return false;
        }
        Actor neighbor = gr.get(next);
        Location twoNext = next.getAdjacentLocation(getDirection());
        if (!((neighbor instanceof Flower) || (neighbor instanceof Rock) || (neighbor == null)))
        {
            return false;
        }
        if (!gr.isValid(twoNext))
        {
            return false;
        }
        neighbor = gr.get(twoNext);
        return (neighbor == null) || (neighbor instanceof Flower) || (neighbor instanceof Bug);
    }
}
