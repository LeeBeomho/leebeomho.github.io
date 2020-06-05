---


layout: single
title:  "Bin"
date:   2020-06-06 01:30:33 +0900
categories: algorithm
use_math: true
comment: true
---

NextFit 클래스를 수정

```java
import java.util.ArrayList;

public class NextFit implements Fit{
    @Override
    public void fit(ArrayList<Bin> arr, Item item) {
    	 
    	if(arr.size()==0) {
    		Bin b = new Bin();
            b.update(item);
            arr.add(b);
            return;
    	}
    	else {
    		 Bin bin = arr.get(arr.size()-1);
             if(bin.check(item)) {
                 bin.update(item);
                 return;
             }
    		
    	}

         Bin b = new Bin();
         b.update(item);
         arr.add(b);
    }
}

```

BestFit 클래스를 생성

```java
import java.util.ArrayList;

public class BestFit implements Fit{
    @Override
    public void fit(ArrayList<Bin> arr, Item item) {
    	  int[] remainCapaArray=new int[arr.size()];
    	  int[] indexArray=new int[arr.size()];
    	  
    	  for (int i=0; i<arr.size(); i++) {
    		  Bin a = arr.get(i);
    		  remainCapaArray[i]=a.remainCapacity;
    		  indexArray[i]=i;
    	  }
    	  
    	  if(arr.size()>0)
    		  QuickSort.quickSort(remainCapaArray, 0, arr.size()-1, indexArray);
    	  
    	
    	  for (int i=0; i<arr.size(); i++) {
              Bin bin = arr.get(indexArray[i]);
              if(bin.check(item)) {
                  bin.update(item);
                  return;
              }
          }

          Bin b = new Bin();
          b.update(item);
          arr.add(b);
          
    }
}
```

BestFit에 쓸 QuickSort 클래스를 생성

```java

public class QuickSort {//p61
	public static void main(String[] args) {
		return;
	}

	public static void quickSort(int[] array, int start, int end, int[] indexArray) {
		
		
		int temp; //교환을 위한 임시변수
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
```

WorstFit 클래스 생성

```java
import java.util.ArrayList;

public class WorstFit implements Fit{
	 @Override
	    public void fit(ArrayList<Bin> arr, Item item) {
	    	  int[] remainCapaArray=new int[arr.size()];
	    	  int[] indexArray=new int[arr.size()];
	    	  
	    	  for (int i=0; i<arr.size(); i++) {
	    		  Bin a = arr.get(i);
	    		  remainCapaArray[i]=a.remainCapacity;
	    		  indexArray[i]=i;
	    	  }
	    	  
	    	  if(arr.size()>0)
	    		  QuickSort.reverseQuickSort(remainCapaArray, 0, arr.size()-1, indexArray);
	    	  
	    	
	    	  for (int i=0; i<arr.size(); i++) {
	              Bin bin = arr.get(indexArray[i]);
	              if(bin.check(item)) {
	                  bin.update(item);
	                  return;
	              }
	          }

	          Bin b = new Bin();
	          b.update(item);
	          arr.add(b);
	          
	    }
}

```

Main 클래스 변경

```
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[] items = {7, 5, 6, 4, 2, 3, 7, 5};
        ArrayList<Bin> arr = new ArrayList<>();

        Fit ff = new FirstFit();
        for (int i=0; i<items.length; i++) {
            ff.fit(arr, new Item(items[i]));
        }
        
        ArrayList<Bin> arr2 = new ArrayList<>();
        
        Fit lf = new NextFit();
        for (int i=0; i<items.length; i++) {
            lf.fit(arr2, new Item(items[i]));
        }
        
        ArrayList<Bin> arr3 = new ArrayList<>();
        
        Fit bf = new BestFit();
        for (int i=0; i<items.length; i++) {
            bf.fit(arr3, new Item(items[i]));
        }
        
        ArrayList<Bin> arr4 = new ArrayList<>();
        
        //결과 출력
        
        for (int i=0; i<arr.size(); i++) {
        	System.out.println(arr.get(i).toString());
        }
        
        System.out.println(arr.size());
        
        for (int i=0; i<arr2.size(); i++) {
        	System.out.println(arr2.get(i).toString());
        }
        
        System.out.println(arr2.size());
        
        for (int i=0; i<arr3.size(); i++) {
        	System.out.println(arr3.get(i).toString());
        }
        
        System.out.println(arr3.size());
    }
}

```



결과출력



```
Bin{capacity=10, currentCapacity=9, remainCapacity=1}
Bin{capacity=10, currentCapacity=9, remainCapacity=1}
Bin{capacity=10, currentCapacity=9, remainCapacity=1}
Bin{capacity=10, currentCapacity=7, remainCapacity=3}
Bin{capacity=10, currentCapacity=5, remainCapacity=5}
5
Bin{capacity=10, currentCapacity=7, remainCapacity=3}
Bin{capacity=10, currentCapacity=5, remainCapacity=5}
Bin{capacity=10, currentCapacity=10, remainCapacity=0}
Bin{capacity=10, currentCapacity=5, remainCapacity=5}
Bin{capacity=10, currentCapacity=7, remainCapacity=3}
Bin{capacity=10, currentCapacity=5, remainCapacity=5}
6
Bin{capacity=10, currentCapacity=9, remainCapacity=1}
Bin{capacity=10, currentCapacity=8, remainCapacity=2}
Bin{capacity=10, currentCapacity=10, remainCapacity=0}
Bin{capacity=10, currentCapacity=7, remainCapacity=3}
Bin{capacity=10, currentCapacity=5, remainCapacity=5}
5
```

WorstFit은 BestFit과 QuickSort를 이용해서 만들었는데 결과가 자꾸 출력이 안되어 뺐습니다. reverseQuickSort 메소드는 다른걸 해봤을 때 잘만되는데 왜 안되는지 모르겠습니다.

![bin](\assets\bin.png)