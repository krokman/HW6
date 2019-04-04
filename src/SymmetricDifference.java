import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {
	public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
		Set<T> list1 = new HashSet<>(set1);
		list1.addAll(set2);
		set1.iterator().forEachRemaining((o1) -> {
			set2.iterator().forEachRemaining(o2 -> {
				if ((o1 == o2)) {
					list1.remove(o2);
				}
			});
		});
		return list1;
	}
}
