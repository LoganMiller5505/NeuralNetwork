
public class Neuron {
	
	private double bias;
	private int type;
	
	public static int biasCount;
	
	public Neuron(int type) {
		this.type=type;
	}
	
	public void setBias(double bias) {
		if(type!=0) {
			this.bias = bias;
			biasCount++;
		}
	}
	
	
	
	public double getBias() {
		return bias;
	}
	
	public String toString() {
		return "Bias: " + bias + ", Type: " + type;
	}
	
	
	
}
