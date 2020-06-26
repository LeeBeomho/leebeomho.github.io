
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
		
		
		double temp; //교환을 위한 임시변수
		int tempIndex;
		
		int left=start; // 앞에서 부터 작은 숫자들의 인덱스 체크하는 변수

		int right=end;  // 뒤에서 부터 큰숫자들을 체크하는 변수

		if(start<end) { // 검사할 배열이 하나인 경우와 잘못된 순서로 점검하는 걸 방지하기 위해서

			int pivot=(start+end)/2;  // 가운데 인뎃스를 피봇으로 지정
			
			temp=array[pivot];    // 가장 첫번째 자리와 피봇 교환
			tempIndex=indexArray[pivot];
			
 			array[pivot]=array[start];
 			indexArray[pivot]=indexArray[start];
 			
			array[start]=temp;
			indexArray[start]=tempIndex;
			
			left++;  // 가장 첫번째 인덱스는 피봇이 차지하고 있어 다음 인뎃스로 한다.

			while(left<right) { //순서가 뒤집어서 체크하는 걸 방지

				while((array[left]<array[start])&&(left<right)) //피봇보다 작은 경우는 문제없으니 다음인덱스로 넘어감

					left++;  //피봇보다 작은 경우 문제 없으니 다음 인덱스로 간다.

				//left 인덱스가 가르키는 값이 피봇보다 큰 경우를 들고온다.

				while((array[right]>array[start])) // 피봇보다 큰경우 문제없으니 다음 인뎃스로 넘어감

					right--; //이번 인덱스 문제 없으니 다른 인덱스로 가기위해 빼줌

				//right 인덱스가 가르키는 값  피봇보다 작은 경우로 들고온다.

				if(left<right) { //순서가 정상이라면

					temp=array[right];
					tempIndex=indexArray[right];  //right와 left 교환

					array[right]=array[left];
					indexArray[right]=indexArray[left];
					
					array[left]=temp;
					indexArray[left]=tempIndex;

				}

				/*right 인덱스가 가르키는 값  피봇보다 작은 경우로 들고오는데 right가 left보다 작다면

				  if 문으로 들어가지도 않고  while 문을 빠져나옴 

				    이때 right 인덱스 값은 pivot보다 작은 값과 큰값의 경계에 있는 값 중 작은 값임.

				*/

			}

			pivot=right;
			

			// right 인덱스 값보다 피봇이 더 크기 때문에 바꾸어준다. 피봇값은 첫번째 인덱스에 저장 되있음.

			temp=array[pivot]; //교환 
			tempIndex=indexArray[pivot];
			
			array[pivot]=array[start];
			indexArray[pivot]=indexArray[start];

			array[start]=temp;
			indexArray[start]=tempIndex;

			//이제 피봇 인덱스를 기준으로 좌는 피봇보다 작은 값, 우는 피봇보다 큰값임.

			//pivot 인덱스 자리는 정리 되있기 때문에 나머지 값들을 정리해준다.

			quickSort(array, start, pivot-1, indexArray);//왼쪽

			quickSort(array, pivot+1, end, indexArray);//오른쪽

		}

		return;

	}
}
