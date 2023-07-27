import javax.swing.JOptionPane;

/*멀티스레드가 아닌 단일 프로그램이다.즉 하나의 프로그램이 끝이 나야 다음 프로그램이 실행된다. */

public class ThreadTest09 {
	public static void main(String[] args) {
		
		String inputName = JOptionPane.showInputDialog("이름을 입력하세요");
		//JOptionPane.showInputDialog 스윙 ui는 확인 취소 버튼을 가지고 메시지를 담고 입력필드를 가진
		//다일로그 창을 만든다.
		System.out.println("입력하신 이름 : "+inputName);
		
		for(int i = 10; i >= 1; i--) {
			System.out.println(i);
			
			try {
				Thread.sleep(1000);//1초간 잠시 일시 정지
			}catch(InterruptedException ie) {}
		}//for end
	}
}
