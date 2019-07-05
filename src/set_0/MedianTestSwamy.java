package set_0;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MedianTestSwamy {

	public static void main(String[] args) {

//		int[] arr = new int[]{2,2,4, 4,1,1,1,3,4,3,5,2,6,4,5,10,9,7,6};
		int[] arr = {2,5,4,3,1,2,4,7,5,8,2,10,6,4,9,1,9,5};

		Map<Integer, Long> map = Arrays.stream(arr)
				.distinct()
				.boxed()
				.collect(Collectors.toMap(Function.identity(), a ->
					 IntStream.range(0, arr.length)
							 .boxed()
							 .filter(val -> a.equals(arr[val]))
							 .count()
				));

		System.out.println(map);

		//long max = map.values().stream().collect(Collectors.maxBy(Comparator.naturalOrder())).get();
		long max = map.values().stream().max(Comparator.naturalOrder()).get();

		List<Integer> medianList = map.keySet().stream().filter(key -> map.get(key) == max).collect(Collectors.toList());
		
		int median = medianList.stream().min(Comparator.naturalOrder()).get();
		System.out.println(median);
	}
}
