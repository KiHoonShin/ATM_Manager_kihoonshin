package ATM;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Util {

	Scanner sc;
	private static String CUR_PATH = System.getProperty("user.dir")+"\\src\\"+ new Util().getClass().getPackageName()+"\\";
	// account.txt , client.txt
	Util(){
		sc = new Scanner(System.in);
		tempData();
	}
	
	void tempData() {
		String userData = "1001/test01/pw1/김철수\n";
		userData += "1002/test02/pw2/이영희\n";
		userData += "1003/test03/pw3/신민수\n";
		userData += "1004/test04/pw4/최상민";
		
		saveClientFile(userData);
		
		String accountData = "test01/1111-1111-1111/8000\n";
		accountData += "test02/2222-2222-2222/5000\n";
		accountData += "test01/3333-3333-3333/1100\n";
		accountData += "test03/4444-4444-4444/9000\n";
		accountData += "test01/5555-5555-5555/5400\n";
		accountData += "test02/6666-6666-6666/1000\n";
		accountData += "test03/7777-7777-7777/1000\n";
		accountData += "test04/8888-8888-8888/1000";
		
		saveAccountFile(accountData);
	}
	
	// user파일 저장
	private void saveClientFile(String userData) {
		String fileName = "client.txt";
		try(FileWriter fw = new FileWriter(CUR_PATH+fileName)){
			fw.write(userData);
		} catch (IOException e) {
			System.out.println("파일 저장 실패");
			e.printStackTrace();
		}
	}
	
	// account파일 저장
	private void saveAccountFile(String accountData) {
		String fileName = "account.txt";
		try(FileWriter fw = new FileWriter(CUR_PATH+fileName)){
			fw.write(accountData);
		} catch (IOException e) {
			System.out.println("파일 저장 실패");
			e.printStackTrace();
		}
	}
	
	
	// client 파일 로드
	public String roadClientFile() {
		String fileName = "client.txt";
		try(FileReader fr = new FileReader(CUR_PATH+fileName);
			BufferedReader br = new BufferedReader(fr);	){
			String data = "";
			while(true) {
				String line = br.readLine();
				if(line == null) break;
				data += line +"\n";
			}
			return data;
		} catch (IOException e) {
			System.out.println("파일 로드 실패");
			e.printStackTrace();
		}
		return null;
	}
	
	
	// account 파일 로드
	public String roadAccountFile() {
		String fileName = "account.txt";
		try(FileReader fr = new FileReader(CUR_PATH+fileName);
			BufferedReader br = new BufferedReader(fr);	){
			String data = "";
			while(true) {
				String line = br.readLine();
				if(line == null) break;
				data += line +"\n";
			}
			return data;
		} catch (IOException e) {
			System.out.println("파일 로드 실패");
			e.printStackTrace();
		}
		return null;
	}
	
	
	public int getInt(String msg, int start, int end) {
		while(true) {
			System.out.printf("▶ %s [%d~%d] 입력 : ", msg, start, end);
			try {
				int sel = sc.nextInt();
				sc.nextLine();
				if (sel < start || sel > end) {
					System.err.println("입력 오류");
					continue;
				}
				return sel;
			} catch (Exception e) {
				System.err.println("숫자만 입력하세요");
				sc.nextLine();
			}
		} //while
	}
	
	public String getStr(String msg) {
		System.out.printf("▶ %s : ", msg);
		String input = sc.next();
		return input;
	}
	
}
