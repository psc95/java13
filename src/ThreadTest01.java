/* 멀티쓰레드란?
 *  1.멀티쓰(스)레드는 하나의 프로그램내에서 여러개의 작은 작업 단위로 나누어서 교대로 실행하는 것을 말한다.
 *  
 *  멀티 쓰레드 구현법)
 *  첫번째,Thread클래스를 상속받는다. 클래스를 상속받기 때문에 단일상속만 가능하다.이 클래스를 상속받은 자손클래스로 객체를
 *  생성한 다음 start()메서드를 호출하면 실행대기 상태에 있다가 자기 차례가 되면 run()메서드를 자동 호출해서 스레드 구현상태
 *  즉 runnable상태가 된다.
 *  run()메서드는 명시적인 코드로 호출하지 않는다.
 *  
 *  두번째,멀티스레드를 구현하기 위해서는 부모의 run()메서드를 오버라이딩을 해서 스레드 문장을 구현한다.
 */
class Thread01 extends Thread{
	Thread01(String name){
		super(name);//부모클래스 오버로딩 된 생성자를 호출하면서 스레드 이름을 반환
	}

	@Override
	public void run() {
		for(int k = 1; k <= 5; k++) {
			for(int a = 1; a < 10000000; a++); //스레드가 교대 작업을 할 시간적 여유를 두기위해 ;사용
			System.out.println(getName() + " : "+ k);//getName()메서드로 스레드 이름을 반환
		}
	}//스레드 문장 구현
}
public class ThreadTest01{
	public static void main(String[] args) {
		Thread01 th01 = new Thread01("첫번째 스레드");
		Thread01 th02 = new Thread01("두번째 스레드");
		
		th01.start();//스레드 시작
		th02.start();
	}
}
