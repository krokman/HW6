import java.util.HashSet;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		// Pair
		Pair<String, Integer> element = Pair.of("Element", 123);
		Pair<String, Integer> elementClone = Pair.of("Element", 123);

		System.out.println(element.getFirst() + " " + element.getSecond() + " HashCode " + element.hashCode() +
				" Equals " + element.equals(elementClone));

		// SymmetricDifference
		Set<Integer> num1 = new HashSet<>();
		num1.add(3);
		num1.add(7);
		num1.add(9);

		HashSet<Integer> num2 = new HashSet<>();
		num2.add(5);
		num2.add(7);
		num2.add(12);

		Set<Integer> result = SymmetricDifference.symmetricDifference(num1, num2);
		System.out.println("SymmetricDifference = " + result);

		// Serialize
		Animal[] animalM1 = { new Animal("Cat"), new Animal("Dog"), new Animal("Elephant"),
				new Animal("Cock"), new Animal("Bull"), new Animal("Ant"),
				new Animal("Tentecles"), new Animal("Worm")};

		byte[] byteArray = Animal.serializeAnimalArray(animalM1);
		Animal[] animalM2 = Animal.deserializeAnimalArray(byteArray);
		System.out.println(animalM2[0] + " " +animalM2[1] + "" + animalM2[animalM1.length -1]);
	}
}

