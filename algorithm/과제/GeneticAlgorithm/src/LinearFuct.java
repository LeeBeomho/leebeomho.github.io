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
