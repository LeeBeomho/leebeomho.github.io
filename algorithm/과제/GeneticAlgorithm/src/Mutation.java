import java.util.Random;

public class Mutation {
	public static void mutation(LinearFuct arr[]) {
		Random r=new Random();
		int p2=r.nextInt(3);
		
		for(int i=0; i<arr.length; i++) {
			double p1=(double)1/(double)10;
			if(r.nextDouble()<p1) {
				if(p2==0) {
					arr[i].initA();
				}
				else {
					arr[i].initB();
				}
			}
				
		}
		return;
	}
}
