import java.util.List;
import java.util.ArrayList;

public class FeedForwardNeuralNetwork{
    Matrix weights_ih; //Weights for input -> hidden layer
    Matrix weights_ho; //Weights for hidden -> output layer
    ArrayList<Matrix> weights_hh = new ArrayList<>();
    ArrayList<Matrix> bias_h = new ArrayList<>(); //Bias for hidden layer
    Matrix bias_o; //Bias for output layer
    int hiddenLayerCount;

    public FeedForwardNeuralNetwork(int inputSize, int[] hiddenSize, int outputSize){
        weights_ih = new Matrix(hiddenSize[0],inputSize);
        weights_ho = new Matrix(outputSize,hiddenSize[hiddenSize.length-1]);

        for(int i=0; i<hiddenSize.length; i++){
            bias_h.add(new Matrix(hiddenSize[i], 1));

            if(i!=0){
                weights_hh.add(new Matrix(hiddenSize[i], hiddenSize[i-1]));
            }
        }
        
        bias_o = new Matrix(outputSize, 1);

        hiddenLayerCount=hiddenSize.length;
    }

    public List<Double> feedforward(double[] x){
        Matrix input = Matrix.fromArray(x);
        ArrayList<Matrix> hiddens = new ArrayList<>();

        hiddens.add(Matrix.multiply(weights_ih, input));
        hiddens.get(0).add(bias_h.get(0));
        hiddens.get(0).sigmoid();
        
        for(int i=1; i<hiddenLayerCount; i++){
            hiddens.add(Matrix.multiply(weights_hh.get(i-1), hiddens.get(i-1)));
            hiddens.get(i).add(bias_h.get(i));
            hiddens.get(i).sigmoid();
        }

        Matrix output = Matrix.multiply(weights_ho, hiddens.get(hiddens.size()-1));
        output.add(bias_o);
        output.sigmoid();

        return output.toArray();
    }

}