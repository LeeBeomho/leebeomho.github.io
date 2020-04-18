package selection.sort;

import java.util.Arrays; // 배열을 좀 더 활용하기 위해 import 함

public class MinSelectionSort {
	public static void main(String[] args) {
		
		int[] array= {5, 2, 4, 6, 1, 3}; // 배열 선언
		
		System.out.println(Arrays.toString(array)); // 배열 출력
		
		minSelectionArrayInt(array); //배열 정렬
		
		System.out.println(Arrays.toString(array)+" 최종본"); // 정렬된 배열 출력
		
	}
	
	public static void minSelectionArrayInt(int[] array){ //최솟값 선택 정렬
		
		int min, minIndex; //최솟값, 최솟값 인뎃스
		int temp; 
		int j;
		
		for(int i=0; i<array.length-1; i++) { //마지막 한번은 안해도 정렬이 다됨 n-1번만 하면 됨
			min=array[i]; 
			minIndex=i;
			
			
			for( j=i ;j<array.length; j++) { //정렬된 배열을 제외한 나머지 배열에서 최솟값 찾기
				if(min>array[j]) {
					min=array[j];
					minIndex=j;
				}
			}
			System.out.println(i+"번 인덱스부터의 최솟값 "+min+"은 인덱스 "+minIndex+"번 이다.");
			System.out.println(i+"번 인덱스 값과 "+minIndex+"번 인덱스 값 교환");
			
			
			temp=array[i];               //최솟값과 가장 앞 배열 교환
			array[i]=array[minIndex];
			array[minIndex]=temp;
			
			System.out.println(Arrays.toString(array)+" "+(i+1)+"번째 정렬");	
		}
		
		return;
	}
}
