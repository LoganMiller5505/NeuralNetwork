public class Runner {

	public static void main(String[] args) {
		
		FeedForwardNeuralNetwork nn = new FeedForwardNeuralNetwork(3, 16, 10);
		
		System.out.println(nn.feedforward(new double[] {1,1,0}));
		
	}

}
