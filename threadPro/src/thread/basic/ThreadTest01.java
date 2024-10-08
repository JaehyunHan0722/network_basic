package thread.basic;

class ThreadDemo01 extends Thread{
	
	ThreadDemo01(String name){
		super(name);
	};
	
	@Override
	public void run() {
		//1부터 20까지 출력하는 코드
		for(int i=1; i<=20; i++) {
			System.out.print(+i+"("+getName()+") ");
			if(i%5 == 0) {
				System.out.println();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

public class ThreadTest01 {

	public static void main(String[] args) {
		System.out.println("==========프로그램 시작===========");
		
		ThreadDemo01 t1 = new ThreadDemo01("t1");
		ThreadDemo01 t2 = new ThreadDemo01("t2");
		t1.start();
		t2.start();
		for(int i=1; i<=20; i++) {
			System.out.print("main:"+i+" ");
			if(i%5 == 0) {
				System.out.println();
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("==========프로그램 종료===========");
	}

}
