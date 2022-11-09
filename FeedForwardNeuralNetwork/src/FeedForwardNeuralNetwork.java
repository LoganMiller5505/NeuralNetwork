import java.util.List;

public class FeedForwardNeuralNetwork{
    Matrix weights_ih; //Weights for input -> hidden layer
    Matrix weights_ho; //Weights for hidden -> output layer
    Matrix bias_h; //Bias for hidden layer
    Matrix bias_o; //Bias for output layer

    public FeedForwardNeuralNetwork(int inputSize, int hiddenSize, int outputSize){
        weights_ih = new Matrix(hiddenSize,inputSize);
        weights_ho = new Matrix(outputSize,hiddenSize);

        bias_h = new Matrix(hiddenSize, 1);
        bias_o = new Matrix(outputSize, 1);
    }

    public List<Double> feedforward(double[] x){
        Matrix input = Matrix.fromArray(x);
        Matrix hidden = Matrix.multiply(weights_ih, input);
        hidden.add(bias_h);
        hidden.sigmoid();

        Matrix output = Matrix.multiply(weights_ho, hidden);
        output.add(bias_o);
        output.sigmoid();

        return output.toArray();
    }

}