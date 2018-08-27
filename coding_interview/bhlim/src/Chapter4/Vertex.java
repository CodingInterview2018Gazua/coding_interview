package Chapter4;

public class Vertex {
	int data;

	public Vertex(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return String.valueOf(data);
	}

	@Override
	public boolean equals(Object obj) {
		return data == ((Vertex) obj).data;
	}

	@Override
	public int hashCode() {
		return data;
	}
}
