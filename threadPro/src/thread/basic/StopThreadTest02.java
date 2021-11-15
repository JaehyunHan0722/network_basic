package thread.basic;

//

class StopThread02 implements Runnable{
	public void run() {
		//Thread.curruntThread()는 현재 실행중인 쓰레드 객체를 구함
		try {
			while(!Thread.currentThread().isInterrupted()) {
			System.out.println("쓰레드 실행중~~~");
			
			Thread.sleep(1000);
			} 
		}catch (InterruptedException e) {
			e.printStackTrace();
			}finally {
				System.out.println("현재 쓰레드 종료");
			}
		
		System.out.println("현재상태: 종료상태로 들어감");
	}
	//쓰레드의 상태를 조절할 수 있도록 변수의 값을 변경하는 메소드
	
}

public class StopThreadTest02 {

	public static void main(String[] args) {
		System.out.println("==============MAIN 쓰레드 시작==============");
		Thread t1 = new Thread(new StopThread02());
		t1.start();
		System.out.println("쓰레드의 이름: "+t1.getName());
		System.out.println("쓰레드의 현재 인터럽트 상태: "+t1.isInterrupted());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.interrupt();
		System.out.println("==============MAIN 쓰레드 종료==============");
	}

}
