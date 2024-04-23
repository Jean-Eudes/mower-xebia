package eu.jeaneudes.xebia;

import java.util.StringTokenizer;

public class MowerControl {

	public Rectangle initializeSurface(String line) {
		StringTokenizer tokenizer = new StringTokenizer(line, " ");
		int count = tokenizer.countTokens();
		if (count != 2) {
			throw new RuntimeException("initialization surface failed, number of parameters is " + count + "inside of 2");
		}

		int width = Integer.parseInt(tokenizer.nextToken());
		int height = Integer.parseInt(tokenizer.nextToken());

		return new Rectangle(width, height);
	}

	public Mower initializeMower(String line, Surface surface) {

		StringTokenizer tokenizer = new StringTokenizer(line, " ");
		int count = tokenizer.countTokens();
		if (count != 3) {
			throw new RuntimeException("initialization surface failed, number of parameters is " + count + " instead of 3");
		}

		int x = Integer.parseInt(tokenizer.nextToken());
		int y = Integer.parseInt(tokenizer.nextToken());
		Orientation orientation = Orientation.valueOf(tokenizer.nextToken());

		return new Mower(x, y, orientation, surface);
	}

	public void exploreSurface(String line, Mower mower) {
		for (int i = 0; i < line.length(); i++) {
			char displacement = line.charAt(i);
			switch (displacement) {
			case 'G':
				mower.turnLeft();
				break;

			case 'D':
				mower.turnRight();
				break;
			case 'A':
				mower.advance();
				break;
			default:
				// TODO : que fait-on en cas de caratères inconnu.
				break;
			}
		}
	}
}
