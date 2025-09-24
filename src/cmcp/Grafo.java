package cmcp;

public class Grafo {
    private double[][] matrizAdyacencia;  // Adjacency matrix to store the graph
    private int numVertices;  // Number of vertices in the graph

    // Constructor that receives the number of vertices
    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        // Initialize the adjacency matrix with infinity (or a large number)
        matrizAdyacencia = new double[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (i == j) {
                    matrizAdyacencia[i][j] = 0;  // No cost to go from a node to itself
                } else {
                    matrizAdyacencia[i][j] = Double.POSITIVE_INFINITY;  // No edge by default
                }
            }
        }
    }

    // Method to add an edge between two vertices with a cost
    public void agregarArista(int origen, int destino, double costoArista) {
        matrizAdyacencia[origen][destino] = costoArista;
    }

    // Method to calculate the shortest paths using Floyd-Warshall algorithm
    public void CaminosMasCortos() {
        // Floyd-Warshall algorithm
        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (matrizAdyacencia[i][k] != Double.POSITIVE_INFINITY &&
                        matrizAdyacencia[k][j] != Double.POSITIVE_INFINITY &&
                        matrizAdyacencia[i][j] > matrizAdyacencia[i][k] + matrizAdyacencia[k][j]) {
                        matrizAdyacencia[i][j] = matrizAdyacencia[i][k] + matrizAdyacencia[k][j];
                    }
                }
            }
        }
    }

    // Method to display the adjacency matrix or the shortest paths matrix
    public void mostrarMatriz() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (matrizAdyacencia[i][j] == Double.POSITIVE_INFINITY) {
                    System.out.print("INF ");  // Print "INF" for unreachable nodes
                } else {
                    System.out.print(matrizAdyacencia[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
