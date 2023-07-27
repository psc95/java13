import javax.swing.JOptionPane;

/* 해당 스레드의 인터럽트를 호출해서 인터럽트 된 상태를 false에서 true로 변경해서 카운터 실행을 중간에서
 * 중단시키는 예제이다.
 */
class Thread11 extends Thread{

	@Override
	public void run() {
		int i = 10;
		
		while(i != 0 && !isInterrupted()) {//isInterrupted()메서드는 쓰레드의 인터럽트 된 상태를 
			//boolean 타입으로 반환
			System.out.println(i--);//후행감소하면서 1씩 감소
			for(long x = 0; x < 2500000000L; x++);//시간 지연
		}
		System.out.println("카운터 종료~");
	}//쓰레드 문장 구현
}//쓰레드 클래스

public class ThreadTest11 {
	public static void main(String[] args) {
		Thread11 th = new Thread11();
		th.start();//스레드 시작
		
		String name = JOptionPane.showInputDialog("이름 입력");
		System.out.println("입력하신 이름 : "+name);
		
		th.interrupt();//스레드 인터럽트를 호출하면 인터럽트 된 상태가 false에서 true로 변경
		System.out.println("isInterrupted() 된 상태: "+ th.isInterrupted());
	}
}
