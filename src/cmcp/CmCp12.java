package cmcp;
import java.util.Scanner;

public class CmCp12 {

    public static void main(String[] args) {
        // Create scanner object for user input
        Scanner Lea = new Scanner(System.in);

        // Ask for the number of vertices in the graph
        System.out.println("Cálculo de Caminos Más Cortos entre cada par de nodos del Grafo");
        System.out.print("Número de vértices en el grafo: ");
        int numVertices = Lea.nextInt();  // Read number of vertices

        // Create a new graph with the given number of vertices
        Grafo grafo = new Grafo(numVertices);

        // Ask for the number of edges in the graph
        System.out.print("Número de aristas del grafo: ");
        int numAristas = Lea.nextInt();  // Read number of edges

        // Loop to input each edge
        for (int i = 0; i < numAristas; i++) {
            System.out.print("Origen de la arista (0 a " + (numVertices - 1) + "): ");
            int origen = Lea.nextInt();  // Read origin vertex

            System.out.print("Vértice de destino de la arista (0 a " + (numVertices - 1) + "): ");
            int destino = Lea.nextInt();  // Read destination vertex

            System.out.print("Costo de la arista (valor decimal): ");
            double costoArista = Lea.nextDouble();  // Read edge cost

            // Add the edge to the graph
            grafo.agregarArista(origen, destino, costoArista);
        }

        // Display the adjacency matrix (original graph)
        System.out.println("Matriz Original:");
        grafo.mostrarMatriz();

        // Calculate the shortest paths using Floyd-Warshall algorithm
        grafo.CaminosMasCortos();

        // Display the matrix of shortest paths
        System.out.println("Matriz de Caminos más Cortos:");
        grafo.mostrarMatriz();

        // Close the scanner
        Lea.close();
    }
}
