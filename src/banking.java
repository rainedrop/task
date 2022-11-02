import java.util.Scanner;

class Bank {
	static Scanner sc = new Scanner(System.in);
	static int balance;

	public char menu() {
		while (true) {
			System.out.print("# 메뉴를 선택하시오(i-입금, o-출금, q-종료) : ");
			char menu = sc.next().charAt(0);
			switch (menu) {
			case 'i', 'o', 'q':
				return menu;
			default:
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}
		}
	}

	public int inputInt(String menu) {
		int iNum = 0;

		while (true) {
			switch (menu) {
			case "i":
				System.out.print("# 입금액을 입력해주세요 : ");
				break;
			case "o":
				System.out.print("# 출금액을 입력해주세요 : ");
				break;
			}
			try {
				iNum = sc.nextInt();
			} catch (Exception e) {
				System.out.println("잘못된 값을 입력하셨습니다.");
//				sc = new Scanner(System.in);
				sc.nextLine();
				continue;
			}
			if (iNum >= 0)
				return iNum;
			else
				System.out.println("잘못 입력하셨습니다.");
			continue;
		}
	}

	public void deposit(int iSum) { // 입금처리 함수
		balance += iSum;
	}

	public void withdraw(int iSum) { // 출금처리 함수
		if (iSum > balance) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		balance -= iSum;
	}

	public void cal(String menu, int iSum) {
		switch (menu) {
		case "i":
			deposit(iSum);
			break;
		case "o":
			withdraw(iSum);
			break;
		case "q":
			sc.close();
			System.exit(0);
		}
	}
}

public class Banking {
	public static void main(String[] args) {
		Bank bank = new Bank();

		while (true) {
			System.out.println("잔액은 " + bank.balance + "입니다 \n");

			String menu = Character.toString(bank.menu());
			int iSum = bank.inputInt(menu);
			bank.cal(menu, iSum);
		}
	}
}