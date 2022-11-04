
public class Connection {
	
	public static int weightCount;
	
	private double weight;
	
	private int layerIdx;
	private int toIdx;
	private int fromIdx;
	
		
	public Connection(int layerIdx, int toIdx, int fromIdx) {
		this.layerIdx = layerIdx;
		this.toIdx = toIdx;
		this.fromIdx = fromIdx;
	}
	
	public void setWeight(double weight) {
		this.weight=weight;
		weightCount++;
	}
	
	@Override
	public String toString() {
		return "Layer Index: " + layerIdx + ", To Index: " + toIdx + ", From Index: " + fromIdx + ", Weight: " + weight;
	}

}
