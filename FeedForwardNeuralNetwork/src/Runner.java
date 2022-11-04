
public class Runner {

	public static void main(String[] args) {
		
		FeedForwardNeuralNetwork nn = new FeedForwardNeuralNetwork(1, 1, 2, 1);
		
		nn.createConnections();
		nn.populate();
		
		nn.printNeurons();
		nn.printConnections();
		nn.printParameters();
		
		System.out.println("Bias Count: " + Neuron.biasCount + ", Weight Count: " + Connection.weightCount);
		
		
		
	}

}
