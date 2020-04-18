package selection.sort;

import java.util.Arrays; // �迭�� �� �� Ȱ���ϱ� ���� import ��

public class MinSelectionSort {
	public static void main(String[] args) {
		
		int[] array= {5, 2, 4, 6, 1, 3}; // �迭 ����
		
		System.out.println(Arrays.toString(array)); // �迭 ���
		
		minSelectionArrayInt(array); //�迭 ����
		
		System.out.println(Arrays.toString(array)+" ������"); // ���ĵ� �迭 ���
		
	}
	
	public static void minSelectionArrayInt(int[] array){ //�ּڰ� ���� ����
		
		int min, minIndex; //�ּڰ�, �ּڰ� �ε���
		int temp; 
		int j;
		
		for(int i=0; i<array.length-1; i++) { //������ �ѹ��� ���ص� ������ �ٵ� n-1���� �ϸ� ��
			min=array[i]; 
			minIndex=i;
			
			
			for( j=i ;j<array.length; j++) { //���ĵ� �迭�� ������ ������ �迭���� �ּڰ� ã��
				if(min>array[j]) {
					min=array[j];
					minIndex=j;
				}
			}
			System.out.println(i+"�� �ε��������� �ּڰ� "+min+"�� �ε��� "+minIndex+"�� �̴�.");
			System.out.println(i+"�� �ε��� ���� "+minIndex+"�� �ε��� �� ��ȯ");
			
			
			temp=array[i];               //�ּڰ��� ���� �� �迭 ��ȯ
			array[i]=array[minIndex];
			array[minIndex]=temp;
			
			System.out.println(Arrays.toString(array)+" "+(i+1)+"��° ����");	
		}
		
		return;
	}
}
