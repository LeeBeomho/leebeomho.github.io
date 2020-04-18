package selectionSort;
import java.util.Arrays; // �迭�� �� �� Ȱ���ϱ� ���� import ��

public class max_selectionSort {
	public static void main(String[] args) {
		
		int[] sort= {5, 2, 4, 6, 1, 3}; // �迭 ����
		
		System.out.println(Arrays.toString(sort)); // �迭 ���
		
		max_selectionArrayInt(sort); //�迭 ����
		
		System.out.println(Arrays.toString(sort)+" ������"); // ���ĵ� �迭 ���
		
	}
	
	public static void max_selectionArrayInt(int[] array){ //�ִ� ���� ����
		
		int max, maxIndex; //�ִ�, �ִ� �ε���
		int temp; 
		
		for(int i=0; i<array.length-1; i++) { //������ �ѹ��� ���ص� ������ �ٵ� n-1���� �ϸ� ��
			max=array[i]; 
			maxIndex=i;
			
			int j;
			for( j=i ;j<array.length; j++) { //���ĵ� �迭�� ������ ������ �迭���� �ִ� ã��
				if(max<array[j]) {
					max=array[j];
					maxIndex=j;
				}
			}
			System.out.println(i+"�� �ε��� ������ �ִ� "+max+"�� �ε��� "+maxIndex+"�� �̴�.");
			System.out.println(i+"�� �ε��� ���� "+maxIndex+"�� �ε��� �� ��ȯ");
			
			
			temp=array[i];               //�ּڰ��� ���� �� �迭 ��ȯ
			array[i]=array[maxIndex];
			array[maxIndex]=temp;
			
			System.out.println(Arrays.toString(array)+" "+(i+1)+"��° ����");	
		}
		
		return;
	}
}