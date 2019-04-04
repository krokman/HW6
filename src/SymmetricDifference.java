import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {
	public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
		Set<? extends T> list1 = new HashSet<>(set1);
		Set<? extends T> list1forRetain = new HashSet<>(set1);
		Set<? extends T> list2 = new HashSet<>(set2);
		list1forRetain.retainAll(set2);
		list1.removeAll(list1forRetain);
		list2.removeAll(list1forRetain);
		Set<T> list3 = new HashSet<>(list1);
		list3.addAll(list2);
		return list3;
	}
}
