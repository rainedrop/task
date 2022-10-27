import java.util.Scanner;

public class banking {

	public static int balance = 0; // 잔액
	static Scanner sc = new Scanner(System.in); // 스캐너

	public static char menu() { // 메뉴
		while (true) {
			System.out.print("# 메뉴를 선택하시오(i-입금, o-출금, q-종료) : ");
			char menu = sc.next().charAt(0);
			if (menu == 'i' || menu == 'o' || menu == 'q')
				return menu;
			else
				continue;
		}
	}

	public static int inputint(String menu) { // 인풋인트
		int iNum = 0;
		while (true) {
			try {
				switch (menu) {

				case "i":
					System.out.print("# 입금액을 입력해주세요 : ");
					iNum = sc.nextInt();
					break;
				case "o":
					System.out.print("# 출금액을 입력해주세요 : ");
					iNum = sc.nextInt();
					break;
				}

			} catch (Exception e) {
				System.out.println("잘못된 값을 입력하셨습니다.");
				sc = new Scanner(System.in);
				continue;
			} return iNum;
		} 
	}

	public static void deposit(int iSum) { // 입금처리 함수
		balance += iSum;
	}

	public static void withdraw(int iSum) { // 출금처리 함수
		if (iSum > balance) {
			System.out.println("잔액이 부족합니다.");
		} else
			balance -= iSum;
	}

	public static void main(String[] args) {
		int iSum = 0;

		while (true) {

			System.out.println("현재 잔액은 " + balance + "입니다.\n");

			String menu = Character.toString(menu());

			iSum = inputint(menu);

			while (true) {
				if (iSum < 0) {
					System.out.println("잘못 입력하셨습니다.");
					iSum = inputint(menu);
					continue;
				} else
					break;
			}

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
}