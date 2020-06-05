
public class QuickSort {//p61
	public static void main(String[] args) {
		return;
	}

	public static void quickSort(int[] array, int start, int end, int[] indexArray) {
		
		
		int temp; //��ȯ�� ���� �ӽú���
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

	public static void reverseQuickSort(int[] array, int start, int end,  int[] indexArray) {

		int temp;
		int tempIndex;

		int left=start;

		int right=end;

		if(start<end) {

			int pivot=(start+end)/2;

			temp=array[pivot];
			tempIndex=indexArray[pivot];
			
			array[pivot]=array[start];
			indexArray[pivot]=indexArray[start];

			array[start]=temp;
			indexArray[start]=tempIndex;

			left++;

			while(left<right) {

				while((array[left]>array[start])&&(left<right))

					left++;

				while((array[right]<array[start]))

					right--;

				if(left<right) {

					temp=array[right];
					tempIndex=indexArray[right];

					array[right]=array[left];
					indexArray[right]=indexArray[left];

					array[left]=temp;
					indexArray[left]=tempIndex;

				}

			}

			pivot=right;

			temp=array[pivot];
			tempIndex=indexArray[pivot];

			array[pivot]=array[start];
			indexArray[pivot]=indexArray[start];

			array[start]=temp;
			indexArray[start]=tempIndex;

			reverseQuickSort(array, start, pivot-1, indexArray);

			reverseQuickSort(array, pivot+1, end, indexArray);

		}

		return;

	}

}