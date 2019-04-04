import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

public class Animal implements Serializable {
	private final String name;

	public Animal(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Animal) {
			return Objects.equals(name, ((Animal) obj).name);
		}
		return false;
	}

	@Override
	public String toString() {
		return "Animal{" +
				"name='" + name + '\'' +
				'}';
	}

	public static Animal[] deserializeAnimalArray(byte[] data) {
		try (ObjectInputStream input = new ObjectInputStream(new ByteArrayInputStream(data))) {
			int size = input.readInt();
			Animal[] animalArray = new Animal[size];
			for (int i = 0; i < size; i++) {
				animalArray[i] = (Animal) input.readObject();
			}
			return animalArray;
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException();
		} catch (IOException e) {
		}
		throw new IllegalArgumentException("Wrong data");
	}
}