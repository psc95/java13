/* 멀티스레드 입/출금 작업에서는 한번에 하나의 스레드에 의해서만 입/출금작업이 이루어 지도록 동기화 즉 임계영역을 지정해야
 * 한다. 이것을 알아 볼수 있는 예제이다.
 */
class Atm{
	private int money; //은행 계좌 잔액
	
	public Atm() {}//기본 생성자
	
	public Atm(int money) {
		this.money = money;//계좌 개설시 입금할 금액
	}
	
	//동기화가 처리된 입금작업
	synchronized void deposit(int amount,String name) {
		money += amount;
		System.out.println(name+" 입금금액 = "+amount);
	}
	
	//동기화가 처리된 출금 작업
	synchronized void withdraw(int amount,String name) {
		if((money - amount) > 0) {//출금 가능하면
			money -= amount;
			System.out.println(name+" 출금금액 = "+amount);
		}else {
			System.out.println(name+"잔액부족으로 출금못함");
		}
	}
	
	public void getMoney() {
		System.out.println("계좌 잔액 = "+money);
	}
}//Atm 계좌 클래스

class AtmUser extends Thread{
	boolean flag = false;//입금/출금 분기 해주는 변수
	Atm obj;
	
	public AtmUser() {}
	
	public AtmUser(Atm obj,String name) {
		super(name);//스레드 이름을 구함
		this.obj = obj;
	}

	@Override
	public void run() {
		for(int i = 1; i <= 5; i++) {
			try {sleep(500);}catch(InterruptedException ie) {}
			
			if(flag == true) {//==true는 생략 가능함
				obj.deposit((int)(Math.random()*10+2)*100, getName());
				/* random()은 0.0이상 1.0미만->*10하면 0.0이상 10.0미만 ->+2하면 2.0이상 12.0미만->
				 * (int)로 형변환 하면 2이상 12미만 ->*100하면 200이상 1200미만 즉 200부터 1100사이의 임의의 정수
				 * 숫자 난수 발생한다. getName()메서드는 스레드 이름을 반환
				 */
				obj.getMoney();//계좌 잔액을 출력
			}else {
				obj.withdraw((int)(Math.random()*10+2)*100, getName());
				obj.getMoney();
			}//if else
			flag = !flag;
		}//for
	}//스레드 문장 구현
}//스레드 클래스
public class ThreadTest08 {
	public static void main(String[] args) {
		Atm obj = new Atm(1000); //Atm 계좌 개설 하여 1000원 입금
		AtmUser user01 = new AtmUser(obj,"홍길동");
		AtmUser user02 = new AtmUser(obj,"이순신");
		AtmUser user03 = new AtmUser(obj,"강감찬");
		
		user01.start();//스레드 시작
		user02.start();
		user03.start();
	}
}
