package thread.basic;


class AlphaThread02 implements Runnable{

	@Override
	public void run() {
		for(int i=65; i<=90; i++) {			
			System.out.print((char)i+"\t");
			if(i%10 == 0) {
				System.out.println();
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

class DigitThread02 implements Runnable{

	@Override
	public void run() {
		for(int i=1; i<=100; i++) {
			System.out.print(i+"\t");
			if(i%10 == 0) {
				System.out.println();
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

public class RunnableTest02 {


	public static void main(String[] args) {
		System.out.println("==========프로그램 시작===========");
		AlphaThread02 test1 = new AlphaThread02();
		DigitThread02 test2 = new DigitThread02();
		Thread obj1 = new Thread(test1);
		Thread obj2 = new Thread(test2);
		obj1.start();
		obj2.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("==========프로그램 종료===========");

	}

}
