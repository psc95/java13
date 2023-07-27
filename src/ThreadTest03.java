/* 이 소스는 멀티스레드 프로그램은 아니고 흉내를 낸 단일 프로그램이다. 항상 일률적으로 첫번째 스레드가 모두 실행되고,
 * 그 다음 두번째 스레드가 실행된다.
 */
class Thread03{
	String name;
	
	Thread03(){}
	
	Thread03(String name){
		this.name = name;
	}
	
	public void start() {
		run();//run()메서드 호출
	}
	
	public void run() {
		for(int k = 1; k <= 5; k++) {
			for(int a = 1; a < 1000000000; a++);
			System.out.println(name + " : "+k);
		}
	}
}
public class ThreadTest03 {
	public static void main(String[] args) {
		Thread03 th01 = new Thread03("첫번째 스레드");
		Thread03 th02 = new Thread03("두번째 스레드");
		
		th01.start();
		th02.start();
	}
}
