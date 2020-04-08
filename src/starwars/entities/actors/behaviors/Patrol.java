package starwars.entities.actors.behaviors;

import edu.monash.fit2099.simulator.space.Direction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Patrol {

	private ArrayList<Direction> moves;
	private int position = 0;
	
	public Patrol(Direction [] moves) {
		this.moves = new ArrayList<Direction>(Arrays.asList(moves));
	}

	public Patrol(Collection<Direction> moves) {
		this.moves = new ArrayList<Direction>(moves);
	}
	
	public Direction getNext() {
		Direction nextMove =  moves.get(position);
		position++;
		if (position >= moves.size()) {
			position = 0;
		}
		return nextMove;
	}
}
