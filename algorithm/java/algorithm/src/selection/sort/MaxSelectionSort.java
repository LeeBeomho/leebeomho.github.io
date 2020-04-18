package selection.sort;
import java.util.Arrays; // �迭�� �� �� Ȱ���ϱ� ���� import ��

public class MaxSelectionSort {
	public static void main(String[] args) {
		
		int[] array= {5, 2, 4, 6, 1, 3}; // �迭 ����
		
		System.out.println(Arrays.toString(array)); // �迭 ���
		
		maxSelectionArrayInt(array); //�迭 ����
		
		System.out.println(Arrays.toString(array)+" ������"); // ���ĵ� �迭 ���
		
	}
	
	public static void maxSelectionArrayInt(int[] array){ //�ִ� ���� ����
		
		int max, maxIndex; //�ִ�, �ִ� �ε���
		int temp; 
		int j;
		
		for(int i=0; i<array.length-1; i++) { //������ �ѹ��� ���ص� ������ �ٵ� n-1���� �ϸ� ��
			max=array[i]; 
			maxIndex=i;
			
			
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