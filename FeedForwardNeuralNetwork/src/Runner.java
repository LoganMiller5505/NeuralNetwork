
public class Runner {

	public static void main(String[] args) {
		
		FeedForwardNeuralNetwork nn = new FeedForwardNeuralNetwork(784, 2, 16, 10);
		
		//nn.createConnections();
		//nn.populate();
		
		nn.printNeurons();
		nn.printConnections();
		nn.printParameters();
		
		System.out.println("Bias Count: " + Neuron.biasCount + ", Weight Count: " + Connection.weightCount);
		
		nn.setInputActivations(10000);
		
		nn.feedforward();
		
		nn.printOutputActivations();
		
		
	}

}
