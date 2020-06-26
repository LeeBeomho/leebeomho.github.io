
public class Selection {
	public static void selection(LinearFuct[] arr, LinearFuct[] bestArr) {
		double[] mse=new double[10];
		int[] indexArray=new int[10];
		
		for(int i=0; i<10; i++) {
			indexArray[i]=i;
			mse[i]=MSE.value(arr[i].useA(), arr[i].useB());	
		}
		
		quickSort(mse, 0, 9, indexArray);
		
		for(int i=0; i<4; i++) {
			bestArr[i]=arr[indexArray[i]];
		}
		
		return;
	
	}
	public static void quickSort(double[] array, int start, int end, int[] indexArray) {
		
		
		double temp; //��ȯ�� ���� �ӽú���
		int tempIndex;
		
		int left=start; // �տ��� ���� ���� ���ڵ��� �ε��� üũ�ϴ� ����

		int right=end;  // �ڿ��� ���� ū���ڵ��� üũ�ϴ� ����

		if(start<end) { // �˻��� �迭�� �ϳ��� ���� �߸��� ������ �����ϴ� �� �����ϱ� ���ؼ�

			int pivot=(start+end)/2;  // ��� �ε����� �Ǻ����� ����
			
			temp=array[pivot];    // ���� ù��° �ڸ��� �Ǻ� ��ȯ
			tempIndex=indexArray[pivot];
			
 			array[pivot]=array[start];
 			indexArray[pivot]=indexArray[start];
 			
			array[start]=temp;
			indexArray[start]=tempIndex;
			
			left++;  // ���� ù��° �ε����� �Ǻ��� �����ϰ� �־� ���� �ε����� �Ѵ�.

			while(left<right) { //������ ����� üũ�ϴ� �� ����

				while((array[left]<array[start])&&(left<right)) //�Ǻ����� ���� ���� ���������� �����ε����� �Ѿ

					left++;  //�Ǻ����� ���� ��� ���� ������ ���� �ε����� ����.

				//left �ε����� ����Ű�� ���� �Ǻ����� ū ��츦 ���´�.

				while((array[right]>array[start])) // �Ǻ����� ū��� ���������� ���� �ε����� �Ѿ

					right--; //�̹� �ε��� ���� ������ �ٸ� �ε����� �������� ����

				//right �ε����� ����Ű�� ��  �Ǻ����� ���� ���� ���´�.

				if(left<right) { //������ �����̶��

					temp=array[right];
					tempIndex=indexArray[right];  //right�� left ��ȯ

					array[right]=array[left];
					indexArray[right]=indexArray[left];
					
					array[left]=temp;
					indexArray[left]=tempIndex;

				}

				/*right �ε����� ����Ű�� ��  �Ǻ����� ���� ���� �����µ� right�� left���� �۴ٸ�

				  if ������ ������ �ʰ�  while ���� �������� 

				    �̶� right �ε��� ���� pivot���� ���� ���� ū���� ��迡 �ִ� �� �� ���� ����.

				*/

			}

			pivot=right;
			

			// right �ε��� ������ �Ǻ��� �� ũ�� ������ �ٲپ��ش�. �Ǻ����� ù��° �ε����� ���� ������.

			temp=array[pivot]; //��ȯ 
			tempIndex=indexArray[pivot];
			
			array[pivot]=array[start];
			indexArray[pivot]=indexArray[start];

			array[start]=temp;
			indexArray[start]=tempIndex;

			//���� �Ǻ� �ε����� �������� �´� �Ǻ����� ���� ��, ��� �Ǻ����� ū����.

			//pivot �ε��� �ڸ��� ���� ���ֱ� ������ ������ ������ �������ش�.

			quickSort(array, start, pivot-1, indexArray);//����

			quickSort(array, pivot+1, end, indexArray);//������

		}

		return;

	}
}
