import java.util.ArrayList;

public class Layer {
	
	private int type; //0 = input, 1 = hidden, 2 = output
	
	private ArrayList<Neuron> neurons = new ArrayList<Neuron>();
	
	public Layer(int type, int neuronCount) {
		
		for(int i=0; i<neuronCount; i++) {
			neurons.add(new Neuron(type));
		}
		
	}
	
	public Neuron getNeuron(int i) {
		return neurons.get(i);
	}
	
	public int getNeuronCount() {
		return neurons.size();
	}
	
	
	
}
