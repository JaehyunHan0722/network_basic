package thread.basic;

class AlphaThread extends Thread{
	
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

class DigitThread extends Thread{
	
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

public class ThreadTest02 {

	public static void main(String[] args) {
		System.out.println("==========프로그램 시작===========");
		AlphaThread test1 = new AlphaThread();
		DigitThread test2 = new DigitThread();
		test1.start();
		test2.start();
//		try {
//			Thread.sleep(500);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		System.out.println("==========프로그램 종료===========");
	}

}
