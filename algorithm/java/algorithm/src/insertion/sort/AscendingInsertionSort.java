package insertion.sort;
import java.util.Arrays; 

//��������
public class AscendingInsertionSort {
	public static void main(String[] args) {
		int[] array= {5, 2, 4, 6, 1, 3};
		//int[] array= {1, 2, 3, 4, 5, 6}; //�ּ��� ���
		//int[] array= {6, 5, 4, 3, 2, 1}; //�־��� ���
		
		System.out.println(Arrays.toString(array));
		
		ascendingInsertionSortArrayInt(array);
		
		System.out.println(Arrays.toString(array)+" ����");
	}
	public static void ascendingInsertionSortArrayInt(int[] array) {
		int key; //�����Ҷ� �迭�� �˸��� ��ġ�� �����ϰ� ���ִ� key
		System.out.println();
		// �� �տ� ���� �̹� �����߰� �׵ڿ� ������ �����ϱ� ������ n-1�� �õ���
		for(int i, j=1; j<array.length; j++) { // j-1 �� �ε��� �� �ڷ� ���� �Ұű� ������ j�� 1���� ����
			key=array[j];
			
			i=j-1; // �ε��� j�� �� �迭�� ���ĵ����� �װ��� �ε��� i��������
			
			System.out.println(j+"�� �ε��� �� "+key+"�� key �̴�. ");
			
			System.out.println(i+"�� �ε��� �� "+array[i]+"�� �� .");
			
			while((i>=0)&&(array[i]>key)) { // i�� �ε��� ��ȣ�� 0�̻��̰� ���ĵ� �迭�� Ű������ ũ��?
				System.out.print("key ���� �� �۴�."+i+"�� �ε��� �� "+(i+1)+"�� �ε����� �δ�.");
				
				array[i+1]=array[i]; //key ���� �۱� ������ key������ ū ������ �ڷ� �̴� �۾�
				i=i-1; // key�� �� ���� ����� ���ϱ� ���� i�� ���δ�.
				
				if(i!=-1)System.out.println(i+"�� �ε��� �� "+array[i]+"�� ��.");
				else System.out.println("0�� �ε����� ����"); 
			}
			if(i!=-1) System.out.println(i+"�� �ε��� �� "+array[i]+"���� key�� ũ��. ");
			array[i+1]=key; // key���� i �ε��� ������ ũ�� ������ i �ε��� ���� ������
			System.out.println((i+1)+"�� �ε���  key ����");
			
			System.out.println(Arrays.toString(array)+" "+j+"�� ����");
			System.out.println();
		}
		
		return;
	}
}