public class Runner {

	public static void main(String[] args) {
		
		FeedForwardNeuralNetwork nn = new FeedForwardNeuralNetwork(5, new int[]{10, 8, 7}, 10);
		

		System.out.println(nn.feedforward(new double[] {1,1,0,0,1}));
		
	}

}
