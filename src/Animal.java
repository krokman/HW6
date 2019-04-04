import java.io.*;
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
		} catch (ClassCastException e){
		} catch (ClassNotFoundException e) {
		} catch (IOException e) {
		}
		throw new IllegalArgumentException("Wrong data");
	}
	public static byte[] serializeAnimalArray(Animal[] animalArray) {
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
		     ObjectOutputStream oos = new ObjectOutputStream(baos)) {
			oos.writeInt(animalArray.length);
			for (int i = 0; i < animalArray.length; i++) {
				oos.writeObject(animalArray[i]);
			}
			return baos.toByteArray();
		} catch (IOException e) {
		}
		throw new IllegalArgumentException("Wrong data");
	}
}