package muctivities.model;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

public final class RandomPicker {

	/**
	 * static class
	 */
	private RandomPicker() {
	}

	public static <U> U get(List<U> list) {
		int randomIdx = new SecureRandom().nextInt(list.size());
		return list.get(randomIdx);
	}

	public static <U> U get(U[] list) {
		return get(Arrays.asList(list));
	}
}
