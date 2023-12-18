package ATM;

import java.util.Scanner;

public class Util {

	Scanner sc;
	
	// account.txt , client.txt
	Util(){
		sc = new Scanner(System.in);
	}
	
	void tempData() {
		String userData = "1001/test01/pw1/김철수\n";
		userData += "1002/test02/pw2/이영희\n";
		userData += "1003/test03/pw3/신민수\n";
		userData += "1004/test04/pw4/최상민";
		
		String accountData = "test01/1111-1111-1111/8000\n";
		accountData += "test02/2222-2222-2222/5000\n";
		accountData += "test01/3333-3333-3333/1100\n";
		accountData += "test03/4444-4444-4444/9000\n";
		accountData += "test01/5555-5555-5555/5400\n";
		accountData += "test02/6666-6666-6666/1000\n";
		accountData += "test03/7777-7777-7777/1000\n";
		accountData += "test04/8888-8888-8888/1000";
	}
	
	public int getInt(String msg, int start, int end) {
		while(true) {
			System.out.printf("▶ %s [%d~%d] 입력 : %n", msg, start, end);
			try {
				int sel = sc.nextInt();
				sc.nextLine();
				if (sel < start || sel > end) {
					System.out.println("입력 오류");
					continue;
				}
				return sel;
			} catch (Exception e) {
				System.out.println("숫자만 입력하세요");
				sc.nextLine();
			}
		} //while
	}
	
	
}
