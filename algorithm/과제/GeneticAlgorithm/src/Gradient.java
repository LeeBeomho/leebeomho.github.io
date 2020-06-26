public class Gradient {
	public static double maxGrad;
	
	public static double maxHigh;
	
	public static void getMaxGrad(double gradient) {
		
		maxGrad=gradient;
		
		return;
	}
	
	public static void getMaxHigh(double high) {
		maxHigh=high;
		
		return;
	}
	
	public static void main(String[] args) {
		double[] gradient=new double[Data.OECDname.length];
		
		for(int i=0; i<Data.OECDname.length; i++) {
			gradient[i]=Data.OECDinternet[i]/Data.OECDhyperInternet[i];
		}
		
		getMaxGrad(gradient[0]);
		
		for(int i=1; i<Data.OECDname.length; i++) {
			if(gradient[i]>maxGrad) {
				getMaxGrad(gradient[i]);
			}
		}
		
		getMaxHigh(Data.OECDinternet[0]);
		
		for(int i=1; i<Data.OECDname.length; i++) {
			if(Data.OECDinternet[i]>maxHigh) {
				getMaxGrad(Data.OECDinternet[i]);
			}
		}
	}
}
