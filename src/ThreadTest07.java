//동기화가 처리된 출금작업 스레드


class Account07 {
	private int balance = 1000;

	public int getBalance() {
		return balance;
	}

	//동기화가 처리된 출금=>락을 걸어서 하나의 쓰레드에 의해서만 출금작업이 이루어진다.
	public synchronized void withdraw(int money) {
		if(balance >= money) {
			try {Thread.sleep(1000);}catch(InterruptedException ie){}
			balance = balance - money;
		}
	}//synchronized 키워드에 의해서 임계영역 즉 동기화 처리

}//은행 계좌 클래스

class Thread07 extends Thread{
	Account07 acc = new Account07();

	@Override
	public void run() {
		while(acc.getBalance() > 0) {
			int money = (int)(Math.random()*3+1)*100;
			acc.withdraw(money);//실제 출금작업
			System.out.println("계좌 잔액 = "+acc.getBalance());
		}
	}//스레드 문장 구현
}//쓰레드 클래스
public class ThreadTest07 {
	public static void main(String[] args) {
		new Thread07().start();//첫번째 스레드 시작
		Thread07 th = new Thread07();
		th.start();//두번째 쓰레드 시작
	}
}
