package insertionSort;
import java.util.Arrays; 

//내림차순
public class descending_insertionSort {
	public static void main(String[] args) {
		int[] sort= {5, 2, 4, 6, 1, 3};
		//int[] sort= {1, 2, 3, 4, 5, 6}; //최악의 경우
		//int[] sort= {6, 5, 4, 3, 2, 1}; //최선의 경우
		
		System.out.println(Arrays.toString(sort));
		
		descending_insertionSortArrayInt(sort);
		
		System.out.println(Arrays.toString(sort)+" 최종");
	}
	public static void descending_insertionSortArrayInt(int[] array) {
		int key; //정렬할때 배열을 알맞은 위치에 삽일하게 해주는 key
		System.out.println();
		// 맨 앞에 값은 이미 삽입했고 그뒤에 값들을 삽입하기 때문에 n-1번 시도함
		for(int i, j=1; j<array.length; j++) { // j-1 번 인덱스 앞 뒤로 삽입 할거기 때문에 j는 1부터 시작
			key=array[j];
			
			i=j-1; // 인덱스 j번 앞 배열은 정렬되있음 그것이 인덱스 i번까지임
			
			System.out.println(j+"번 인덱스 값 "+key+"가 key 이다. ");
			
			System.out.println(i+"번 인뎃스 값 "+array[i]+"와 비교 .");
			
			while((i>=0)&&(array[i]<key)) { // i는 인덱스 번호가 0이상이고 정렬된 배열이 키값보다 크냐?
				System.out.print("key 값이 더 크다."+i+"번 인뎃스 값 "+(i+1)+"번 인덱스로 민다.");
				
				array[i+1]=array[i]; //key 값이 크기 때문에 key값보다 작은 값들을 뒤로 미는 작업
				i=i-1; // key를 더 큰 값들과 비교하기 위해 i를 줄인다.
				
				if(i!=-1)System.out.println(i+"번 인뎃스 값 "+array[i]+"와 비교.");
				else System.out.println("0번 인덱스에 삽입"); 
			}
			if(i!=-1) System.out.println(i+"번 인덱스 값 "+array[i]+"보다 key가 작다. ");
			array[i+1]=key; // key값이 i 인덱스 갑보다 작기 때문에 i 인덱스 위에 삽입함
			System.out.println((i+1)+"번 인덱스  key 삽입");
			
			System.out.println(Arrays.toString(array)+" "+j+"번 정렬");
			System.out.println();
		}
		
		return;
	}
}