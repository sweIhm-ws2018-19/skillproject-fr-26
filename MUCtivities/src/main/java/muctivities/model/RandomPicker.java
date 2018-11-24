package muctivities.model;

import java.util.List;
import java.util.Random;

public final class RandomPicker {

	private RandomPicker() {
		// static class
	}
	
	public static <U> U get(List<U> list) {
		int randomIdx = new Random().nextInt(list.size());
		return list.get(randomIdx);
	}
}
