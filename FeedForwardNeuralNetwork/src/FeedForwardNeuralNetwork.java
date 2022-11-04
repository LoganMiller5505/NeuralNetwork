import java.util.ArrayList;
import java.util.Random;

public class FeedForwardNeuralNetwork {
	
	private int numWeights;
	private int numBiases;
	
	private Random rand = new Random();
	
	private ArrayList<Layer> layers = new ArrayList<Layer>();
	
	private ArrayList<Connection> connections = new ArrayList<Connection>();
	
	
	
	public FeedForwardNeuralNetwork(int inputLayerSize, int hiddenLayerCount, int hiddenLayerSize, int outputLayerSize) {
		
		layers.add(new Layer(0, inputLayerSize));
		
		for(int i=0; i<hiddenLayerCount; i++) {
			layers.add(new Layer(1, hiddenLayerSize));
		}
		
		layers.add(new Layer(2, outputLayerSize));
		
		createConnections();
	}
	
	public void populate() {
		for(int i = 0; i<getLayerCount(); i++) {
			for(int k = 0; k<layers.get(i).getNeuronCount(); k++) {
				layers.get(i).getNeuron(k).setBias(rand.nextDouble());
			}
		}
		
		for(int i = 0; i<connections.size(); i++) {
			connections.get(i).setWeight(rand.nextDouble());
		}
		
	}
	
	public void createConnections() {
		for(int i = 0; i<getLayerCount()-1; i++) {
			for(int k = 0; k<layers.get(i).getNeuronCount(); k++) {
				for(int j=0; j<layers.get(i+1).getNeuronCount(); j++) {
					connections.add(new Connection(i, j, k));
				}
			}
		}
		
	}
	
	
	
	
	
	public void printNeurons() {
		for(int i = 0; i<getLayerCount(); i++) {
			for(int k = 0; k<getLayer(i).getNeuronCount(); k++) {
				System.out.println("Layer " + i + ", Neuron " + k + ": " + getLayer(i).getNeuron(k));
			}
		}
	}
	
	public void printConnections() {
		for(int i = 0; i<getConnectionCount(); i++) {
			System.out.println(getConnection(i));
		}
	}
	
	
	public void printParameters() {
		System.out.println("Number of Weights: " + numWeights + ", Number of Biases: " + numBiases);
	}
	
	
	
	
	
	public Layer getLayer(int i) {
		return layers.get(i);
	}
	
	public int getLayerCount() {
		return layers.size();
	}
	
	
	public Connection getConnection(int i) {
		return connections.get(i);
	}
	
	public int getConnectionCount() {
		return connections.size();
	}
	
	
	
}
