
public class Main {
	public static void main(String[] args) {
		LinearFuct[] arr=new LinearFuct[10];
		LinearFuct[] bestArr=new LinearFuct[4];
		LinearFuct bestFit=new LinearFuct(1000, 1000);
		int n=2;
		
		
		for(int i=0; i < arr.length; i++) {
			arr[i]=new LinearFuct();
			arr[i].initA();
			arr[i].initB();
			
			if(i!=0) {
				for(int j=0; j<i; j++) {
					if((arr[i].useA()==arr[j].useA())&&(arr[i].useB()==arr[j].useB())) {
						arr[i].initA();
						arr[i].initB();
						
						j=0;
					}			
				}
			}
			
		}
		Selection.selection(arr, bestArr);
		
		for(int i=0; i < arr.length; i++) {
			System.out.print(arr[i].useA()+"x+"+arr[i].useB()+" MSE:"
					+MSE.value(arr[i].useA(), arr[i].useB())+" ");
		}
		System.out.println();
		System.out.println("����� �ڼյ� ����");
		for(int i=0; i < bestArr.length; i++) {
			System.out.print(bestArr[i].useA()+"x+"+bestArr[i].useB()+" MSE:"
					+MSE.value(bestArr[i].useA(), bestArr[i].useB())+" ");
		}
		System.out.println();
		
		if(MSE.value(bestFit.useA(), bestFit.useB())>MSE.value(bestArr[0].useA(),bestArr[0].useB())){
			 bestFit=bestArr[0];
			}
			
			System.out.println(0+"���� ������ �� "+bestFit.useA()+","+bestFit.useB()+" MSE:"
					+MSE.value(bestFit.useA(), bestFit.useB()));
			
		
		for(int j=0; j<n; j++) {
		
			
			CrossOver.crossover(arr, bestArr);
			System.out.println();
			System.out.println("��������");
			for(int i=0; i < arr.length; i++) {
				System.out.print(arr[i].useA()+"x+"+arr[i].useB()+" MSE:"
						+MSE.value(arr[i].useA(), arr[i].useB())+" ");
			}
			System.out.println();
			System.out.println();
			
			
			Mutation.mutation(arr);
			System.out.println("��������");
			for(int i=0; i < arr.length; i++) {
				System.out.print(arr[i].useA()+"x+"+arr[i].useB()+" MSE:"
						+MSE.value(arr[i].useA(), arr[i].useB())+" ");
			}
			
			Selection.selection(arr, bestArr);
			
			for(int i=0; i < arr.length; i++) {
				System.out.print(arr[i].useA()+"x+"+arr[i].useB()+" MSE:"
						+MSE.value(arr[i].useA(), arr[i].useB())+" ");
			}
			System.out.println();
			System.out.println("����� �ڼյ� ����");
			for(int i=0; i < bestArr.length; i++) {
				System.out.print(bestArr[i].useA()+"x+"+bestArr[i].useB()+" MSE:"
						+MSE.value(bestArr[i].useA(), bestArr[i].useB())+" ");
			}
			System.out.println();
			
			if(MSE.value(bestFit.useA(), bestFit.useB())>MSE.value(bestArr[0].useA(),bestArr[0].useB())){
				 bestFit=bestArr[0];
				}
				
			System.out.println();
			
			System.out.println((j+1)+"���� ������ �� "+bestFit.useA()+","+bestFit.useB()+" MSE:"
					+MSE.value(bestFit.useA(), bestFit.useB()));
				
		
		}
		
		MyFrame f = new MyFrame("Main frame", bestFit);
	}
}
				