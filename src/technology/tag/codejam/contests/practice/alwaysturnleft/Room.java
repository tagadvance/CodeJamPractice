package technology.tag.codejam.contests.practice.alwaysturnleft;

import java.util.Set;

import technology.tag.codejam.contests.practice.alwaysturnleft.MutableRoom.Opening;

public interface Room {

	public Point getPoint();

	public Set<Opening> getOpenings();

	public boolean hasOpening(Opening opening);

	public void addOpening(Opening opening);

	public void addOpenings(Opening... openings);

}