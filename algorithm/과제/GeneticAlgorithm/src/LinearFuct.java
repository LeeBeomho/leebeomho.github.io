import java.util.Random;

public class LinearFuct {
	private int a; //x�� ���
	private int b; //�����
	
	LinearFuct(){ //������

	}
	LinearFuct(int a, int b){
		this.a=a;
		this.b=b;
	}
	
	
	public void initA() { //���� �ʱ�ȭ
		Random r=new Random();
		this.a=r.nextInt(89);
		return;
	}
	
	public void initB() { //�����ʱ�ȭ
		Random r=new Random();
		this.b=r.nextInt(89);
		return;
	}
	
	public void getA(int a) { //a ����
		this.a=a;
		return;
	}
	
	public void getB(int b) { //b����
		this.b=b;
		return;
	}
	
	public int useA() { //a ���
		return this.a;
	}
	
	public int useB() { //b ���
		return this.b;
	}
	
	
}
