import java.util.Random;

public class CrossOver {
	public static void crossover(LinearFuct[] arr, LinearFuct[] bestArr) {
		Random r=new Random();
		int cross1;
		int cross2;
		
		for(int i=0; i<5; i++) {
			cross1=r.nextInt(4);
			cross2=r.nextInt(4);
			
			while(cross1==cross2) {
				cross2=r.nextInt(4);
			}
			
			arr[2*i]=new LinearFuct(bestArr[cross1].useA(), bestArr[cross2].useB());
			arr[2*i+1]=new LinearFuct(bestArr[cross2].useA(), bestArr[cross1].useB());
		}
		
		return;
	}

}
