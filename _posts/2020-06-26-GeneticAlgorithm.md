---
title:  "GeneticAlgorithm"
date:   2020-06-26 20:30:33 +0900
categories: algorithm
use_math: true
comment: true
---

# 유전알고리즘

사용한 데이터는 KOSIS 국가통계포털에서 

국제통계->국제기구 회원국별 통계->교통, 정보통신

->인터넷(OECD)->항목(인터넷 이용률, 초고속인터넷가입자(인구 100명당)), 시점(2018), 국가별(이스라엘, 일본, 캐나다, 미국, 칠레, 스위스, 뉴질랜드, 네덜란드를 제외한 31개국)

위 국가를 제외한 이유는 초고속인터넷가입자(인구100명당)이나 인터넷이용률이 수치가 있지 않아 제외하였다.

출처:

http://kosis.kr/statisticsList/statisticsListIndex.do?menuId=M_02_01_01&vwcd=MT_RTITLE&parmTabId=M_02_01_01#SelectStatsBoxDiv



이 자료를 기준으로 Data 클래스를 만들었다.

```java
public class Data {
	// 인터넷 이용률,  초고속 인터넷가입자(인구 100명당)
		public static double OECDinternet[]= //인터넷 이용률
				{99.0, 97.6, 97.1, 96.5, 95.9, 94.9, 92.1, 
				89.7, 89.4, 88.9, 88.7, 87.7, 86.1, 84.5, 
				83.6, 82.0, 80.7, 80.7, 79.7, 79.7, 77.5, 
				76.1, 74.7, 74.4, 73.0, 71.0, 65.8};
		public static String OECDname[]=  //인뎃스에 대응되는 국가
			{ "아이슬란드", "덴마크", "룩셈부르크", "노르웨이", "한국", "영국", "스웨덴",
				"독일", "에스토니아", "핀란드", "벨기에", "오스트리아", "스페인", "아일랜드", 
				"라트비아","프랑스", "체코", "슬로바키아", "리투아니아", "슬로베니아", "폴란드",
				"헝가리", "포르투갈", "이탈리아", "그리스", "터키", "멕시코"};
		
		public static double OECDhyperInternet[]= //초고속 인터넷가입자(인구 100명당)
			{40.6, 44.1, 37.1, 41.3, 41.6, 39.6, 39.1,
			41.1, 33.3, 31.5, 39.2, 28.4, 32.0, 29.7, 
			27.3, 44.8, 29.9, 27.7, 28.2, 29.5, 18.9, 
			31.7, 36.9, 28.0, 37.7, 16.3, 14.6};
}
```

이 자료를 기준으로 찍은 점들이 어떤 성질을 가진지 봐야한다. 점을 찍는 소스코드를 짜준다. 

참고한 자료: **beronicasun** 블로그  자바로 xy좌표에 점찍기 - 점의 크기

출처: http://blog.naver.com/PostView.nhn?blogId=beronicasun&logNo=90155784319&parentCategoryNo=&categoryNo=9&viewDate=&isShowPopularPosts=true&from=search

```java
package Data;

import java.awt.*;

import javax.swing.*;

import java.awt.geom.*;

 


public class PointGraph {

 public static void main(String[] arg) {

 MyFrame f = new MyFrame("Main frame");

 }

}

 

class MyFrame extends JFrame {

 MyFrame(String title) {

 super(title);

 setSize(700,700);

 setDefaultCloseOperation(EXIT_ON_CLOSE);

 makeUI();

 setVisible(true);

 }

 private void makeUI() {

 MyPanel p = new MyPanel();

 add(p, BorderLayout.CENTER);

 }

}


class MyPanel extends JPanel {

 protected void paintComponent(Graphics g) {


    Graphics2D g2=(Graphics2D)g;
 
    float dash0[] = {1,0f}; 
    float dash3[] = {3,3f}; 

    g2.translate(0, 0);         
   g2.setStroke(new BasicStroke(1,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,1,dash3,0));


    for (int i=-600; i<=600; i = i+20) {

    g2.draw(new Line2D.Float(-600, i, 600, i));     // x축과 평행선을 그린다.

    }
    for (int j=-600; j<=600; j = j+20) {

    g2.draw(new Line2D.Float(j, -600, j, 600));     // y축과 평행선을 그린다.


    }
 
 
 g2.setStroke(new BasicStroke(2,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,1,dash0,0));


   g2.draw(new Line2D.Float(-600, 0, 600, 0));     // x축을 그린다.
 
    g2.draw(new Line2D.Float(0, -600, 0, 600));     // y축을 그린다.
 

   g2.setColor(Color.RED);


   for ( int i=0, radius=2; i<Data.OECDname.length; i++ ) {  
	   
	   g2.fillOval((int)(Data.OECDhyperInternet[i]-10)*10, 600-(int)(Data.OECDinternet[i]-60)*10, radius*2, radius*2);
// 점을 찍는다. 자바는 좌표가 (0,0)기준으로 x가 늘어나면 우측으로 y가 늘어나면 아래로 내려간다. xy 좌표에서 (0,0)를 (0, 제일 아래 y값)으로 설정한다. 좌표를 정수로 해야해서 원래 값들을 10배해주고 (0,0)~(100,600) 점이 안찍히기 때문에 좌측최하단 영점을 (100,600)라 설정하고 x값은 그대로 대입 y값은 600에서 뺀다.
 // x축은 초고속인터넷이용자, y축은 인터넷이용률
	   }
 }

}

```



![점 찍은 그래프](C:\Users\pc1\Pictures\점 찍은 그래프.png)

데이터가 대략 선형적인 것 같기 때문에 이 자료를 표현하는 함수를 ax+b라고 한다.

함수가 정확한지 판단하기 위한 MSE를 
$$
MSE=\sum_{k=1}^n(Y_{k}-y_{k})^{2}
$$


Y는 k번째 원래 자료 값이고 y는 함수에 k번째 x를 넣은 함수값이다.

이거에 대한 소스코드를 짜면

```JAVA
public class MSE {
	public static double linearFuction(int a, int b, double x) {
		double result=(double)a*x+(double)b; //함수
		return result;
	}
	
	public static double value (int a, int b) { //mse
		double sum=0;  
		
		double absoul;
		
		
		for(int i=0; i<Data.OECDname.length; i++) { //실제값-함수값 제곱
			absoul=Data.OECDinternet[i]-linearFuction(a, b, Data.OECDhyperInternet[i]);
			
			sum=(absoul*absoul);
		}
		
		return sum;
	}
}
```



함수의 a와 b를 가지고 있는 생성자를 만든다.

```java
import java.util.Random;

public class LinearFuct {
	private int a; //x의 계수
	private int b; //상수항
	
	LinearFuct(){ //생성자

	}
	LinearFuct(int a, int b){
		this.a=a;
		this.b=b;
	}
	
	
	public void initA() { //랜덤 초기화
		Random r=new Random();
		this.a=r.nextInt(89);
		return;
	}
	
	public void initB() { //랜덤초기화
		Random r=new Random();
		this.b=r.nextInt(89);
		return;
	}
	
	public void getA(int a) { //a 삽입
		this.a=a;
		return;
	}
	
	public void getB(int b) { //b삽입
		this.b=b;
		return;
	}
	
	public int useA() { //a 사용
		return this.a;
	}
	
	public int useB() { //b 사용
		return this.b;
	}
	
	
}
```

최대기울기 구하는 소스코드(a와 b에 대한 정수의 범위를 구한다. 위에 까먹고 89넣음)

```
public class Gradient {
	public static double maxGrad;
	
	public static double maxHigh;
	
	public static void getMaxGrad(double gradient) {
		
		maxGrad=gradient;
		
		return;
	}
	
	public static void getMaxHigh(double high) {
		maxHigh=high;
		
		return;
	}
	
	public static void main(String[] args) {
		double[] gradient=new double[Data.OECDname.length];
		
		for(int i=0; i<Data.OECDname.length; i++) {
			gradient[i]=Data.OECDinternet[i]/Data.OECDhyperInternet[i];
		}
		
		getMaxGrad(gradient[0]);
		
		for(int i=1; i<Data.OECDname.length; i++) {
			if(gradient[i]>maxGrad) {
				getMaxGrad(gradient[i]);
			}
		}
		
		getMaxHigh(Data.OECDinternet[0]);
		
		for(int i=1; i<Data.OECDname.length; i++) {
			if(Data.OECDinternet[i]>maxHigh) {
				getMaxGrad(Data.OECDinternet[i]);
			}
		}
	}
}
```

유전 알고리즘 할시 선별할 소스코드

```java
public class Selection {
	public static void selection(LinearFuct[] arr, LinearFuct[] bestArr) {
		double[] mse=new double[10]; 
		int[] indexArray=new int[10];
		
		for(int i=0; i<10; i++) { 
			indexArray[i]=i;
			mse[i]=MSE.value(arr[i].useA(), arr[i].useB());	
		}
		
		quickSort(mse, 0, 9, indexArray);//크기대로 인덱스만 정렬
		
		for(int i=0; i<4; i++) { //인덱스 기준으로 제일 우수한 4개 선별
			bestArr[i]=arr[indexArray[i]];
		}
		
		return;
	
	}
    //퀵정렬
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

```

교차 연산

```java
import java.util.Random;

public class CrossOver {
	public static void crossover(LinearFuct[] arr, LinearFuct[] bestArr) {
		Random r=new Random();
		int cross1;
		int cross2;
		
		for(int i=0; i<5; i++) { //선발한 4개로 자식 10개 생성
			cross1=r.nextInt(4);
			cross2=r.nextInt(4);
			
			while(cross1==cross2) { //똑같은 인덱스 뽑히면 다시뽑음
				cross2=r.nextInt(4);
			}
			// 서로 a와 b 교환
			arr[2*i]=new LinearFuct(bestArr[cross1].useA(), bestArr[cross2].useB());
			arr[2*i+1]=new LinearFuct(bestArr[cross2].useA(), bestArr[cross1].useB());
		}
		
		return;
	}

}
```

돌연변이 연산

```java
import java.util.Random;

public class Mutation {
	public static void mutation(LinearFuct arr[]) {
		Random r=new Random();
		int p2=r.nextInt(3);
		
		for(int i=0; i<arr.length; i++) {
			double p1=(double)1/(double)10; //10분의 1확률로
			if(r.nextDouble()<p1) { //2분의 1확률로 a와 b 돌연변이 결정
				if(p2==0) {
					arr[i].initA();  // a랜덤돌림
				}
				else {
					arr[i].initB();//b 랜덤돌림
				}
			}
				
		}
		return;
	}
}

```

그래프 그릴 소스코드

```java
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

class MyFrame extends JFrame {

 MyFrame(String title, LinearFuct bestFit) { //생성자에 최적의해 받기

 super(title);

 setSize(700,700);

 setDefaultCloseOperation(EXIT_ON_CLOSE);

 makeUI(bestFit); //최적의해 받기

 setVisible(true);

 }

 private void makeUI(LinearFuct bestFit) {//최적의해 받기

 MyPanel p = new MyPanel(bestFit);//생성자에 최적의해 받기

 add(p, BorderLayout.CENTER);

 }

}


class MyPanel extends JPanel {
	LinearFuct bestFit;
	
	public MyPanel(LinearFuct bestFit) {//생성자에 최적의해 받기
		this.bestFit=bestFit;
	}
	
 protected void paintComponent(Graphics g) {


    Graphics2D g2=(Graphics2D)g;
 
    float dash0[] = {1,0f}; 
    float dash3[] = {3,3f}; 

    g2.translate(0, 0); 
 

   g2.setStroke(new BasicStroke(1,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,1,dash3,0));


    for (int i=-600; i<=600; i = i+20) {

    g2.draw(new Line2D.Float(-600, i, 600, i));     // x축과 평행선을 그린다.

    }
    for (int j=-600; j<=600; j = j+20) {

    g2.draw(new Line2D.Float(j, -600, j, 600));     // y축과 평행선을 그린다.


    }
 
 
 g2.setStroke(new BasicStroke(2,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,1,dash0,0));


   g2.draw(new Line2D.Float(-600, 0, 600, 0));     // x축을 그린다.
 
    g2.draw(new Line2D.Float(0, -600, 0, 600));     // y축을 그린다.
 

   g2.setColor(Color.RED);


   for ( int i=0, radius=2; i<Data.OECDname.length; i++ ) {  
	   
	   g2.fillOval((int)(Data.OECDhyperInternet[i]-10)*10, 600-(int)(Data.OECDinternet[i]-60)*10, radius*2, radius*2);

	   }
   
   int a=bestFit.useA(); //최적의해 a받기
   int b=bestFit.useB(); //최적의해 b받기
   
   int dx, dy; //이을 최종 x, y 좌표
   int sy=a*10+b; //시작할 y좌표 0점의 좌표가 (10,60)의미하기 때문에 10 대입
   
   sy=600-(sy-60)*10; //자바는 y가 반대여서 600빼줌 그리고 여기서 10곱하기
   
   dx=((120-b)/a-10)*10; //y끝점에 있을시 x구하기
   dy=(1200-(a*70+b)*10);//x끝점에 있을시 y구하기
   
   g2.setColor(Color.BLUE);//그래프 색깔 블루
   
   if(dx>600)
	   g2.draw(new Line2D.Float(0, sy, 600, dy)); //x가 600보다 크면 y기준으로 삼음
	else
		g2.draw(new Line2D.Float(0, sy, dx, 0)); //도착점 x기준으로 선긋기
	
 

 }
}

```

Main Class

```java
public class Main {
	public static void main(String[] args) {
		LinearFuct[] arr=new LinearFuct[10]; //선발 세대
		LinearFuct[] bestArr=new LinearFuct[4]; //우수한 자손
		LinearFuct bestFit=new LinearFuct(1000, 1000); //걍 무한값 걍 큰값 1000넣음 
		int n=2; //2번하기
		
		
		for(int i=0; i < arr.length; i++) { //10 뽑기
			arr[i]=new LinearFuct();
			arr[i].initA();
			arr[i].initB();
			
			if(i!=0) {
				for(int j=0; j<i; j++) {
					if((arr[i].useA()==arr[j].useA())&&(arr[i].useB()==arr[j].useB())) { //같은게 나오면 다시 뽑는다.
						arr[i].initA();
						arr[i].initB();
						
						j=0;
					}			
				}
			}
			
		}
		Selection.selection(arr, bestArr);//우수한 4개 뽑기
		
		for(int i=0; i < arr.length; i++) { //10개 mse 출력
			System.out.print(arr[i].useA()+"x+"+arr[i].useB()+" MSE:"
					+MSE.value(arr[i].useA(), arr[i].useB())+" ");
		}
		System.out.println();
		System.out.println("우수한 자손들 선발");
		for(int i=0; i < bestArr.length; i++) {
			System.out.print(bestArr[i].useA()+"x+"+bestArr[i].useB()+" MSE:"
					+MSE.value(bestArr[i].useA(), bestArr[i].useB())+" "); //4개 mse 출력
		}
		System.out.println();
		
		if(MSE.value(bestFit.useA(), bestFit.useB())>MSE.value(bestArr[0].useA(),bestArr[0].useB())){
			 bestFit=bestArr[0];   //지금 세대의 mse가 최적의해의 mse보다 작으면 교체
			}
			
			System.out.println(0+"세대 최적의 해 "+bestFit.useA()+","+bestFit.useB()+" MSE:"
					+MSE.value(bestFit.useA(), bestFit.useB()));
		//정확히는 지금 세대까지의 최적의 해	
		
		for(int j=0; j<n; j++) {
		
			
			CrossOver.crossover(arr, bestArr);
			System.out.println();
			System.out.println("교차연산");
			for(int i=0; i < arr.length; i++) {
				System.out.print(arr[i].useA()+"x+"+arr[i].useB()+" MSE:"
						+MSE.value(arr[i].useA(), arr[i].useB())+" ");
			}
			System.out.println();
			System.out.println();
			
			
			Mutation.mutation(arr);
			System.out.println("돌연변이");
			for(int i=0; i < arr.length; i++) {
				System.out.print(arr[i].useA()+"x+"+arr[i].useB()+" MSE:"
						+MSE.value(arr[i].useA(), arr[i].useB())+" ");
			}
			
			Selection.selection(arr, bestArr);
			
			for(int i=0; i < arr.length; i++) {
				System.out.print(arr[i].useA()+"x+"+arr[i].useB()+" MSE:"
						+MSE.value(arr[i].useA(), arr[i].useB())+" ");
			}
			System.out.println();
			System.out.println("우수한 자손들 선발");
			for(int i=0; i < bestArr.length; i++) {
				System.out.print(bestArr[i].useA()+"x+"+bestArr[i].useB()+" MSE:"
						+MSE.value(bestArr[i].useA(), bestArr[i].useB())+" ");
			}
			System.out.println();
			
			if(MSE.value(bestFit.useA(), bestFit.useB())>MSE.value(bestArr[0].useA(),bestArr[0].useB())){
				 bestFit=bestArr[0];
				}
				
			System.out.println();
			
			System.out.println((j+1)+"세대 최적의 해 "+bestFit.useA()+","+bestFit.useB()+" MSE:"
					+MSE.value(bestFit.useA(), bestFit.useB()));
				
		
		}
	//그래프 출력		
		MyFrame f = new MyFrame("Main frame", bestFit);
	}
}
```

결과값

![KakaoTalk_20200626_202420662](C:\Users\pc1\Documents\카카오톡 받은 파일\KakaoTalk_20200626_202420662.png)

```
88x+19 MSE:1532644.0 56x+14 MSE:586449.6400000001 69x+25 MSE:934315.5600000003 13x+61 MSE:34225.0 59x+42 MSE:701573.76 16x+20 MSE:35268.840000000004 62x+39 MSE:771586.5599999999 10x+59 MSE:19376.639999999996 60x+59 MSE:755508.6400000001 1x+7 MSE:1953.6399999999996 
우수한 자손들 선발
1x+7 MSE:1953.6399999999996 10x+59 MSE:19376.639999999996 13x+61 MSE:34225.0 16x+20 MSE:35268.840000000004 
0세대 최적의 해 1,7 MSE:1953.6399999999996

교차연산
13x+7 MSE:17161.0 1x+61 MSE:96.03999999999995 13x+59 MSE:33489.0 10x+61 MSE:19937.439999999995 10x+20 MSE:10040.04 16x+59 MSE:51438.240000000005 16x+59 MSE:51438.240000000005 10x+20 MSE:10040.04 13x+59 MSE:33489.0 10x+61 MSE:19937.439999999995 

돌연변이
13x+7 MSE:17161.0 1x+61 MSE:96.03999999999995 13x+59 MSE:33489.0 10x+61 MSE:19937.439999999995 10x+20 MSE:10040.04 16x+59 MSE:51438.240000000005 16x+59 MSE:51438.240000000005 10x+20 MSE:10040.04 13x+17 MSE:19881.0 10x+61 MSE:19937.439999999995 13x+7 MSE:17161.0 1x+61 MSE:96.03999999999995 13x+59 MSE:33489.0 10x+61 MSE:19937.439999999995 10x+20 MSE:10040.04 16x+59 MSE:51438.240000000005 16x+59 MSE:51438.240000000005 10x+20 MSE:10040.04 13x+17 MSE:19881.0 10x+61 MSE:19937.439999999995 
우수한 자손들 선발
1x+61 MSE:96.03999999999995 10x+20 MSE:10040.04 10x+20 MSE:10040.04 13x+7 MSE:17161.0 

1세대 최적의 해 1,61 MSE:96.03999999999995

교차연산
10x+61 MSE:19937.439999999995 1x+20 MSE:973.4399999999997 1x+20 MSE:973.4399999999997 10x+61 MSE:19937.439999999995 10x+20 MSE:10040.04 10x+20 MSE:10040.04 10x+7 MSE:7603.84 13x+20 MSE:20736.0 13x+20 MSE:20736.0 10x+7 MSE:7603.84 

돌연변이
10x+61 MSE:19937.439999999995 1x+20 MSE:973.4399999999997 1x+20 MSE:973.4399999999997 10x+61 MSE:19937.439999999995 10x+20 MSE:10040.04 10x+20 MSE:10040.04 10x+7 MSE:7603.84 13x+20 MSE:20736.0 13x+20 MSE:20736.0 10x+7 MSE:7603.84 10x+61 MSE:19937.439999999995 1x+20 MSE:973.4399999999997 1x+20 MSE:973.4399999999997 10x+61 MSE:19937.439999999995 10x+20 MSE:10040.04 10x+20 MSE:10040.04 10x+7 MSE:7603.84 13x+20 MSE:20736.0 13x+20 MSE:20736.0 10x+7 MSE:7603.84 
우수한 자손들 선발
1x+20 MSE:973.4399999999997 1x+20 MSE:973.4399999999997 10x+7 MSE:7603.84 10x+7 MSE:7603.84 

2세대 최적의 해 1,61 MSE:96.03999999999995
```



![KakaoTalk_20200626_202420580](C:\Users\pc1\Documents\카카오톡 받은 파일\KakaoTalk_20200626_202420580.png)

```

15x+62 MSE:46311.03999999999 51x+43 MSE:520995.2400000001 44x+59 MSE:403987.36000000004 51x+20 MSE:488321.4400000001 72x+0 MSE:971013.1600000001 68x+70 MSE:994009.0 32x+54 MSE:207389.16000000003 80x+81 MSE:1399962.2400000002 62x+59 MSE:807122.5599999999 52x+20 MSE:508939.55999999994 
우수한 자손들 선발
15x+62 MSE:46311.03999999999 32x+54 MSE:207389.16000000003 44x+59 MSE:403987.36000000004 51x+20 MSE:488321.4400000001 
0세대 최적의 해 15,62 MSE:46311.03999999999

교차연산
15x+20 MSE:29998.239999999994 51x+62 MSE:548784.6400000001 32x+59 MSE:211968.16000000003 44x+54 MSE:397656.36000000004 44x+54 MSE:397656.36000000004 32x+59 MSE:211968.16000000003 51x+54 MSE:536995.8400000001 32x+20 MSE:177577.96 51x+62 MSE:548784.6400000001 15x+20 MSE:29998.239999999994 

돌연변이
15x+86 MSE:57216.63999999999 51x+62 MSE:548784.6400000001 32x+59 MSE:211968.16000000003 44x+54 MSE:397656.36000000004 44x+54 MSE:397656.36000000004 32x+59 MSE:211968.16000000003 51x+54 MSE:536995.8400000001 32x+20 MSE:177577.96 51x+62 MSE:548784.6400000001 15x+20 MSE:29998.239999999994 15x+86 MSE:57216.63999999999 51x+62 MSE:548784.6400000001 32x+59 MSE:211968.16000000003 44x+54 MSE:397656.36000000004 44x+54 MSE:397656.36000000004 32x+59 MSE:211968.16000000003 51x+54 MSE:536995.8400000001 32x+20 MSE:177577.96 51x+62 MSE:548784.6400000001 15x+20 MSE:29998.239999999994 
우수한 자손들 선발
15x+20 MSE:29998.239999999994 15x+86 MSE:57216.63999999999 32x+20 MSE:177577.96 32x+59 MSE:211968.16000000003 

1세대 최적의 해 15,20 MSE:29998.239999999994

교차연산
32x+86 MSE:237558.76000000004 15x+20 MSE:29998.239999999994 32x+20 MSE:177577.96 32x+59 MSE:211968.16000000003 15x+20 MSE:29998.239999999994 32x+86 MSE:237558.76000000004 32x+20 MSE:177577.96 15x+59 MSE:45028.84 15x+86 MSE:57216.63999999999 15x+20 MSE:29998.239999999994 

돌연변이
32x+42 MSE:196603.55999999997 15x+20 MSE:29998.239999999994 32x+20 MSE:177577.96 32x+59 MSE:211968.16000000003 15x+20 MSE:29998.239999999994 32x+64 MSE:216597.16000000003 32x+20 MSE:177577.96 15x+59 MSE:45028.84 15x+49 MSE:40884.84 15x+23 MSE:31046.439999999995 32x+42 MSE:196603.55999999997 15x+20 MSE:29998.239999999994 32x+20 MSE:177577.96 32x+59 MSE:211968.16000000003 15x+20 MSE:29998.239999999994 32x+64 MSE:216597.16000000003 32x+20 MSE:177577.96 15x+59 MSE:45028.84 15x+49 MSE:40884.84 15x+23 MSE:31046.439999999995 
우수한 자손들 선발
15x+20 MSE:29998.239999999994 15x+20 MSE:29998.239999999994 15x+23 MSE:31046.439999999995 15x+49 MSE:40884.84 

2세대 최적의 해 15,20 MSE:29998.239999999994
```





![KakaoTalk_20200626_202420471](C:\Users\pc1\Documents\카카오톡 받은 파일\KakaoTalk_20200626_202420471.png)

```
66x+30 MSE:860812.8400000001 33x+83 MSE:249000.99999999994 53x+78 MSE:617796.0 63x+62 MSE:839056.0 0x+76 MSE:104.04000000000006 79x+60 MSE:1316985.7599999998 56x+67 MSE:670433.4400000001 61x+28 MSE:727267.8400000001 3x+37 MSE:225.0 26x+53 MSE:134542.23999999996 
우수한 자손들 선발
0x+76 MSE:104.04000000000006 3x+37 MSE:225.0 26x+53 MSE:134542.23999999996 33x+83 MSE:249000.99999999994 
0세대 최적의 해 0,76 MSE:104.04000000000006

교차연산
33x+53 MSE:219960.99999999994 26x+83 MSE:157450.23999999996 26x+37 MSE:123060.63999999997 3x+53 MSE:961.0 3x+76 MSE:2916.0 0x+37 MSE:829.4399999999998 0x+37 MSE:829.4399999999998 3x+76 MSE:2916.0 3x+83 MSE:3721.0 33x+37 MSE:205208.99999999994 

돌연변이
33x+53 MSE:219960.99999999994 26x+83 MSE:157450.23999999996 26x+37 MSE:123060.63999999997 3x+53 MSE:961.0 3x+76 MSE:2916.0 0x+37 MSE:829.4399999999998 0x+37 MSE:829.4399999999998 3x+76 MSE:2916.0 3x+83 MSE:3721.0 33x+37 MSE:205208.99999999994 33x+53 MSE:219960.99999999994 26x+83 MSE:157450.23999999996 26x+37 MSE:123060.63999999997 3x+53 MSE:961.0 3x+76 MSE:2916.0 0x+37 MSE:829.4399999999998 0x+37 MSE:829.4399999999998 3x+76 MSE:2916.0 3x+83 MSE:3721.0 33x+37 MSE:205208.99999999994 
우수한 자손들 선발
0x+37 MSE:829.4399999999998 0x+37 MSE:829.4399999999998 3x+53 MSE:961.0 3x+76 MSE:2916.0 

1세대 최적의 해 0,76 MSE:104.04000000000006

교차연산
3x+37 MSE:225.0 0x+53 MSE:163.83999999999992 3x+53 MSE:961.0 3x+76 MSE:2916.0 0x+37 MSE:829.4399999999998 0x+37 MSE:829.4399999999998 3x+37 MSE:225.0 0x+76 MSE:104.04000000000006 0x+53 MSE:163.83999999999992 3x+37 MSE:225.0 

돌연변이
3x+29 MSE:49.0 0x+53 MSE:163.83999999999992 3x+87 MSE:4225.000000000002 3x+76 MSE:2916.0 0x+37 MSE:829.4399999999998 0x+37 MSE:829.4399999999998 3x+37 MSE:225.0 0x+76 MSE:104.04000000000006 0x+53 MSE:163.83999999999992 3x+37 MSE:225.0 3x+29 MSE:49.0 0x+53 MSE:163.83999999999992 3x+87 MSE:4225.000000000002 3x+76 MSE:2916.0 0x+37 MSE:829.4399999999998 0x+37 MSE:829.4399999999998 3x+37 MSE:225.0 0x+76 MSE:104.04000000000006 0x+53 MSE:163.83999999999992 3x+37 MSE:225.0 
우수한 자손들 선발
3x+29 MSE:49.0 0x+76 MSE:104.04000000000006 0x+53 MSE:163.83999999999992 0x+53 MSE:163.83999999999992 

2세대 최적의 해 3,29 MSE:49.0
```

2번째 경우 좌표평면 밖에 그려져서 안나타남

n=2인 경우에만 돌아가서 n=2 경우만 했습니다. 퀵정렬이 문제인지 selection이 문제인지 자꾸 거기서 안넘어가져서 n=2 경우 2세대 까지 구한것만 올렸습니다.



참고자료:

데이터 출처

http://kosis.kr/statisticsList/statisticsListIndex.do?menuId=M_02_01_01&vwcd=MT_RTITLE&parmTabId=M_02_01_01#SelectStatsBoxDiv

점 그리기

http://blog.naver.com/PostView.nhn?blogId=beronicasun&logNo=90155784319&parentCategoryNo=&categoryNo=9&viewDate=&isShowPopularPosts=true&from=search

유전알고리즘

https://github.com/hxxn85/Genetic-Algorithm