/* Thread의 스케쥴링 메서드에서 해당 스레드를 일시정지 시키는 suspend()메서드, suspend()에 의해서 일시 정지된 스레드를
 * 다시 깨워서 실행시키는 resume()메서드,해당 스레드를 중지시키는 stop()메서드,스레드를 잠시 쉬게 하는 sleep()
 * 메서드에 대해서 실습한다.
 */

class Thread13 implements Runnable{

	@Override
	public void run() {
		while(true) {
			System.out.println(Thread.currentThread().getName());//현재 실행중인 스레드 이름을 반환
			try {
				Thread.sleep(1000);//1초간 일시 정지
			}catch(InterruptedException ie) {}
		}//while
	}//run()
}
public class ThreadTest13 {
	public static void main(String[] args) {
		Thread13 th = new Thread13();
		Thread th01 = new Thread(th,"#");
		Thread th02 = new Thread(th,"##");
		Thread th03 = new Thread(th,"###");
		
		th01.start(); th02.start(); th03.start();//3개 스레드 시작
		
		 try {
			 Thread.sleep(2000);//2초가 일시 정지
			 th01.suspend();//th01 쓰레드 일시 정지
			 Thread.sleep(2000);
			 th02.suspend();
			 Thread.sleep(3000);
			 th01.resume();//suspend()에 의해서 일시 정지된 th01스레드를 다시 동작하게 한다.
			 Thread.sleep(3000);
			 th01.stop();//첫번째 스레드 중지
			 th02.stop();
			 Thread.sleep(2000);
			 th03.stop();
		 }catch(InterruptedException ie) {}
	}
}
