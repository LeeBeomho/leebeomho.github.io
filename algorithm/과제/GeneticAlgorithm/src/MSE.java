
public class MSE {
	public static double linearFuction(int a, int b, double x) {
		double result=(double)a*x+(double)b;
		return result;
	}
	
	public static double value (int a, int b) {
		double sum=0;
		
		double absoul;
		
		
		for(int i=0; i<Data.OECDname.length; i++) {
			absoul=Data.OECDinternet[i]-linearFuction(a, b, Data.OECDhyperInternet[i]);
			
			sum=(absoul*absoul);
		}
		
		return sum;
	}
}
