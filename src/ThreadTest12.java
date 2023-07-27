import javax.swing.JOptionPane;

class Thread12 extends Thread{

	@Override
	public void run() {
		int i = 10;
		
		while(i != 0 && !isInterrupted()) {
			System.out.println(i--);//후행 감소
			
			try {
				Thread.sleep(1000);//1초 간격
			}catch(InterruptedException ie) {
				//sleep()스레드 스케쥴링 메서드가 호출되면 InterruptedException 예외 오류가 발생하면서 인터럽트
				//된 상태가 false로 자동 초기화가 된다.
				interrupt();//다시 인터럽트를 호출하면 false가 된것이 true로 변경해서 카운터를 중단
			}
		}//while end
		System.out.println("카운터 종료");
	}//스레드 문장을 구현
}
public class ThreadTest12 {
	public static void main(String[] args) {
		Thread12 th = new Thread12();
		th.start();
		
		String name = JOptionPane.showInputDialog("이름을 입력하세요!");
		System.out.println("입력하신 이름 : "+name);
		th.interrupt();//스레드 인터럽트를 호출해서 false가 true로 변경
		System.out.println("인터럽트 된 상태 : "+th.isInterrupted());
	}
}
