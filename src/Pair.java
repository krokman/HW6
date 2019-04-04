import java.util.Objects;

public class Pair<F, S> {
	private F firstElement;
	private S secondElement;

	private Pair(F firstElement, S secondElement) {
		this.firstElement = firstElement;
		this.secondElement = secondElement;
	}

	public F getFirst() {
		return firstElement;
	}

	public S getSecond() {
		return secondElement;
	}

	public static <F, S> Pair<F, S> of(F firstElement, S secondElement) {
		return new Pair(firstElement, secondElement);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstElement == null) ? 0 : firstElement.hashCode());
		result = prime * result + ((secondElement == null) ? 0 : secondElement.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Pair)) {
			return false;
		}

		Pair<F, S> other = (Pair<F, S>) obj;
		return (Objects.equals(firstElement, other.firstElement) && Objects.equals(secondElement, other.secondElement));
	}
}
