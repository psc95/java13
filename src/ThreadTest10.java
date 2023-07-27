import javax.swing.JOptionPane;

//동시 작업이 이루어지는 멀티 쓰레드 프로그램이 된다.
class Thread10 extends Thread{

	@Override
	public void run() {
//		String cityName = JOptionPane.showInputDialog("도시 이름을 입력하세요!");
//		System.out.println("도시이름 : "+cityName);
		for(int i = 10; i >= 1; i--) {
			System.out.println(i);		
			try {
				Thread.sleep(1000);//1초간 잠시 일시 정지
			}catch(InterruptedException ie) {}
		}//for end
	}
	
}
public class ThreadTest10 {
	public static void main(String[] args) {
		/* 문제)10부터 1까지 1초 간격으로 카운터 하는 멀티스레드 프로그램을 만들어 보자.
		 * 그러면 10부터 1까지 카운터 하는 중간에 도시이름이 출력되는 동시 작업이 이루어진다.개발자
		 * 테스트까지 해보자.
		 */
		Thread10 th = new Thread10();
		th.start();
		
		String cityName = JOptionPane.showInputDialog("도시 이름을 입력하세요!");
		System.out.println("도시이름 : "+cityName);
		
//		Thread10 th2 = new Thread10();
//		th2.start();
	}
}
