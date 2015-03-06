package technology.tag.codejam.contests.practice.alwaysturnleft;

import technology.tag.codejam.base.DataFormatter;
import technology.tag.codejam.contests.practice.alwaysturnleft.MutableRoom.Opening;

public class RoomFormatter implements DataFormatter<Room> {

	@Override
	public String format(Room room) {
		int i = 0;
		for (Opening opening : room.getOpenings()) {
			i |= opening.bitMask;
		}
		switch (i) {
		case 0b1000:
			return "1";
		case 0b0100:
			return "2";
		case 0b1100:
			return "3";
		case 0b0010:
			return "4";
		case 0b1010:
			return "5";
		case 0b0110:
			return "6";
		case 0b1110:
			return "7";
		case 0b0001:
			return "8";
		case 0b1001:
			return "9";
		case 0b0101:
			return "a";
		case 0b1101:
			return "b";
		case 0b0011:
			return "c";
		case 0b1011:
			return "d";
		case 0b0111:
			return "e";
		case 0b1111:
			return "f";
		}
		throw new IllegalStateException("this should never happen!");
	}

}
