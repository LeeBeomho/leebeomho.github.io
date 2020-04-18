package selectionSort;

import java.util.Arrays; // �迭�� �� �� Ȱ���ϱ� ���� import ��

public class min_selectionSort {
	public static void main(String[] args) {
		
		int[] sort= {5, 2, 4, 6, 1, 3}; // �迭 ����
		
		System.out.println(Arrays.toString(sort)); // �迭 ���
		
		min_selectionArrayInt(sort); //�迭 ����
		
		System.out.println(Arrays.toString(sort)+" ������"); // ���ĵ� �迭 ���
		
	}
	
	public static void min_selectionArrayInt(int[] array){ //�ּڰ� ���� ����
		
		int min, minIndex; //�ּڰ�, �ּڰ� �ε���
		int temp; 
		
		for(int i=0; i<array.length-1; i++) { //������ �ѹ��� ���ص� ������ �ٵ� n-1���� �ϸ� ��
			min=array[i]; 
			minIndex=i;
			
			int j;
			for( j=i ;j<array.length; j++) { //���ĵ� �迭�� ������ ������ �迭���� �ּڰ� ã��
				if(min>array[j]) {
					min=array[j];
					minIndex=j;
				}
			}
			System.out.println(i+"�� �ε��� ������ �ּڰ� "+min+"�� �ε��� "+minIndex+"�� �̴�.");
			System.out.println(i+"�� �ε��� ���� "+minIndex+"�� �ε��� �� ��ȯ");
			
			
			temp=array[i];               //�ּڰ��� ���� �� �迭 ��ȯ
			array[i]=array[minIndex];
			array[minIndex]=temp;
			
			System.out.println(Arrays.toString(array)+" "+(i+1)+"��° ����");	
		}
		
		return;
	}
}
