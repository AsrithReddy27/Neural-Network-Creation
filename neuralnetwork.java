import java.util.Scanner;

class NeuralNetwork {
    private int numLayers;
    private int[] nodesInLayer;
    private double[][][] weights;

    public NeuralNetwork(int numLayers, int[] nodesInLayer) {
        this.numLayers = numLayers;
        this.nodesInLayer = nodesInLayer;
        this.weights = new double[numLayers - 1][][];
        initializeWeights();
    }

    private void initializeWeights() {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < numLayers - 1; i++) {
            weights[i] = new double[nodesInLayer[i] + 1][nodesInLayer[i + 1]];
            System.out.println("Enter weights for layer " + (i + 1) + " to layer " + (i + 2) + ":");

            for (int j = 0; j <= nodesInLayer[i]; j++) {
                for (int k = 0; k < nodesInLayer[i + 1]; k++) {
                    System.out.println("Weight from node " + j + " to node " + (k + 1) + ": ");
                    weights[i][j][k] = sc.nextDouble();
                }
            }
        }
    }

    public double getWeight(int fromNode, int toNode) {
        return weights[fromNode][fromNode][toNode];
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of layers: ");
        int numLayers = sc.nextInt();

        int[] nodesInLayer = new int[numLayers];
        for (int i = 0; i < numLayers; i++) {
            System.out.println("Enter the number of nodes in layer " + (i + 1) + ": ");
            nodesInLayer[i] = sc.nextInt();
        }

        NeuralNetwork nn = new NeuralNetwork(numLayers, nodesInLayer);

        System.out.println("Enter the source node index: ");
        int sourceNode = sc.nextInt();

        System.out.println("Enter the destination node index: ");
        int destinationNode = sc.nextInt();

        double weight = nn.getWeight(sourceNode, destinationNode);
        System.out.println("Weight from node " + sourceNode + " to node " + destinationNode + ": " + weight);
    }
}
