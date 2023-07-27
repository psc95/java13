/* 또 다른 멀티스레드 구현방법)
 *  1.Runnable인터페이스를 구현 상속받는다. 이 방법은 다중 상속을 받을 수 있다는 장점이 있다. 하지만 이 인터페이스를 구현
 *  상속받은 자손으로 멀티스레드를 시작하는 start()메서드를 바로 호출할 수 없기 때문에 Thread생성자 인자값으로 자손클래스
 *  객체를 전달해서 또 한번더 객체를 생성해서 start()메서드를 호출해야 한다.
 *  
 *  2.부모 인터페이스의 run() 추상메서드를 오버라이딩을 해서 쓰레드 문장을 구현한다.
 */
class Thread04 implements Runnable{

	@Override
	public void run() {
		for(int k = 1; k <= 5; k++) {
			for(int a = 1; a < 100000000; a++);
			System.out.println(Thread.currentThread().getName() + " : "+k);
		}
	}//쓰레드 문장 구현
	
}
public class ThreadTest04 {
	public static void main(String[] args) {
		
		Thread04 t01 = new Thread04();
		Thread th01 = new Thread(t01,"첫번째 쓰레드");
		th01.start();//멀티스레드 시작
		
		Thread04 t02 = new Thread04();
		Thread th02 = new Thread(t02,"두번째 쓰레드");
		th02.start();
		
	}
}
