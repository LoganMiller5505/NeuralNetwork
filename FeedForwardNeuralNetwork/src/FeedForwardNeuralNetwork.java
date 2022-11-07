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
		
		populate();
	}
	
	public void populate() {
		for(int i = 0; i<getLayerCount(); i++) {
			for(int k = 0; k<layers.get(i).getNeuronCount(); k++) {
				if(rand.nextBoolean()) {
					layers.get(i).getNeuron(k).setBias(rand.nextDouble());
				}
				else {
					layers.get(i).getNeuron(k).setBias(-rand.nextDouble());
				}
				
			}
		}
		
		for(int i = 0; i<connections.size(); i++) {
			if(rand.nextBoolean()) {
				connections.get(i).setWeight(rand.nextDouble());
			}
			else {
				connections.get(i).setWeight(-rand.nextDouble());
			}
		}
		
	}
	
	public void createConnections() {
		for(int i = 0; i<getLayerCount()-1; i++) {
			for(int k = 0; k<layers.get(i+1).getNeuronCount(); k++) {
				for(int j=0; j<layers.get(i).getNeuronCount(); j++) {
					connections.add(new Connection(i, k, j));
				}
			}
		}
	}
	
	
	public void setInputActivations(double val) {
		for(int i = 0; i<layers.get(0).getNeuronCount(); i++) {
			layers.get(0).getNeuron(i).setActivation(val);;
		}
	}
	
	public void printOutputActivations() {
		for(int i = 0; i<layers.get(layers.size()-1).getNeuronCount(); i++) {
			System.out.println("Neuron " + i + " Output Activation: " + layers.get(layers.size()-1).getNeuron(i).getActivation());
		}
	}
	
	
	public void feedforward() {
		int currentWorkingIdx = 0;
		for(int i = 1; i<getLayerCount(); i++) {
			for(int k = 0; k<layers.get(i).getNeuronCount(); k++) {
				double currentActivationVal = 0;
				boolean validConnection = true;
				int j = 0;
				while(validConnection) {
					currentActivationVal += sigmoid( ((layers.get(i-1).getNeuron(j).getActivation()) * (connections.get(currentWorkingIdx).getWeight())) + (layers.get(i).getNeuron(k).getBias()) );
					j++;
					if(connections.get(currentWorkingIdx).getFromIdx() >= j) {
						validConnection=false;
					}
				}
				layers.get(i).getNeuron(k).setActivation(sigmoid(currentActivationVal));
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
	
	
	public double sigmoid(double x) {
		return (1/(1+Math.exp(-x)));
	}
	
	public double ReLU(double x) {
		if(x<0) {
			return 0;
		}
		else {
			return x;
		}
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
