package selectionSort;
import java.util.Arrays; // 배열을 좀 더 활용하기 위해 import 함

public class max_selectionSort {
	public static void main(String[] args) {
		
		int[] sort= {5, 2, 4, 6, 1, 3}; // 배열 선언
		
		System.out.println(Arrays.toString(sort)); // 배열 출력
		
		max_selectionArrayInt(sort); //배열 정렬
		
		System.out.println(Arrays.toString(sort)+" 최종본"); // 정렬된 배열 출력
		
	}
	
	public static void max_selectionArrayInt(int[] array){ //최댓값 선택 정렬
		
		int max, maxIndex; //최댓값, 최댓값 인뎃스
		int temp; 
		
		for(int i=0; i<array.length-1; i++) { //마지막 한번은 안해도 정렬이 다됨 n-1번만 하면 됨
			max=array[i]; 
			maxIndex=i;
			
			int j;
			for( j=i ;j<array.length; j++) { //정렬된 배열을 제외한 나머지 배열에서 최댓값 찾기
				if(max<array[j]) {
					max=array[j];
					maxIndex=j;
				}
			}
			System.out.println(i+"번 인데스 부터의 최댓값 "+max+"은 인덱스 "+maxIndex+"번 이다.");
			System.out.println(i+"번 인덱스 값과 "+maxIndex+"번 인덱스 값 교환");
			
			
			temp=array[i];               //최솟값과 가장 앞 배열 교환
			array[i]=array[maxIndex];
			array[maxIndex]=temp;
			
			System.out.println(Arrays.toString(array)+" "+(i+1)+"번째 정렬");	
		}
		
		return;
	}
}