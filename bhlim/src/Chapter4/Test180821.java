package Chapter4;

public class Test180821 {
	public static void main(String[] args) {
		DirectedGragh dg = new DirectedGragh();

		Vertex v0 = new Vertex(0);
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);

		dg.addEdge(v0, v1);
		dg.addEdge(v1, v2);
		dg.addEdge(v2, v3);
		dg.addEdge(v3, v4);
		dg.addEdge(v0, v4);

		dg.printGragh();

		System.out.println(dg.isConnected(v0, v1));
		System.out.println(dg.isConnected(v1, v3));
		System.out.println(dg.isConnected(v0, v4));
	}
}
