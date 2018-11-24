package muctivities.model;

import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

public class RandomPickerTest {

	@Test
	public void testGet() {
		List<Integer> list = IntStream.iterate(0, i -> i + 1)
										.limit(500)
										.boxed()
										.collect(Collectors.toList());
		Integer random1 = RandomPicker.get(list);
		Integer random2 = RandomPicker.get(list);
		assertNotEquals(random1, random2);
	}

}
